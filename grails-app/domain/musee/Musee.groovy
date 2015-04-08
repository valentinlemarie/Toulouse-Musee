package musee

import java.sql.Time

class Musee {

    String nom
    Time horaireOuverture = []
    int telephone
    String accesMetro
    String accesBus

    static constraints = {
        nom nullable: false
        horaireOuverture min: 0 ,nullable: false
        telephone nullable: false,size: 10
        accesBus nullable: false
        accesMetro nullable: false
    }
}
