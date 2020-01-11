package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Leaderboard extends Application {

    private TableView<User> table = new TableView();
    private ObservableList<User> data = FXCollections.observableArrayList();
    Connection con;
    PreparedStatement st;
    ResultSet rs;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        initializeDB();
        setTable();

        TextField tfAddUsername = new TextField();
        tfAddUsername.setPromptText("Username");
        TextField tfAddScore = new TextField();
        tfAddScore.setPromptText("Score");

        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().add(table);

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Leaderboard");
        stage.show();
    }

    private void initializeDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "120500");
            st = con.prepareStatement("SELECT * FROM fruitjanissarydb.leaderboard ORDER BY Score DESC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setTable() {
        try {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                data.add(new User(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TableColumn<User, String> colUsername = new TableColumn("Username");
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colUsername.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

        TableColumn<User, Integer> colScore = new TableColumn("Score");
        colScore.setCellValueFactory(new PropertyValueFactory<User, Integer>("userScore"));
        colScore.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

        table.getColumns().addAll(colUsername, colScore);
        table.setItems(data);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
