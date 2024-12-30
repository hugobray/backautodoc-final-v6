package com.example.backautodoc;
/**
 * Cette classe représente une facture pour l'application AutoDoc.
 *
 * Rôles principaux :
 * 1. Calculer le prix total des pièces commandées.
 * 2. Générer une facture textuelle détaillée pour la commande.
 *
 * Liens avec d'autres classes :
 * - {@link GestionQuantites} : Utilise cette classe pour obtenir les quantités actuelles des pièces.
 * - {@link PrixArticles} : Utilise cette classe pour connaître les prix unitaires des pièces.
 *
 * Concepts Java utilisés :
 * - **Constructeur** : Le constructeur injecte les dépendances nécessaires pour travailler avec les quantités et les prix.
 * - **Méthodes Java simples** : Les calculs sont effectués via des boucles et des multiplications.
 */

public class Facture {
    private final GestionQuantites gestionQuantites;
    private final PrixArticles prixArticles;
    /**
     * Constructeur de la classe Facture.
     *
     * @param //gestionQuantites L'objet qui gère les quantités des pièces.
     * @param //prixArticles L'objet qui gère les prix des pièces.
     */
    public Facture(GestionQuantites gestionQuantites, PrixArticles prixArticles) {
        this.gestionQuantites = gestionQuantites;
        this.prixArticles = prixArticles;
    }


    /**
     * Calcule le prix total des pièces commandées.
     *
     * Fonctionnement :
     * - Récupère les quantités actuelles pour chaque pièce via {@link GestionQuantites}.
     * - Récupère les prix unitaires via {@link PrixArticles}.
     * - Multiplie les quantités par les prix pour chaque pièce, puis additionne le tout.
     *
     * @return Le prix total de la commande.
     */
    public int calculerPrixTotal() {
        int[] quantites = gestionQuantites.getAllQuantities();
        int[] prix = {prixArticles.getPrixFrein(), prixArticles.getPrixHuile(), prixArticles.getPrixFiltre()};

        int total = 0;
        for (int i = 0; i < quantites.length; i++) {
            total += quantites[i] * prix[i];
        }
        return total;
    }

        /**
 * Génère une facture textuelle détaillée pour une commande.
 *
 * Fonctionnement :
 * - Ajoute les informations pour chaque pièce commandée, si sa quantité est > 0.
 * - Ajoute le prix total à la fin.
 *
 * @param marque La marque sélectionnée par l'utilisateur.
 * @return Une chaîne de caractères représentant la facture.
 **/
    public String genererFacture(String marque) {
        // Début de la facture
        String facture = "Facture pour la marque " + marque + ":\n";

        // Calcul des totaux pour chaque pièce
        if (gestionQuantites.getFreinsQty() > 0) {
            facture += "- Freins: " + gestionQuantites.getFreinsQty() +
                    " x " + prixArticles.getPrixFrein() + "€\n";
        }
        if (gestionQuantites.getHuileQty() > 0) {
            facture += "- Huile: " + gestionQuantites.getHuileQty() +
                    " x " + prixArticles.getPrixHuile() + "€\n";
        }
        if (gestionQuantites.getFiltresQty() > 0) {
            facture += "- Filtres: " + gestionQuantites.getFiltresQty() +
                    " x " + prixArticles.getPrixFiltre() + "€\n";
        }

        // Ajout du prix total
        facture += "Prix total: " + calculerPrixTotal() + " €";
        return facture;
    }
}


