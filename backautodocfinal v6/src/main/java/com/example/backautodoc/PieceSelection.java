package com.example.backautodoc;

/**
 * Cette classe gère les sélections des types de pièces (freins, huile, filtres) dans l'application.
 *
 * Rôles principaux :
 * 1. Stocker l'état des sélections de l'utilisateur (si une pièce est sélectionnée ou non).
 * 2. Fournir des méthodes pour vérifier si une pièce est sélectionnée.
 * 3. Faciliter l'interaction avec le contrôleur {@link HelloController}, qui met à jour
 *    ces sélections en fonction des actions de l'utilisateur.
 *
 * Utilisation :
 * - Le contrôleur appelle les méthodes `setFreins`, `setHuile`, ou `setFiltres` pour
 *   mettre à jour les sélections lorsque l'utilisateur coche ou décoche une case.
 * - Les méthodes `isFreins`, `isHuile`, et `isFiltres` permettent au contrôleur de vérifier
 *   l'état des sélections avant d'ajouter ou de retirer des quantités.
 */
public class PieceSelection {
    private boolean freins;  // Indique si les freins sont sélectionnés
    private boolean huile;   // Indique si l'huile est sélectionnée
    private boolean filtres; // Indique si les filtres sont sélectionnés

    /**
     * Cette classe gère les sélections des types de pièces.
     *
     * Rôle des méthodes `isQuelqueChose` :
     * - Ces méthodes retournent un booléen (`true` ou `false`) indiquant si une pièce est sélectionnée.
     * - Exemple :
     *   - `isFreins()` : Retourne `true` si les freins sont sélectionnés.
     *   - `isHuile()` : Retourne `true` si l'huile est sélectionnée.
     * - Ces méthodes simplifient la vérification des sélections dans le contrôleur {@link HelloController}.
     *
     * Utilisation dans d'autres classes :
     * - Le contrôleur appelle ces méthodes pour savoir si une action est possible.
     * - Exemple :
     *   - Avant d'ajouter des quantités de freins, le contrôleur vérifie `isFreins()`.
     *   - Si `isFreins()` retourne `false`, une erreur est affichée.
     */
    public boolean isFreins() {
        return freins;
    }

    /**
     * Met à jour l'état de sélection des freins.
     *
     * @param freins true si les freins sont sélectionnés, sinon false.
     */
    public void setFreins(boolean freins) {
        this.freins = freins;
    }



    public boolean isHuile() {
        return huile;
    }


    public void setHuile(boolean huile) {
        this.huile = huile;
    }


    public boolean isFiltres() {
        return filtres;
    }


    public void setFiltres(boolean filtres) {
        this.filtres = filtres;
    }

    /**
     * Vérifie si au moins une pièce est sélectionnée grace || et si c'est return  faux le controller affiche une erreur
     *
     * Cette méthode est utilisée par {@link HelloController#commander()} pour déterminer
     * si une commande peut être passée.
     *
     * @return true si au moins une pièce est sélectionnée, sinon false.
     */
    public boolean hasSelection() {
        return freins || huile || filtres;
    }
}


