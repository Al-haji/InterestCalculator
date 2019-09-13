/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class Investments_final extends Application {
    
    //https://stackoverflow.com/questions/34033119/how-to-make-transparent-scene-and-stage-in-javafx

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.resizableProperty();
        root.setStyle("-fx-background-color: transparent;");
        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        Rectangle rect = new Rectangle(1024, 768);
        /*rect.setArcHeight(60.0);
        rect.setArcWidth(60.0);*/
        
      
        scene.setFill(Color.TRANSPARENT);
        root.setId("ROOTNODE");
        root.setClip(rect);
        root.setStyle("-fx-background-radius: 30;\n"
                + "-fx-border-radius: 30;\n"
                + "-fx-border-width:5;\n"
                + "-fx-border-color:blue;\n"
                /*+ "-fx-background-color:rgba(0,0,0,1);\n"*/);

        //stage.setOpacity(0.2);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
