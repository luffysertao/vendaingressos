package vendaingressos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        primaryStage.setTitle("Omrac Events");

        showLoginScreen();
    }

    // Tela de login
    public static void showLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/views/login.fxml"));
        Scene scene = new Scene(loader.load(), 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Tela de registro
    public static void showRegisterScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/views/register.fxml"));
        Scene scene = new Scene(loader.load(), 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
