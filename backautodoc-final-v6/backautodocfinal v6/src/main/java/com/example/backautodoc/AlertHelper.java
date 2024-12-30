package com.example.backautodoc;

import javafx.scene.control.Alert;

/**
 * Cette classe centralise la gestion des alertes dans l'application.
 *
 * Rôles principaux :
 * 1. Simplifier l'affichage des messages d'erreur ou d'information dans des fenêtres modales.
 * 2. Fournir une interface cohérente pour gérer les alertes depuis le contrôleur {@link HelloController}.
 *
 *  * Liens avec d'autres classes :
 *  * - Utilisée par {@link HelloController} pour afficher des messages d'erreur ou d'information à l'utilisateur.
 *  *
 * Fonctionnement :
 * - Les méthodes `showError` et `showInfo` permettent de créer et d'afficher des alertes
 * - Méthodes statiques** : Permettent d'appeler les méthodes directement via le nom de la classe, sans créer d'objet.
 *   avec des titres, des en-têtes, et des messages personnalisés.
 * - Ces méthodes utilisent la classe {@link Alert} de JavaFX.
 */
public class AlertHelper {

    /**
     * Affiche une alerte d'erreur avec le message fourni.
     *
     * @param title Le titre de l'alerte.
     * @param header L'en-tête de l'alerte.
     * @param content Le contenu détaillé de l'alerte.
     */
    public static void showError(String title, String header, String content) {
        showAlert(title, header, content, Alert.AlertType.ERROR);
    }

    /**
     * Affiche une alerte d'information avec le message fourni.
     *
     * @param title Le titre de l'alerte.
     * @param header L'en-tête de l'alerte.
     * @param content Le contenu détaillé de l'alerte.
     */
    public static void showInfo(String title, String header, String content) {
        showAlert(title, header, content, Alert.AlertType.INFORMATION);
    }

    /**
     * Méthode privée utilisée pour créer et afficher une alerte.
     * Fonctionnement :
     * - Crée une alerte de type {@link Alert} avec les informations fournies.
     * - Affiche la boîte de dialogue à l'utilisateur avec {@link Alert#showAndWait()}.
     *
     *
     * @param title Le titre de l'alerte.
     * @param header L'en-tête de l'alerte.
     * @param content Le contenu détaillé de l'alerte.
     * @param type Le type d'alerte ({@link Alert.AlertType}).
     */
    private static void showAlert(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);// defini le message
        alert.setContentText(content);// detaille du message
        alert.showAndWait(); // Attend que l'utilisateur ferme l'alerte
    }
}


