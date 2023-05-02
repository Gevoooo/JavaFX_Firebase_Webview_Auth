package com.mycompany.mvvmexample;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author juilliardwu
 */
public class SignIn {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    @FXML
    private void SignInButton() throws IOException{
        CollectionReference userTable = App.fstore.collection("SignIn");
        ApiFuture<QuerySnapshot> query = userTable.whereEqualTo("username", username.getText()).whereEqualTo("password", password.getText()).get();
        try {
            if(!query.get().getDocuments().isEmpty()){
                App.username = username.getText();
                App.password = password.getText();
                switchAccessFBView();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void switchToSignUp() {
        try {
            App.setRoot("SignUpMenu.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void switchAccessFBView() {
        try {
            App.setRoot("AccessFBView.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
