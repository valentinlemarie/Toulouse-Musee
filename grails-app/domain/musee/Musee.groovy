package musee

import java.sql.Time

class Musee {

    String nom
    String horairesOuverture
    int telephone
    String accesMetro
    String accesBus

    static constraints = {
        nom blank: false
        horairesOuverture blank: false
        telephone size: 10
    }
}
