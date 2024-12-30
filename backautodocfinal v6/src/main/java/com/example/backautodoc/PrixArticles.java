package com.example.backautodoc;

/**
 * Cette classe fournit les prix unitaires des pièces disponibles dans l'application.
 *
 * Rôles principaux :
 * 1. Stocker les prix unitaires pour chaque type de pièce.
 * 2. Fournir des méthodes pour accéder à ces prix.
 *
 * Utilisation :
 * - La classe {@link Facture} utilise ces prix pour calculer le total de la commande.
 * - Le contrôleur {@link HelloController} utilise ces prix pour afficher les prix unitaires
 *   dans l'interface utilisateur.
 */
public class PrixArticles {
    private final int prixFrein = 200;  // Prix unitaire des freins en euros
    private final int prixHuile = 6;   // Prix unitaire de l'huile en euros
    private final int prixFiltre = 10; // Prix unitaire des filtres en euros

    /**
     * Retourne le prix unitaire des freins.
     *
     * @return Le prix unitaire des freins en euros.
     */
    public int getPrixFrein() {
        return prixFrein;
    }

    /**
     * Retourne le prix unitaire de l'huile.
     *
     * @return Le prix unitaire de l'huile en euros.
     */
    public int getPrixHuile() {
        return prixHuile;
    }

    /**
     * Retourne le prix unitaire des filtres.
     *
     * @return Le prix unitaire des filtres en euros.
     */
    public int getPrixFiltre() {
        return prixFiltre;
    }
}

