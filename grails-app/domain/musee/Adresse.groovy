package musee

class Adresse {

    int numero
    String rue
    String codePostal
    String ville

    static constraints = {
        numero min: 1
        rue blank: false
        codePostal size: 5, blank: false
        ville blank: false
    }
}
