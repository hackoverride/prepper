package prepper;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hoved extends Application{

	public static void main(String[] args) {
		//Mai2018 x = new Mai2018();
		launch(args);

	}
	Katalog katalog = new Katalog();
	Button sortTlf = new Button("Sorter Tlf");
	Button sortNavn = new Button("Sorter Navn");
	Button nyKont = new Button("Ny Kontakt");
	Button slettKont = new Button("Slett Kontakt");
	TextField innTlf = new TextField();
	TextField innNavn = new TextField();
	TextField status = new TextField();
	TextArea holder = new TextArea();
	
	public void start(Stage window) {
		
		
		/* Oppgave 3, 
		 * GUI program - drift av en kontakt liste med telefonnummer og navn.
		 * kunne sortere på nummer eller navn
		 * kunne legge til nytt nummer med navn
		 * kunne slette kontakt.
		 */
		
		/*
		 * bildet i oppgaven viser en borderpane med top (vbox [sorter tlf][sorter navn])
		 * senter er textarea med liste over kontakter
		 * under er en vbox med tre hboxer.
		 * 1: input telefon og navn
		 * 2: [ny kontakt][slett kontakt]
		 * 3: Status linje. (input som er låst mot redigering)
		 */
	
		status.setDisable(true);
		BorderPane root = new BorderPane();
		HBox toppen = new HBox();
		toppen.getChildren().addAll(sortTlf, sortNavn);
		VBox bunnen = new VBox();
		HBox del1 = new HBox();
		Label labelTlf = new Label("Tlf:");
		Label labelNavn = new Label("Navn:");
		del1.getChildren().addAll(labelTlf, innTlf, labelNavn, innNavn);
		HBox del2 = new HBox();
		del2.getChildren().addAll(nyKont, slettKont);
		bunnen.getChildren().addAll(del1, del2, status);
		root.setTop(toppen);
		root.setCenter(holder);
		holder.setText(katalog.toString());
		root.setBottom(bunnen);
		window.setScene(new Scene(root, 400, 500));
		window.setTitle("Kontakter");
		window.show();
		
		nyKont.setOnAction(event -> {
			status.setText("Ny Kontakt Laget");
			int nr = Integer.parseInt(innTlf.getText());
			String navn = innNavn.getText();
			katalog.add(nr, navn);
			holder.clear();
			innTlf.clear();
			innNavn.clear();
			holder.setText(katalog.toString());
		});
		
		sortNavn.setOnAction(event -> {
			status.setText("Sortert på navn");
			holder.clear();
			katalog.sortNames();
			holder.setText(katalog.toString());
		});
		
		slettKont.setOnAction(event -> {
			String tempName = innNavn.getText();
			status.setText("Removed: " + tempName);
			holder.clear();
			innTlf.clear();
			innNavn.clear();
			katalog.remove(tempName);
			holder.setText(katalog.toString());
		});
		
		sortTlf.setOnAction(event -> {
			status.setText("Sortert på nummer");
			katalog.sorterNummer();
			holder.clear();
			holder.setText(katalog.toString());
		});
		
	}

}
