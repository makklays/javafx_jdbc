package com.example.demo3.view;

import com.example.demo3.HelloApplication;

import com.example.demo3.dao.ChannelEntity;
import com.example.demo3.utils.HibernateSessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.*;
import java.sql.SQLException;

public class InfoController {
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
    private Button ExitButton;
    @FXML
    private Button ProsmotrButton;

    @FXML
    public void CreditCardButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void ChannelsButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ChannelsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void CompaniesButton(ActionEvent actionEvent) throws IOException, SQLException {
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("statistics-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) StatisticsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void InfoButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) InfoButton.getScene().getWindow();
        primaryStage.setScene(scene1);

        //--- Hibernate --------------
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setTitle("Nick");
        channelEntity.setDescription("VN");
        //channelEntity.setBirthDate(new java.util.Date());

        session.save(channelEntity);
        session.getTransaction().commit();
        session.close();
        //--- END Hibernate ----------
    }

    @FXML
    public void onProsmotrClick(ActionEvent actionEvent) throws IOException, SQLException {
        // TODO: check proxy ip
        // curl -x http://proxy_server:proxy_port --proxy-user username:password -L http://url
        // when check it - what function ?

        // send request
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "217.29.53.133");
        System.setProperty("http.proxyPort", "80"); //
        System.setProperty("http.proxyUser" , "gEehc5");
        System.setProperty("http.proxyPassword" , "P2fkdU");

        URL site = new URL("https://t.me/minu_odin/3");
        HttpURLConnection connection = (HttpURLConnection) site.openConnection();

        connection.setRequestMethod("GET");
        connection.setReadTimeout(90*1000);
        connection.connect();
        System.out.println(connection.getResponseMessage()+" ---- "+connection.getResponseCode()+" ----- "+connection.getContent());

        // variant 2
        /*Proxy proxy1 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("217.29.53.133", 8080));
        URL url1 = new URL("https://t.me/minu_odin/3");
        HttpURLConnection uc = (HttpURLConnection)url1.openConnection(proxy1);
        uc.connect();

        System.out.println(uc.getResponseMessage()+" ---- "+uc.getResponseCode()+" ----- "+uc.getContent());

        StringBuffer tmp = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line;
        while ((line = in.readLine()) != null){
            System.out.println(line);
        }*/

        // variant 3
        /*var url = new URL("https://t.me/minu_odin/3");
        var proxyAddress = new InetSocketAddress("217.29.62.250", 12011);

        var proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
        var connection = (URLConnection) url.openConnection(proxy);

        try (var inputStream = connection.getInputStream()) {
            var bytes = inputStream.readAllBytes();
            var content = new String(bytes);
            System.out.println("IP: " + content);
        }*/

        // variant 4
        /*CloseableHttpClient httpclient = HttpClients.custom().useSystemProperties().build();
        try {
            HttpGet httpGet = new HttpGet("http://www.google.com");
            CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
            try {
                System.out.println(httpResponse.getStatusLine());
                for (Header header : response.getAllHeaders()) {
                    System.out.println("header " + header.getName() + " - " + header.getValue());
                }
                String responseString = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("responseString :" + responseString);
            } finally {
                response.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            httpclient.close();
        }*/
    }

    @FXML
    public void TasksButton(ActionEvent actionEvent) throws IOException, SQLException {
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
