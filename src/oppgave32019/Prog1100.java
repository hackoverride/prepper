package oppgave32019;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Prog1100 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	public void start(Stage vinduet) {
		/*
		 * inn: Lengden, diameter, dybden.
		 */
		FlowPane root = new FlowPane();
		Label tittel = new Label("Oppgi målene på oljetanken i fletene under!");
		Label labelL = new Label("Tanklengde L i cm:");
		TextField innL = new TextField();
		Label labelH = new Label("Tankhøyde H i cm:");
		TextField innH = new TextField();
		Label labelD = new Label("Oljedybden D i cm:");
		TextField innD = new TextField();
		Label labelRest = new Label("Oljerestvolum i liter:");
		TextField restLiter = new TextField();
		restLiter.setDisable(true);
		root.getChildren().addAll(tittel, labelL, innL, labelH, innH, labelD, innD, labelRest, restLiter);
		root.setAlignment(Pos.CENTER);
		Button beregn = new Button("Beregn restvolum");
		Button blank = new Button("Blank Ut");
		root.getChildren().addAll(beregn, blank);
		vinduet.setScene(new Scene(root, 300, 200));
		vinduet.setTitle("OljeKalkulator'n");
		vinduet.show();
		
		beregn.setOnAction(event -> {
			double lengde = Double.parseDouble(innL.getText());
			double hoyde = Double.parseDouble(innH.getText());
			double dybde = Double.parseDouble(innD.getText());
			double radius = (hoyde/2);
			double del1 = Math.acos((radius - dybde)/radius);
			double del2 = Math.sqrt(dybde*(2*radius -dybde));
			double beregning = lengde*(Math.pow(radius, 2)*del1 - (radius - dybde) * del2 );
			restLiter.setText("" + (int)(beregning/1000));
		});
		
		blank.setOnAction(event -> {
			innL.clear();
			innH.clear();
			innD.clear();
			restLiter.clear();
		});
		
	}
	
	

	
	// volum : 
	
	
}
