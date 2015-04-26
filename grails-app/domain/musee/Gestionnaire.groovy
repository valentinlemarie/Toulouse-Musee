package musee

class Gestionnaire {
    static hasMany = [musees: Musee]

    String nom

    static constraints = {
        nom blank: false
    }


    @Override
    public String toString() {
        return nom
    }
}
