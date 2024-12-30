package com.example.backautodoc;

import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 * Contrôleur principal de l'application AutoDoc.
 *
 * Rôles principaux :
 * 1. Gérer les interactions utilisateur (clics, sélections, commandes).
 * 2. Mettre à jour les données des modèles comme {@link GestionQuantites} et {@link PieceSelection}.
 * 3. Afficher les informations pertinentes dans l'interface utilisateur.
 *
 * Liens avec d'autres classes :
 * - {@link GestionQuantites} : Modifie les quantités des pièces sélectionnées.
 * - {@link Facture} : Utilisée pour générer et calculer les données des commandes.
 * - {@link AlertHelper} : Utilisée pour afficher des alertes à l'utilisateur.
 * - {@link PrixArticles} et {@link GestionQuantites} : Gèrent les données des articles.
 */
public class HelloController {
    // Boutons pour commander et ajuster les quantités
    @FXML
    private Button commanderButton;
    // Cases à cocher pour sélectionner les pièces
    @FXML
    private CheckBox filtresCheckBox, freinsCheckBox, huileCheckBox;

    @FXML
    private Button filtresMinusButton, filtresPlusButton;
    // Étiquettes affichant les prix et quantités
    @FXML
    private Label filtresPriceLabel, filtresQtyLabel;

    @FXML
    private Button freinsMinusButton, freinsPlusButton;

    @FXML
    private Label freinsPriceLabel, freinsQtyLabel;

    @FXML
    private Button huileMinusButton, huilePlusButton;

    @FXML
    private Label huilePriceLabel, huileQtyLabel;
    // Menu déroulant pour choisir une marque
    @FXML
    private ComboBox<String> marqueComboBox;

    @FXML
    private Label prixFinalLabel;
    // Objets représentant les données principales
    private final MarqueSelection marqueSelection = new MarqueSelection();
    private final PieceSelection pieceSelection = new PieceSelection();
    private final GestionQuantites gestionQuantites = new GestionQuantites();
    private final PrixArticles prixArticles = new PrixArticles();
    private final Facture facture = new Facture(gestionQuantites, prixArticles);

