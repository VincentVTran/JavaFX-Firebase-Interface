package Main;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class FirebaseAccess {
    private String firebase_url = "";
    private Firebase current_firebase;
    private FirebaseResponse action;

    public FirebaseAccess(){
    }

    protected void connectFirebase(String link){
        firebase_url = link;
        try{
            current_firebase = new Firebase(firebase_url);
        }
        catch(FirebaseException e){
            JOptionPane.showMessageDialog(null, "Connection failed");
        }
    }


    protected void saveData(Map<String, Object> data){
        try {
            action = current_firebase.patch(data);
            JOptionPane.showMessageDialog(null, "Insertion complete");
        }
        catch(FirebaseException | UnsupportedEncodingException | JacksonUtilityException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    protected void getData(String username){
        try {
            action = current_firebase.get(username);
            JOptionPane.showMessageDialog(null, action.toString());
        }
        catch(FirebaseException | UnsupportedEncodingException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
