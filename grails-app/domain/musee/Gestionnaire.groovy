package musee

class Gestionnaire {
    static hasMany = [musees: Musee]

    String nom

    static constraints = {
        nom blank: false
    }
}
