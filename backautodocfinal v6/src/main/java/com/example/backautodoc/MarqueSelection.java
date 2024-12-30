package com.example.backautodoc;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe gère la sélection des marques de voitures dans l'application.
 *
 * Rôles principaux :
 * 1. Stocker la liste des marques disponibles.
 * 2. Permettre à l'utilisateur de sélectionner une marque.
 *
 * Liens avec d'autres classes :
 * - {@link HelloController} : Utilise cette classe pour afficher les marques disponibles
 *   et pour vérifier la marque sélectionnée avant une commande.
 *   * Utilisation de {@link ArrayList} :
 *  * - Un `ArrayList` est utilisé pour stocker les marques dans l'attribut `marques`.
 *  * - Cela permet d'ajouter dynamiquement de nouvelles marques via la méthode `.add()`.
 *  * - Exemples dans le code :
 *  *   - Les marques sont ajoutées via {@link #initialiserMarques()}.
 *  *   - La méthode {@link #getMarques()} retourne la liste complète pour l'afficher
 *  *     dans une interface utilisateur, comme un menu déroulant.
 *  */

public class MarqueSelection {

    private String marque; // Marque actuellement sélectionnée
    private final List<String> marques; // Liste des marques disponibles

    /**
     * Constructeur par défaut qui initialise les marques disponibles.
     */
    public MarqueSelection() {
        this.marque = null; // Aucune marque sélectionnée par défaut
        this.marques = new ArrayList<>();
        initialiserMarques();
    }

    /**
     * Retourne la marque actuellement sélectionnée.
     *
     * @return La marque sélectionnée, ou null si aucune n'est sélectionnée.
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Met à jour la marque sélectionnée.
     *
     * @param marque La nouvelle marque sélectionnée.
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Retourne la liste des marques disponibles.
     *
     * @return Une liste contenant toutes les marques disponibles.
     */
    public List<String> getMarques() {
        return marques;
    }

    /**
     * Initialise la liste des marques disponibles.
     *
     * Cette méthode ajoute des marques prédéfinies à la liste {@link #marques}.
     */
    private void initialiserMarques() {
        marques.add("Toyota");
        marques.add("Ford");
        marques.add("BMW");
    }
}


