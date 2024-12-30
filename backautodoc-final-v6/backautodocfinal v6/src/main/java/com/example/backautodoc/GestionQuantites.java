package com.example.backautodoc;

/*** Cette classe gère les quantités des différentes pièces dans l'application AutoDoc.
 *
 * Rôles principaux :
 * 1. Stocker les quantités actuelles pour les freins, huiles et filtres.
 * 2. Permettre de modifier ces quantités via une méthode générique.
 * 3. Assurer que les quantités ne deviennent jamais négatives grâce à {@link Math#max(int, int)}.
 *
 * Liens avec d'autres classes :
 * - {@link Facture} : Utilise cette classe pour calculer le prix total des pièces commandées.
 * - {@link HelloController} : Appelle les méthodes de modification pour mettre à jour les quantités selon les actions de l'utilisateur.
 *
 * Concepts utilisés :
 * - **Validation des valeurs** : Grâce à {@link Math#max(int, int)}, les quantités sont toujours ≥ 0.
 * - **Centralisation** : Toute la logique liée aux quantités est regroupée ici, simplifiant le contrôleur.


 */
public class GestionQuantites {

    private int freinsQty = 0;  // Quantité actuelle des freins
    private int huileQty = 0;   // Quantité actuelle des huiles
    private int filtresQty = 0; // Quantité actuelle des filtres

    /**
     * Retourne la quantité actuelle des freins.
     *
     * @return La quantité actuelle des freins.
     */
    public int getFreinsQty() {
        return freinsQty;
    }
    public int getHuileQty() {
        return huileQty;
    }
    public int getFiltresQty() {
        return filtresQty;
    }
    /**
     * Modifie la quantité d'une pièce spécifique.
     *
     * Rôle :
     * - Ajoute ou retire une quantité pour la pièce spécifiée par son nom.
     * - Vérifie que la quantité ne devient jamais négative grâce à {@link Math#max(int, int)}.
     *
     * Fonctionnement de {@link Math#max(int, int)} :
     * - Compare deux valeurs :
     *   1. `0` : La quantité minimale autorisée.
     *   2. `freinsQty + delta`, `huileQty + delta`, ou `filtresQty + delta` : La nouvelle quantité calculée.
     * - Retourne la valeur maximale entre ces deux nombres.
     *
     * Utilisation dans d'autres classes :
     * - Appelée par {@link HelloController} pour modifier les quantités en fonction des actions utilisateur.
     *
     * @param piece Le type de pièce ("freins", "huile", ou "filtres").
     * @param delta La quantité à ajouter ou retirer (peut être négative).
     *              Exemple :
     *              - `delta = 1` : Ajoute 1 à la quantité.
     *              - `delta = -1` : Retire 1 à la quantité.
     * @return true si l'opération a été effectuée, sinon false (par exemple, si la pièce n'existe pas).

     */
    public boolean modifierQuantite(String piece, int delta) {
        if ("freins".equals(piece)) {
            freinsQty = Math.max(0, freinsQty + delta);
            return true;
        } else if ("huile".equals(piece)) {
            huileQty = Math.max(0, huileQty + delta);
            return true;
        } else if ("filtres".equals(piece)) {
            filtresQty = Math.max(0, filtresQty + delta);
            return true;
        }
        return false;
    }

    /**
     * Retourne un tableau contenant les quantités actuelles de toutes les pièces.
     *
     * Ordre des quantités dans le tableau :
     * - Index 0 : Quantité des freins.
     * - Index 1 : Quantité des huiles.
     * - Index 2 : Quantité des filtres.
     *
     * Utilisation :
     * - Cette méthode est utilisée par {@link Facture} pour calculer le prix total
     *   basé sur les quantités actuelles.
     *
     * @return Un tableau contenant les quantités dans l'ordre [freins, huiles, filtres].
     */
    public int[] getAllQuantities() {

        return new int[]{freinsQty, huileQty, filtresQty};
    }
}

