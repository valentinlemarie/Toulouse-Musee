package musee

import spock.lang.*

/**
 *
 */
class AdresseServiceSpec extends Specification {

    AdresseService adresseService

    void "test insertion ou mise à jour d'une  adresse"() {

        given:"une adresse"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel",numero: 26,codePostal: "81000",ville: "Albi")

        when: "on tente de répercuter en base la création ou la modification de l'adresse"
        Adresse resultAdresse = adresseService.UpdateAdresse(uneAdresse);

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