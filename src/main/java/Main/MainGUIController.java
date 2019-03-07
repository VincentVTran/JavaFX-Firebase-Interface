package Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.service.Firebase;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainGUIController {
    @FXML
    TextField BaseURL,Value,DataLabel;

    @FXML
    Button URLConfirm,DataConfirm;

    public void URLChange(){
        try {
            FirebaseAccess.firebase = new Firebase(BaseURL.getText());
        } catch (FirebaseException e) {
            e.printStackTrace();
        }
    }

    public void DataChange() throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        Map<String, Object> dataset = new LinkedHashMap<String, Object>();
        dataset.put(DataLabel.getText(),Value.getText());
            FirebaseAccess.response = FirebaseAccess.firebase.put(dataset);
    }

}
