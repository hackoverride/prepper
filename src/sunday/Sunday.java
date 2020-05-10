package sunday;

import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
	Button sorter = new Button("Sorter");
	MenuBar menylinje = new MenuBar();
	Menu filmeny = new Menu("Valg");
	MenuItem menuReg = new MenuItem("Registrer");
	MenuItem menuList = new MenuItem("Oversikt");
	MenuItem menuBruk = new MenuItem("Fjerne Utstyr");
	TextField status = new TextField();
	Utstyr[] beholdning;
	
	
	public void start(Stage vinduet) {
		
		filmeny.getItems().addAll(menuReg, menuList, menuBruk);
		menylinje.getMenus().addAll(filmeny);
		
		BorderPane regRoot = new BorderPane();
		BorderPane listRoot = new BorderPane();

		
		
		HBox knappholder = new HBox(20);
		knappholder.getChildren().addAll(sorter);
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
		Scene re = new Scene(regRoot, 600, 500); //<-- registrer nytt utstyr
		
		BorderPane preStart = new BorderPane();
		preStart.setTop(menylinje);
		
		
		preStart.setStyle("-fx-background-color: #000");
		Scene start = new Scene(preStart, 600, 500);
		
		vinduet.setScene(start);
		vinduet.setTitle("Ylvas strikke oversikt");
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
		
		menuList.setOnAction(event -> {
			listRoot.setTop(menylinje);
			vinduet.setScene(li);
			vinduet.setTitle("Oversikt");
			
			listen.clear();
			beholdning = new Utstyr[0];
			beholdning = db.hentLageret();
			String tempString = "";
			for (Utstyr u : beholdning) {
				tempString += u.toString();
			}
			listen.setText(tempString);
			
		});
		
		menuReg.setOnAction(event -> {
			regRoot.setTop(menylinje);
			vinduet.setScene(re);
			vinduet.setTitle("Registrer");
		});
		
		menuBruk.setOnAction(event -> {
			Stage registrerBrukt = new Stage();
			HBox holder = new HBox(20);
			holder.setAlignment(Pos.CENTER);
			Label lnr = new Label("id: ");
			TextField nr = new TextField();
			Button remove = new Button("fjern");
			holder.getChildren().addAll(lnr, nr, remove);
			
			Scene temp = new Scene(holder, 300, 100);
			registrerBrukt.setScene(temp);
			registrerBrukt.setTitle("fjern utstyr: ");
			registrerBrukt.show();
			
			remove.setOnAction(ndevent -> {
				
				String tempid = nr.getText();
				String tempSQL = "DELETE FROM utstyr WHERE id = " + tempid + ";";
				db.fjern(tempSQL);
				registrerBrukt.close();
			});
		});
		
	}

}
