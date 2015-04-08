package musee

class Adresse {

    int numero
    String rue
    String codePostal
    String ville

    static constraints = {
        rue nullable: false
        codePostal nullable: false ,size:5
        ville nullable: false
        numero min: 0
    }
}
