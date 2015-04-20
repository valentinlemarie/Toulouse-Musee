package musee


import spock.lang.*

/**
 *
 */
class MuseeServiceSpec extends Specification {

    void "test insertion ou mise à jour d'un  musee"() {

        given:"un adresse"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel",numero: 26,codePostal: "81000",ville: "Albi")

        and:"un gestionaire"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "marc");

        and:"un musee"

        Musee musee =  Musee musee = new Musee( gestionnaire: gestionnaire,adresse: uneAdresse, nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582", accesMetro: unAccesMetro, accesBus: unAccesBus)

        when: "on tente de répercuter en base la création ou la modification de l'adresse"
        Adresse resultAdresse = adresseService.insertOrUpdateAdresse(uneAdresse);

        then: "l'adresse resultante pointe sur l'adresse initale"
        uneAdresse == resultAdresse

        and:"l'adresse résultante n'a pas d'erreur"
        !resultAdresse.hasErrors()

        and:"l'adresse résultante a un id"
        resultAdresse.getId()!= null

        and:"l'adresse est bien presente en base"
        Adresse.findById(resultAdresse.id) != null
    }
}
