
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

public class PageConnexion {

    private PageInscription inscription;
    private Group root;

    public PageConnexion(PageInscription inscription, Group root) {
        this.inscription = inscription;
        this.root = root;


        Scene scene = new Scene(root, 800, 650);
        primaryStage.setScene(scene);
        afficheConnexion();
        primaryStage.show();

    }

    private void afficheConnexion() {
        root.getChildren().clear();
        root.getChildren().add(creationConnexion());


    }




    private GridPane creationConnexion() {

        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);


        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);


        // columnTwoConstraints sera appliqué à tous les noeuds placés dans la deuxième colonne.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);


        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        Label headerLabel = new Label("Page connexion");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // On ajoute un label pour le login
        Label labelLogin = new Label("Login : ");
        gridPane.add(labelLogin, 0,1);

        // On ajoute un champ texte pour le login
        TextField champLogin = new TextField();
        champLogin.setPrefHeight(40);
        gridPane.add(champLogin, 1,1);

        // On ajoute un label pour le mot de passe
        Label labelMotDePasse  = new Label("Mot de passe : ");
        gridPane.add(labelMotDePasse, 0, 2);

        // On ajoute un champ texte pour le mot de passe
        PasswordField champMotDePasse = new PasswordField();
        champMotDePasse.setPrefHeight(40);
        gridPane.add(champMotDePasse, 1, 2);


        // On ajoute un bouton qui efface les saisie de l'utilisateur
        Button boutonEffacer = new Button("Effacer les champs" +
                "");
        boutonEffacer.setPrefHeight(40);
        boutonEffacer.setDefaultButton(true);
        boutonEffacer.setPrefWidth(150);
        gridPane.add(boutonEffacer, 0, 7, 35, 1);
        GridPane.setHalignment(boutonEffacer, HPos.LEFT);
        GridPane.setMargin(boutonEffacer, new Insets(20, 0,20,0));


        // On ajoute un bouton connexion
        Button boutonValider = new Button("Connexion" +
                "");
        boutonValider.setPrefHeight(40);
        boutonValider.setDefaultButton(true);
        boutonValider.setPrefWidth(150);
        gridPane.add(boutonValider, 0, 7, 2, 1);
        GridPane.setHalignment(boutonValider, HPos.RIGHT);
        GridPane.setMargin(boutonValider, new Insets(20, 0,20,0));

        boutonValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(champLogin.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Erreur !", "Saisissez votre login");
                    return;
                }
                if(champMotDePasse.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Saisissez votre mot de passe");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Inscription réussi", "Bienvenue " + champLogin.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}
