package com.example.backautodoc;

public class Facture {
    private final GestionQuantites gestionQuantites;
    private final PrixArticles prixArticles;

    public Facture(GestionQuantites gestionQuantites, PrixArticles prixArticles) {
        this.gestionQuantites = gestionQuantites;
        this.prixArticles = prixArticles;
    }

    public int calculerPrixTotal() {
        int[] quantites = gestionQuantites.getAllQuantities();
        int[] prix = {prixArticles.getPrixFrein(), prixArticles.getPrixHuile(), prixArticles.getPrixFiltre()};

        int total = 0;
        for (int i = 0; i < quantites.length; i++) {
            total += quantites[i] * prix[i];
        }
        return total;
    }

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



