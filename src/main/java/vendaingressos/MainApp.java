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

    public static void showHomeAdmin() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/views/homeAdmin.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showHomeUser() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/views/homeUser.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*******************************
 Autor: Felipe Amorim do Carmo Silva
 Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
 Concluído em: 01/12/2024
 Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ********************************/