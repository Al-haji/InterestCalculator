/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments_final;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField current_age;

    @FXML
    private TextField monthly_contribution;

    @FXML
    private TextField year;

    @FXML
    private TextField retirement_age;

    @FXML
    private TextField interest;

    @FXML
    private TextField yearly_interest;

    @FXML
    private TextField total;

    @FXML
    private TextField yearly_investment;

    @FXML
    private Button buttonCalculate;
    
    @FXML
    private TextField years_worked;


    @FXML
    void calculate(ActionEvent event) {
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
