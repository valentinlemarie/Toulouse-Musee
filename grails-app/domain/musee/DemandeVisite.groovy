package musee

class DemandeVisite {

    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    /**
     * A : visite en attente, C : visite en cours, R : visite realisee
     */
    String statut

    static hasMany = [musee: Musee]
    static belongsTo = [Musee]

    static constraints = {
        code blank: false
        dateDebutPeriode format: 'MM-dd-yyyy hh:mm'
        dateFinPeriode format: 'MM-dd-yyyy hh:mm'
        nbPersonnes min: 1
        statut inList: ["C", "A", "R"]
    }
}
