package com.techmatrix.javafx_jdbc.view;

import com.techmatrix.javafx_jdbc.configuration.DbmsConnection;
import com.techmatrix.javafx_jdbc.HelloApplication;
import com.techmatrix.javafx_jdbc.model.Task;
import com.techmatrix.javafx_jdbc.utils.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Task2Controller implements Initializable {

    @FXML private Button AddNewTaskButton;
    @FXML private TableView<Task> TasksTable;
    @FXML private TableColumn<?, ?> Column1;
    @FXML private TableColumn<?, ?> Column2;
    @FXML private TableColumn<?, ?> Column3;

    @FXML private Label AlertText;
    @FXML private TextField TitleText;
    @FXML private TextArea DescrArea;

    @FXML private Label AlertTextAdd;
    @FXML private TextField TitleTextAdd;
    @FXML private TextArea DescrAreaAdd;

    @FXML private Label titleLabel;
    @FXML private Label statusLabel;
    @FXML private Label descriptionLabel;

    @FXML private AnchorPane taskListBlock;
    @FXML private AnchorPane taskDetailBlock;
    @FXML private AnchorPane taskAddBlock;
    @FXML private AnchorPane taskEditBlock;

    private ObservableList<Task> tasksList = FXCollections.observableArrayList();

    private Task currentTask; // хранит выбранную задачу

    ObservableList<Task> initialData() throws SQLException, ClassNotFoundException {
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        // get currenct user_id
        Long currentUserId = Session.getInstance().getUserId();

        String sql = "SELECT * FROM tasks ORDER BY updated_at DESC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<Task> list = FXCollections.observableArrayList();

        while(rs.next()) {
            Task tasks = new Task(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status")
            );
            //Task tasks = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("status"));
            list.add(tasks);
        }

        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (TasksTable != null) {
            Column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
            Column2.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Column3.setCellValueFactory(new PropertyValueFactory<>("Status"));

            // при клике на выбранном элементе
            TasksTable.setRowFactory(tv -> {
                TableRow<Task> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (!row.isEmpty() && event.getClickCount() == 2) {
                        Task clickedTask = row.getItem();
                        openTaskDetails(clickedTask);
                    }
                });
                return row;
            });

            try {
                TasksTable.setItems(initialData());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void openTaskDetails(Task task) {
        currentTask = task; // сохраняем выбранную задачу

        System.out.println("Открываем задачу: " + task.getTitle());

        // скрываем список тасок
        taskListBlock.setVisible(false);
        // отображаем выбранную таску
        taskDetailBlock.setVisible(true);

        titleLabel.setText(task.getTitle());
        statusLabel.setText(task.getStatus());
        descriptionLabel.setText(task.getDescription());

        /*
        Navigator.load("task2-details.fxml", (Task2DetailsController controller) -> {
            controller.setTaskId(id);
        });*/
    }

    @FXML
    protected void onAddNewTaskButton() throws IOException, SQLException {
        // Навигация в форму добавления задачи
        //Navigator.load("task2-add.fxml");

        taskDetailBlock.setVisible(false);
        taskListBlock.setVisible(false);
        taskAddBlock.setVisible(true);
        taskEditBlock.setVisible(false);
    }

    public boolean validate_form() {
        boolean proceed = true;
        if (TitleText.getText().isEmpty() && proceed == true) {
            AlertText.setText("Enter Title");
            proceed = false;
        }
        if (DescrArea.getText().isEmpty() && proceed == true) {
            AlertText.setText("Enter description");
            proceed = false;
        }

        return proceed;
    }

    @FXML
    public void onSendDataAddTaskButton(ActionEvent actionEvent) {
        // validation
        if (TitleTextAdd.getText().isEmpty()) {
            AlertTextAdd.setTextFill(Color.RED);
            AlertTextAdd.setText("Title cannot be empty");
            return;
        }

        try {
            Connection con = DbmsConnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO tasks (user_id, title, description, status) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            // get currenct user_id
            Long currentUserId = Session.getInstance().getUserId();

            //stmt.setLong(1, Session.getInstance().getUserId());
            stmt.setLong(1, 1L);
            stmt.setString(2, TitleTextAdd.getText());
            stmt.setString(3, DescrAreaAdd.getText());
            stmt.setString(4, "not_completed");

            int i = stmt.executeUpdate();
            if (i > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                long newId = rs.next() ? rs.getLong(1) : 0;

                Task newTask = new Task((int)newId, 1, TitleTextAdd.getText(), DescrAreaAdd.getText(), "not_completed");
                tasksList.add(newTask); // это обновит TableView
                //TasksTable.setItems(tasksList);
                //TasksTable.refresh();

                AlertTextAdd.setTextFill(Color.GREEN);
                AlertTextAdd.setText("Inserted successfully");

                taskListBlock.setVisible(true);
                taskDetailBlock.setVisible(false);
                taskAddBlock.setVisible(false);
                taskEditBlock.setVisible(false);

            } else {
                AlertTextAdd.setTextFill(Color.RED);
                AlertTextAdd.setText("Insert failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            AlertTextAdd.setTextFill(Color.RED);
            AlertTextAdd.setText("Database error");
        }
    }

    @FXML
    public void onCancelTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        Navigator.load("tasks2.fxml");
    }

    @FXML
    public void onListTasksButton(ActionEvent actionEvent) throws IOException, SQLException {
        Navigator.load("tasks2.fxml");
    }

    @FXML
    public void onDeleteTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (currentTask == null) return;

        try {
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, currentTask.getId()); // или setInt() в зависимости от типа id
            int affectedRows = stmt.executeUpdate();

            System.out.println("Удалено строк: " + affectedRows);

            // Скрываем блок деталей и показываем список
            taskDetailBlock.setVisible(false);
            taskDetailBlock.setManaged(false);

            taskListBlock.setVisible(true);
            taskListBlock.setManaged(true);

            // Обновляем TableView
            TasksTable.getItems().remove(currentTask);

            currentTask = null; // очищаем ссылку
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (currentTask == null) return;

        taskDetailBlock.setVisible(false);
        taskListBlock.setVisible(false);
        taskAddBlock.setVisible(false);
        taskEditBlock.setVisible(true);

        TitleText.setText(currentTask.getTitle());
        DescrArea.setText(currentTask.getDescription());

        System.out.println("Редактируется таска: " + currentTask.getTitle());
    }

    @FXML
    public void onSendDataEditTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (currentTask == null) return;

        try {
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            String sql = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, TitleText.getText());
            stmt.setString(2, DescrArea.getText());
            stmt.setLong(3, currentTask.getId()); // или setInt() в зависимости от типа id

            int i = stmt.executeUpdate();
            if (i > 0) {
                AlertText.setTextFill(Color.GREEN);
                AlertText.setText("You updated successfully");

                System.out.println("You updated successfully");

                // Здесь обновляем TableView
                int index = tasksList.indexOf(currentTask);  // tasksList — ObservableList для TableView
                currentTask.setTitle(TitleText.getText());
                currentTask.setDescription(DescrArea.getText());
                //tasksList.set(index, currentTask); // таблица обновится автоматически
                TasksTable.refresh(); // таблица обновится автоматически

            } else {
                AlertText.setTextFill(Color.RED);
                AlertText.setText("Can't update task in the database");

                System.out.println("Can't update task in the database");
            }

            // Скрываем блок реадктирования, блок деталей и показываем список
            taskEditBlock.setVisible(false);
            taskAddBlock.setVisible(false);
            taskDetailBlock.setVisible(false);
            taskListBlock.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

