package musee

import java.text.ParseException

class DemandeVisite {

    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    /**
     * A : visite en attente, C : visite en cours, R : visite realisee
     */
    String statut

    static constraints = {
        code blank: false
        dateDebutPeriode validator: {
            try {
                Date.parse('MM-dd-yyyy hh:mma', it)
                return true
            } catch (ParseException e) {
                return false
            }
        }
        dateFinPeriode validator: {
            try {
                Date.parse('MM-dd-yyyy hh:mma', it)
                return true
            } catch (ParseException e) {
                return false
            }
        }
        nbPersonnes min: 1
        statut inList: ["C", "A", "R"]
    }
}
