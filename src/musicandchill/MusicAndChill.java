/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicandchill;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author paul.luna
 */
public class MusicAndChill extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ReproductorMp3 activarRepro = new ReproductorMp3();
        activarRepro.setVisible(true);
        activarRepro.setSize(405, 350);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
