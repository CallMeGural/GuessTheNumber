package guesser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {
	int theNumber = (int) (Math.random()*100+1);
	int shot=-1;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button guessButton;
	@FXML
	private Button tryAgainButton;
	@FXML
	private Label promptLabel;
	@FXML
	private TextField guessBox;
	
	Stage stage;
	
	public void guessNumber() {
		try {
			shot = Integer.parseInt(guessBox.getText());
			
			if(shot==theNumber) {
				promptLabel.setText("Congrats! You guessed the number corectly!");
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("You won!");
				alert.setHeaderText("Congrats! You guessed the number corectly!");
				alert.setContentText("Would you like to try again?");
				
				if(alert.showAndWait().get()==ButtonType.OK) {
					generateNumber();
				}
				else {
					stage = (Stage) pane.getScene().getWindow();
					stage.close();
				}
				
				
			} 
			else if(shot < theNumber) promptLabel.setText("We need to be going up!");
			else if(shot > theNumber) promptLabel.setText("We need to be going down!");
			
		} catch(NumberFormatException e) {
			promptLabel.setText("Enter only a number, please!");
		}
	}
	
	public void generateNumber() {
		theNumber = (int) (Math.random()*100+1);
		System.out.println(theNumber);
	}
}
