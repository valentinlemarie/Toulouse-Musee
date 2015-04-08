package musee

import java.text.ParseException

class DemandeVisite {

    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    boolean status

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
    }
}
