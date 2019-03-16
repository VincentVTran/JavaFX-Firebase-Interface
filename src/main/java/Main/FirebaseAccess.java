package Main;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.codehaus.jackson.annotate.JacksonAnnotation;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class FirebaseAccess {
    private String firebase_url = "https://test-3561a.firebaseio.com/";
    private Firebase current_firebase;
    private FirebaseResponse action;

    public FirebaseAccess(){
        try{
            current_firebase = new Firebase(firebase_url);
        }
        catch(FirebaseException e){
            System.out.println("Firebase connection failed");
        }
    }

    protected void saveData(Map<String, Object> data){
        try {
            action = current_firebase.put(data);
            JOptionPane.showMessageDialog(null, "Insertion complete");
        }
        catch(FirebaseException | UnsupportedEncodingException | JacksonUtilityException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
