import javafx.application.Application;
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
import javafx.stage.Stage;
import javafx.stage.Window;

public class PageInscription extends Application {

    private Group root;
    private GridPane gridPane;
    private PageConnexion connexion;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Formulaire d'inscription");

        root = new Group();
        gridPane = creationInscription();

        connexion = new PageConnexion(this, root);
        addUIControls(gridPane);
        Scene scene = new Scene(root, 800, 650);

        afficheInscription();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void afficheInscription() {
        root.getChildren().clear();
        root.getChildren().add(gridPane);


    }


    private GridPane creationInscription() {

        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);


        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);  // On définit l'espace horizontal entre les colonnes


        gridPane.setVgap(10); // On définit l'écart vertical entre les lignes

        // On ajoute des contraintes de colonne

        //columnOneConstaints sera appliqué à tous les noeuds placés dans la première colonne.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints sera appliqué à tous les noeuds placés dans la deuxième colonne.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // On ajoute l'entête
        Label headerLabel = new Label("Formulaire d'inscription");
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

        // On ajoute un label pour le nom
        Label labelNom = new Label("Nom : ");
        gridPane.add(labelNom, 0,3);

        // On ajoute un champ texte pour le nom
        TextField champNom = new TextField();
        champNom.setPrefHeight(40);
        gridPane.add(champNom, 1,3);

        // On ajoute un label pour le prénom
        Label labelPrenom = new Label("Prénom : ");
        gridPane.add(labelPrenom, 0,4);

        // On ajoute un champ texte pour le Prénom
        TextField champPrenom = new TextField();
        champPrenom.setPrefHeight(40);
        gridPane.add(champPrenom, 1,4);

        // On ajoute un label pour l'adresse
        Label labelAdresse = new Label("Adresse : ");
        gridPane.add(labelAdresse, 0,5);

        // On ajoute un champ texte pour l'adresse
        TextField champAdresse = new TextField();
        champAdresse.setPrefHeight(40);
        gridPane.add(champAdresse, 1,5);

        // On ajoute un label pour le Code postal
        Label labelCodePostal = new Label("Code Postal : ");
        gridPane.add(labelCodePostal, 0,6);

        // On ajoute un champ texte pour le Code Postal
        TextField champCodePostal = new TextField();
        champCodePostal.setPrefHeight(40);
        gridPane.add(champCodePostal, 1,6);

        // On ajoute un label pour la ville
        Label labelVille = new Label("Ville : ");
        gridPane.add(labelVille, 0,7);

        // On ajoute un champ texte pour la ville
        TextField champVille = new TextField();
        champVille.setPrefHeight(40);
        gridPane.add(champVille, 1,7);

        // On ajoute un label pour l'email
        Label labelEmail = new Label("Adresse email : ");
        gridPane.add(labelEmail, 0, 8);

        // On ajoute un champ texte pour l'email
        TextField champEmail = new TextField();
        champEmail.setPrefHeight(40);
        gridPane.add(champEmail, 1, 8);

        // On ajoute un bouton valider
        Button buttonValider = new Button("Valider" +
                "");
        buttonValider.setPrefHeight(40);
        buttonValider.setDefaultButton(true);
        buttonValider.setPrefWidth(100);
        gridPane.add(buttonValider, 0, 9, 2, 1);
        GridPane.setHalignment(buttonValider, HPos.CENTER);
        GridPane.setMargin(buttonValider, new Insets(20, 0,20,0));

        buttonValider.setOnAction(event -> primaryStage.setScene(scene));

        //buttonValider.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
////                if(champNom.getText().isEmpty()) {
////                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Erreur !", "Saisissez votre nom");
////                    return;
////                }
////                if(champEmail.getText().isEmpty()) {
////                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Saisissez votre email");
////                    return;
////                }
////                if(champMotDePasse.getText().isEmpty()) {
////                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Saisissez votre mot de passe");
////                    return;
////                }
////
////                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Inscription réussi", "Bienvenue " + champLogin.getText());
//                primaryStage.setScene(scene);
//            }
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

    public static void main(String[] args) {
        launch(args);
    }
}
