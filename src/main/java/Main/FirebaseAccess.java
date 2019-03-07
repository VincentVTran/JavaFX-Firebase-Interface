package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class FirebaseAccess extends Application {
    static FirebaseResponse response;
    static Firebase firebase;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FirebaseAccess invoke = new FirebaseAccess();
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MainGUI.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root,800,600));
        }
        catch(Exception e){
            System.out.println("Idk");
            e.printStackTrace();
        }
        invoke.initialize();
        //primaryStage.setScene(new Scene(,600,400));
        primaryStage.show();
    }
    private void initialize(){
        String firebase_baseUrl = "https://test-3561a.firebaseio.com/";
        try {
            firebase = new Firebase( firebase_baseUrl );
        } catch (FirebaseException e) {
            e.printStackTrace();
        }
    }

}
