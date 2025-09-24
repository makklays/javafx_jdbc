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
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TaskController implements Initializable {
    @FXML
    private AnchorPane leftContentPane;
    @FXML
    private AnchorPane rightContentPane;

    @FXML
    private Button CreditCardButton;
    @FXML
    private Button ChannelsButton;
    @FXML
    private Button CompaniesButton;
    @FXML
    private Button UploadDatasButton;
    @FXML
    private Button StatisticsButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Button TasksButton;
    @FXML
    private Button AddTaskButton;
    @FXML
    private Button ListTasksButton;
    @FXML
    private Button AddNewTaskButton;
    @FXML
    private Button CancelTaskButton;
    @FXML
    private TextField TitleText;
    @FXML
    private TextArea DescrArea;
    @FXML
    private Label AlertText;

    @FXML
    private TableColumn<Task, Integer> Column1;
    @FXML
    private TableColumn<Task, String> Column2;
    @FXML
    private TableColumn<Task, String> Column3;
    @FXML
    private TableView<Task> TasksTable;
    @FXML
    private Button ExitButton;

    @FXML
    private Label titleLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Button CloseDetailsButton;

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
            /*Task task = new Task(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status")
            );*/
            Task tasks = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("status"));
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

    // открываем одну выбранную таску
    private void openTaskDetails(Task task) {
        try {
            // Загружаем FXML для новой "страницы" в том же окне
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/techmatrix/javafx_jdbc/task-details.fxml"));
            Parent root = fxmlLoader.load();

            // Получаем контроллер новой сцены
            TaskController controller = fxmlLoader.getController();

            // Передаём данные задачи
            controller.titleLabel.setText(task.getTitle());
            controller.statusLabel.setText(task.getStatus());
            controller.descriptionLabel.setText(task.getDescription());

            // Меняем содержимое текущей сцены
            // Загружаем содержимое в правый блок
            rightContentPane.getChildren().setAll(root);

            // Опционально, чтобы taskDetailsRoot растягивался на весь AnchorPane:
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCloseDetailsButtonClick(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CloseDetailsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onAddTaskButton(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        boolean connect = validate_form();
        if (connect) {
            // add channel to database
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            // get currenct user_id
            Long currentUserId = Session.getInstance().getUserId();

            String sql1 = "INSERT INTO tasks (user_id, title, description, status) VALUES (?, ?, ?, ?) ";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, String.valueOf(currentUserId));
            stmt1.setString(2, TitleText.getText());
            stmt1.setString(3, DescrArea.getText());
            stmt1.setString(4, "not_completed");

            int i = stmt1.executeUpdate();
            if (i > 0) {
                AlertText.setTextFill(Color.GREEN);
                AlertText.setText("You inserted successfully");

                System.out.println("You inserted successfully");
            } else {
                AlertText.setTextFill(Color.RED);
                AlertText.setText("Can't insert task in the database");

                System.out.println("Can't insert task in the database");
            }

            // Out
            System.out.println("Task ==> " + TitleText.getText() + " --- " + DescrArea.getText());

            // redirect to list of tasks
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
            Stage primaryStage = (Stage) AddTaskButton.getScene().getWindow();
            primaryStage.setScene(scene1);
        } else {
            AlertText.setTextFill(Color.RED);
        }
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
    public void onCancelTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        // redirect to list of channels
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CancelTaskButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onAddNewTaskButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-task.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) AddTaskButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onListTasksButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ListTasksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    //-- menu --

    @FXML
    public void onListChannelsButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ListTasksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void CreditCardButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void ChannelsButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> channel click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ChannelsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void CompaniesButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> company click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CompaniesButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void UploadDatasButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> upload datas click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("upload-datas-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) UploadDatasButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void StatisticsButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> statistics click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("statistics-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) StatisticsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void InfoButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> info click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) InfoButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void TasksButton() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) TasksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void ExitButton(ActionEvent actionEvent) throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //
}

