package com.mycompany.mvvmexample;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author George
 */
public class SignUp {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    @FXML
    private void switchToSignIn(){
        try {
            App.setRoot("SignIn.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void SignUp(){
        DocumentReference docRef = App.fstore.collection("SignIn").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("username", username.getText());
        data.put("password", password.getText());
        ApiFuture<WriteResult> result = docRef.set(data);
    }
}
