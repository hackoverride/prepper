package sunday;

import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sunday extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Oversikt over strikketøy
		 * 
		 */
		
		
		launch(args);
		
	}
	
	/* global input variables */
	Database db = new Database();
	TextArea listen = new TextArea();
	TextField innLeverandor = new TextField();
	TextField innNavn = new TextField();
	TextField innFarge = new TextField();
	TextField innPlassering = new TextField();
	Button registrer = new Button("Registrer");
	Button oppdater = new Button("Oppdater");
	Button sorter = new Button("Sorter");
	Button seListe = new Button("Se utstyr");
	Button seRegistrer = new Button("Registrer");
	Button tilbake = new Button("Meny");
	TextField status = new TextField();
	Utstyr[] beholdning;
	
	
	public void start(Stage vinduet) {
		BorderPane regRoot = new BorderPane();
		BorderPane listRoot = new BorderPane();
		VBox menyHolder = new VBox(30);
		
		menyHolder.getChildren().addAll(seListe, seRegistrer);
		
		
		HBox knappholder = new HBox(20);
		knappholder.getChildren().addAll(oppdater, sorter, tilbake);
		listRoot.setCenter(listen);
		listRoot.setBottom(knappholder);
		
		
		
		
		
		VBox registrering = new VBox(10);
		registrering.setAlignment(Pos.CENTER);
		
		HBox lev = new HBox(20);
		lev.setAlignment(Pos.CENTER);
		Label labelLeverandor = new Label("Leverandør: ");
		lev.getChildren().addAll(labelLeverandor, innLeverandor);
		Label labelNavn = new Label("Navn: ");
		HBox nvn = new HBox(20);
		nvn.setAlignment(Pos.CENTER);
		nvn.getChildren().addAll(labelNavn, innNavn);
		Label labelFarge = new Label("Farge: ");
		HBox frg = new HBox(20);
		frg.setAlignment(Pos.CENTER);
		frg.getChildren().addAll(labelFarge, innFarge);
		Label labelPlass = new Label("Plassering: ");
		HBox pls = new HBox(20);
		pls.getChildren().addAll(labelPlass, innPlassering);
		pls.setAlignment(Pos.CENTER);
		status.setDisable(true);
		registrering.getChildren().addAll(lev, nvn, frg, pls, registrer, status);
		regRoot.setCenter(registrering);
		
		
		
		
		Scene li = new Scene(listRoot, 600, 500); // <-- liste over hva man har.
		Scene menu = new Scene(menyHolder, 300, 200); //< --meny systemet 
		Scene re = new Scene(regRoot, 300, 200); //<-- registrer nytt utstyr
		
		vinduet.setScene(menu);
		vinduet.setTitle("Meny");
		vinduet.show();
		
		registrer.setOnAction(event -> {
			status.setText("Registrerer...");
			String tmpLev = innLeverandor.getText();
			String tmpNvn = innNavn.getText();
			String tmpFrv = innFarge.getText();
			String tmpPls = innPlassering.getText();
			boolean valid = true;
			if (tmpLev.equals("") || tmpNvn.equals("") || tmpFrv.equals("")) { valid = false; }
			if ( valid ) {
				String tempSQL = "INSERT INTO utstyr VALUES " +
								"( null, '" + tmpLev + "', '" + tmpNvn + "', '" + tmpFrv + "', '" + tmpPls + "');";
				db.lagNy(tempSQL);
				status.setText("Registrert.");
			} else {
				status.setText("Feil ved registrering...");
			}
			innLeverandor.clear();
			innNavn.clear();
			innFarge.clear();
			innPlassering.clear();
		});
		
		oppdater.setOnAction(event -> {
			listen.clear();
			beholdning = new Utstyr[0];
			beholdning = db.hentLageret();
			String tempString = "";
			for (Utstyr u : beholdning) {
				tempString += u.toString();
			}
			listen.setText(tempString);
		});
		
		sorter.setOnAction(event -> {
			System.out.print("!");
			listen.clear();
			beholdning = new Utstyr[0];
			beholdning = db.hentLageret();
			Arrays.sort(beholdning);
			String tempString = "";
			for (Utstyr u : beholdning) {
				tempString += u.toString();
			}
			listen.setText(tempString);
		});
		
		seListe.setOnAction(event -> {
			vinduet.setScene(li);
			vinduet.setTitle("Oversikt");
		});
		
		seRegistrer.setOnAction(event -> {
			vinduet.setScene(re);
			vinduet.setTitle("Registrer");
		});
		
		tilbake.setOnAction(event -> {
			vinduet.setScene(menu);
			vinduet.setTitle("Meny");
		});
		
	}

}