    /**
     * Méthode appelée automatiquement au chargement de l'interface.
     *
     * Rôles :
     * - Initialise les éléments visuels comme le menu déroulant.
     * - Connecte les événements utilisateur (cases cochées, clics) aux actions du contrôleur.
     */
    @FXML
    public void initialize() {
        // Initialiser la liste des marques dans le menu déroulant
        marqueComboBox.getItems().addAll(marqueSelection.getMarques());
        marqueComboBox.setOnAction(e -> marqueSelection.setMarque(marqueComboBox.getValue()));

        // Connecter les cases à cocher à PieceSelection
        configureCheckBoxes();

        // Initialiser les étiquettes de prix
        updatePrices();
    }
    /**
     * Associe les cases à cocher (interface utilisateur) à l'objet {@link PieceSelection}.
     * Cela permet de suivre automatiquement les pièces sélectionnées par l'utilisateur.
     */
    private void configureCheckBoxes() {
        // Synchroniser les cases à cocher avec pieceSelection
        freinsCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> pieceSelection.setFreins(newValue));
        huileCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> pieceSelection.setHuile(newValue));
        filtresCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> pieceSelection.setFiltres(newValue));
    }
    /**
     * Ajoute une unité de freins si les conditions sont remplies.
     *
     * Conditions :
     * - Une marque doit être sélectionnée.
     * - Les freins doivent être sélectionnés.
     * /**
     *  * Contrôleur principal pour l'application AutoDoc.
     *  *
     *  * Utilisation de l'opérateur `!` :
     *  * - Le contrôleur utilise `!` pour vérifier que certaines conditions **ne sont pas remplies**.
     *  * - Exemple :
     *  *   - `if (!isMarqueSelected())` : Vérifie si **aucune marque** n'est sélectionnée.
     *  *   - `if (!pieceSelection.isFreins())` : Vérifie si les freins **ne sont pas** sélectionnés.
     *  * - L'opérateur `!` est utilisé pour inverser des conditions booléennes.
     *  *
     *  * Utilisation des méthodes `isQuelqueChose` :
     *  * - Ces méthodes, comme `isFreins()` ou `isHuile()`, appartiennent à {@link PieceSelection}.
     *  * - Elles permettent de vérifier facilement si une pièce est sélectionnée (retourne `true` ou `false`).
     *  * - Exemples dans le code :
     *  *   - Utilisées avant d'ajouter ou retirer une pièce pour vérifier la sélection.
     *  *   - Exemple d'appel : `if (pieceSelection.isFreins()) { ... }`.
     *  */


    @FXML
    public void ajouterFreins() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant d'ajouter des freins.");
            return;
        }

        if (!pieceSelection.isFreins()) {
            AlertHelper.showError("Erreur", "Freins non sélectionnés", "Veuillez sélectionner les freins avant d'ajouter des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("freins", 1);

        // Met à jour l'étiquette et le prix total
        freinsQtyLabel.setText("Quantité: " + gestionQuantites.getFreinsQty());
        updateFinalPrice();
    }



    @FXML
    public void retirerFreins() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant de retirer de l'huile.");
            return;
        }

        if (!pieceSelection.isFreins()) {
            AlertHelper.showError("Erreur", "freins non sélectionnée", "Veuillez sélectionner l'huile avant de retirer des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("freins", -1);

        // Met à jour l'étiquette et le prix total
        freinsQtyLabel.setText("Quantité: " + gestionQuantites.getFreinsQty());
        updateFinalPrice();
    }

    @FXML
    public void ajouterHuile() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant d'ajouter des freins.");
            return;
        }

        if (!pieceSelection.isHuile()) {
            AlertHelper.showError("Erreur", "huile non sélectionnés", "Veuillez sélectionner les freins avant d'ajouter des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("huile", 1);

        // Met à jour l'étiquette et le prix total
        huileQtyLabel.setText("Quantité: " + gestionQuantites.getHuileQty());
        updateFinalPrice();
    }

    @FXML
    public void retirerHuile() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant de retirer de l'huile.");
            return;
        }

        if (!pieceSelection.isHuile()) {
            AlertHelper.showError("Erreur", "Huile non sélectionnée", "Veuillez sélectionner l'huile avant de retirer des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("huile", -1);

        // Met à jour l'étiquette et le prix total
        huileQtyLabel.setText("Quantité: " + gestionQuantites.getHuileQty());
        updateFinalPrice();
    }


    @FXML
    public void ajouterFiltres() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant d'ajouter des freins.");
            return;
        }

        if (!pieceSelection.isFiltres()) {
            AlertHelper.showError("Erreur", "Filtres non sélectionnés", "Veuillez sélectionner les freins avant d'ajouter des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("filtres", 1);

        // Met à jour l'étiquette et le prix total
        filtresQtyLabel.setText("Quantité: " + gestionQuantites.getFiltresQty());
        updateFinalPrice();
    }

    @FXML
    public void retirerFiltres() {
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant de retirer de l'huile.");
            return;
        }

        if (!pieceSelection.isFiltres()) {
            AlertHelper.showError("Erreur", "filtres non sélectionnée", "Veuillez sélectionner l'huile avant de retirer des quantités.");
            return;
        }

        // Appel direct à GestionQuantites
        gestionQuantites.modifierQuantite("filtres", -1);

        // Met à jour l'étiquette et le prix total
        filtresQtyLabel.setText("Quantité: " + gestionQuantites.getFiltresQty());
        updateFinalPrice();
    }

    /**
     * Passe une commande en affichant un récapitulatif si toutes les conditions sont respectées.
     *
     * Conditions :
     * - Une marque est sélectionnée.
     * - Au moins une pièce est sélectionnée.
     */
    @FXML
    public void commander() {
        boolean peuxfaire = true;
        if (!isMarqueSelected()) {
            AlertHelper.showError("Erreur", "Aucune marque sélectionnée", "Veuillez sélectionner une marque avant de passer commande.");
            peuxfaire = false;
        }

        if (!pieceSelection.hasSelection()) {
            AlertHelper.showError("Erreur", "Aucune pièce sélectionnée", "Veuillez sélectionner au moins une pièce avant de passer commande.");
            peuxfaire = false;
        }

        if (peuxfaire) {
            AlertHelper.showInfo("Commande", "Résumé de la Commande", facture.genererFacture(marqueSelection.getMarque()));
        }
    }
    /**
     * Vérifie si une marque est sélectionnée.
     *
     * @return true si une marque est sélectionnée, sinon false.
     */

    private boolean isMarqueSelected() {
        return marqueSelection.getMarque() != null;
    }
    /**
     * Met à jour les étiquettes des prix des pièces.
     */
    private void updatePrices() {
        freinsPriceLabel.setText(prixArticles.getPrixFrein() + " €");
        huilePriceLabel.setText(prixArticles.getPrixHuile() + " €");
        filtresPriceLabel.setText(prixArticles.getPrixFiltre() + " €");
    }
    /**
     * Met à jour l'étiquette du prix total.
     */
    private void updateFinalPrice() {
        prixFinalLabel.setText("Total: " + facture.calculerPrixTotal() + " €");
    }
}
