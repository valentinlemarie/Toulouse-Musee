package musee

import java.sql.Time

class DemandeVisite {

    String code
    Time dateDebutPeriode
    Time dateFinPeriode
    int nbPersonnes
    boolean status

    static constraints = {
        code nullable: false
        dateDebutPeriode nullable: false
        dateFinPeriode nullable: false
        nbPersonnes min: 1
    }
}
