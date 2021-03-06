package musee

import java.sql.Time

class Musee {
    static hasMany = [demandes: DemandeVisite]
    Adresse adresse
    Gestionnaire gestionnaire
    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    boolean status

    static constraints = {
        nom blank: false
        horairesOuverture blank: false
        telephone size: 10..10, blank: false
        accesMetro nullable: true, blank: true
        accesBus nullable: true, blank: true
    }

    public String toString(){
        return nom
    }
}
