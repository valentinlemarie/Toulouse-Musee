package musee

import spock.lang.*

/**
 *
 */
class AdresseServiceSpec extends Specification {

    AdresseService adresseService

    @Unroll
    void "test insertion ou mise à jour d'une  adresse"() {

        given: "une adresse"
        Adresse uneAdresse = new Adresse(numero: 26, rue: "rue de Rudel", codePostal: "81000", ville: "Albi")

        when: "on tente de répercuter en base la création ou la modification de l'adresse"
        Adresse resultAdresse = adresseService.insertOrUpdateAdresse(uneAdresse)

        then: "l'adresse résultante pointe sur l'adresse initiale"
        uneAdresse == resultAdresse

        and: "l'adresse résultante n'a pas d'erreur"
        !resultAdresse.hasErrors()

        and: "l'adresse résultante a un id"
        resultAdresse.getId()!= null

        and: "l'adresse est bien presente en base"
        Adresse.findById(resultAdresse.id) != null
    }

    @Unroll
    void "test suppression d'une adresse"() {

        given: "une adresse existante en base"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel",numero: 26,codePostal: "81000",ville: "Albi")
        uneAdresse = adresseService.insertOrUpdateAdresse(uneAdresse)

        when: "on tente de supprimer l'adresse"
        adresseService.deleteAdresse(uneAdresse)

        then: "l'adresse n'existe plus en base"
        Adresse.findById(uneAdresse.id) == null
    }
}