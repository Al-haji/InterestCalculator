 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments_final;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Hassan
 */
public class FXMLDocumentController extends   Investments_final implements Initializable {
    
    @FXML
    private AnchorPane anchor;
    
    @FXML
    public TextField current_age;

    @FXML
    public TextField monthly_contribution;

    @FXML
    public TextField year;

    @FXML
    public TextField retirement_age;

    @FXML
    public TextField interest;

    @FXML
    public TextField yearly_interest;

    @FXML
    public TextField total;

    @FXML
    public TextField yearly_investment;

    @FXML
    public Button buttonCalculate;
    
    @FXML
    public TextField years_worked;
    
    private double dragOffsetX;
   private double dragOffsetY;


    @FXML
    void calculate(ActionEvent event) {
        
        current_age.setId("current_age");
        monthly_contribution.setId("monthly_contribution");
        year.setId("year");
        retirement_age.setId("retirement_age");
        interest.setId("interest");
        yearly_interest.setId("yearly_interest");
        total.setId("total");
        yearly_investment.setId("yearly_investment");
        buttonCalculate.setId("calcBtn");
        years_worked.setId("years_worked");
        buttonCalculate.setStyle("-fx-background-color:#449d44;");
       anchor.getScene().getStylesheets().add("/stylesheets/normal.css");
        
        if (current_age.getText().isEmpty() || monthly_contribution.getText().isEmpty() || retirement_age.getText().isEmpty() || interest.getText().isEmpty() ){
            int response = JOptionPane.showConfirmDialog(
        null,"Monthly contribution, current age, interest and retirement age should not be empty","Required Input",JOptionPane.DEFAULT_OPTION);
            yearly_interest.setText("0");
           total.setText("0");
           yearly_investment.setText("0");
           years_worked.setText("0");       
                    
           anchor.getScene().getStylesheets().add("/stylesheets/Look.css");
         
                 
            
        }
        else {
        try{
            
            anchor.getScene().getStylesheets().add("/stylesheets/normal.css");
        
        int currentAge=Integer.parseInt(current_age.getText());
    int retirementAge=Integer.parseInt(retirement_age.getText());
    int monthly_cont=Integer.parseInt(monthly_contribution.getText());
    double interestPct=Double.parseDouble(interest.getText())/100;
    
    int working_years=retirementAge-currentAge;
    
    int x=0;
    int yearlyInt=0;
    int totalAmount=0;
    int yearlyInvest=0;
    
    do{
            x++;
        yearlyInvest=monthly_cont*12;
        yearlyInt=(int)((yearlyInvest+totalAmount)*interestPct);
        totalAmount=totalAmount+yearlyInt+yearlyInvest;
        
       if(year.getText().isEmpty()){
          
          if((x==working_years)){
              yearly_interest.setText(String.valueOf(yearlyInt));
           total.setText(String.valueOf(totalAmount));
           yearly_investment.setText(String.valueOf(yearlyInvest));
           years_worked.setText(String.valueOf(working_years));
           break;
              
          }           
           
       }
      else if(x==Integer.parseInt(year.getText())){
          
           yearly_interest.setText(String.valueOf(yearlyInt));
           total.setText(String.valueOf(totalAmount));
           yearly_investment.setText(String.valueOf(yearlyInvest));
           years_worked.setText(String.valueOf(working_years));
           break;
                    
      }
              /*(year.getText().isEmpty()==false){
          working_years=Integer.parseInt(year.getText())-currentAge;
          if(x==working_years){
               yearly_interest.setText(String.valueOf(yearlyInt));
           total.setText(String.valueOf(totalAmount));
           yearly_investment.setText(String.valueOf(yearlyInvest));
           break;
          }
      }*/
      else {
         
          yearly_interest.setText("0");
           total.setText("0");
           yearly_investment.setText("0");
           years_worked.setText("0");
           
      }
        }
    
        while(working_years>x);
    System.out.println(total.getLength());

    }
        catch (NumberFormatException e){
            int response = JOptionPane.showConfirmDialog(
        null,"Only Integers are needed, please check your input ","Error",JOptionPane.DEFAULT_OPTION);              
        }
    }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       // Set mouse pressed and dragged even handlers for the scene
      // Scene nw=(Scene) anchor.getScene();
    /* anchor.getScene().setOnMousePressed(e -> handleMousePressed(e));
     anchor.getScene().setOnMouseDragged(e -> handleMouseDragged(e));*/
    
    }    
/*
    private void handleMousePressed(javafx.scene.input.MouseEvent e) {
        Parent sroot = anchor.getScene().getRoot();
        // Store the mouse x and y coordinates with respect to the
         // stage in the reference variables to use them in the drag event
         Stage stage = (Stage) anchor.getScene().getWindow();
     this.dragOffsetX = e.getScreenX() - stage.getX();
      this.dragOffsetY = e.getScreenY() - stage.getY();
     
    }

    private void handleMouseDragged(javafx.scene.input.MouseEvent e) {
        // Move the stage by the drag amount
        Stage stage = (Stage) anchor.getScene().getWindow();
      stage.setX(e.getScreenX() - this.dragOffsetX);
      stage.setY(e.getScreenY() - this.dragOffsetY);
      
    }*/
    
}
