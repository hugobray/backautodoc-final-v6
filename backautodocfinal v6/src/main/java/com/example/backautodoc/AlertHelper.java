package com.example.backautodoc;

import javafx.scene.control.Alert;

/**
 * Cette classe centralise la gestion des alertes dans l'application.
 *
 * Rôles principaux :
 * 1. Simplifier l'affichage des messages d'erreur ou d'information dans des fenêtres modales.
 * 2. Fournir une interface cohérente pour gérer les alertes depuis le contrôleur {@link HelloController}.
 *
 * Fonctionnement :
 * - Les méthodes `showError` et `showInfo` permettent de créer et d'afficher des alertes
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
     *
     * @param title Le titre de l'alerte.
     * @param header L'en-tête de l'alerte.
     * @param content Le contenu détaillé de l'alerte.
     * @param type Le type d'alerte ({@link Alert.AlertType}).
     */
    private static void showAlert(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait(); // Attend que l'utilisateur ferme l'alerte
    }
}


