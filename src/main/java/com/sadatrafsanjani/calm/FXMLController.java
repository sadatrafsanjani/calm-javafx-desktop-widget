package com.sadatrafsanjani.calm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class FXMLController implements Initializable {
    
    private String os;
    @FXML
    private Button shut, restart, lock;
    
    @FXML
    public void shutDownAction(ActionEvent event) {
        
        if(os.contains("Windows")){
            executeCommand("shutdown -s -t 5");
        }
        else{
            System.out.println("Not Supported!");
        }
    }
    
    @FXML
    public void restartAction(ActionEvent event) {
        
        if(os.contains("Windows")){
            executeCommand("shutdown -r -t 5");
        }
        else{
            System.out.println("Not Supported!");
        }
    }
    
    @FXML
    public void lockAction(ActionEvent event) {
        
        if(os.contains("Windows")){
            executeCommand("rundll32.exe user32.dll, LockWorkStation");
        }
        else{
            System.out.println("Not Supported!");
        }
    }
    
    private void executeCommand(String command){
    
        try{
            Runtime.getRuntime().exec(command);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void quitAction(ActionEvent event) {
        
        System.exit(0);
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shut.setTooltip(new Tooltip("Shutdown"));
        restart.setTooltip(new Tooltip("Restart"));
        lock.setTooltip(new Tooltip("Lock"));
        os = System.getProperty("os.name");
    }    
}
