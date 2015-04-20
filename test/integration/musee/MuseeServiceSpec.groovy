package musee


import spock.lang.*

/**
 *
 */
class MuseeServiceSpec extends Specification {

    MuseeService museeService

    void "test insertion ou mise à jour d'un  musee"() {

        given: "une adresse"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel", numero: 26, codePostal: "81000", ville: "Albi")

        and: "un gestionaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "marc");

        and: "un musee"
        Musee unMusee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateMusee(unMusee, uneAdresse, unGestionnaire)

        then: "le musée résultant pointe sur le musée initial"
        unMusee == resultMusee

        and: "le musée résultant n'a pas d'erreur"
        !resultMusee.hasErrors()

        and: "le musée résultant a un id"
        resultMusee.getId()!= null

        and: "le musée est bien present en base"
        Musee.findById(resultMusee.id) != null

        and: "le musée a pour adresse l'adresse passée en paramètre"
        resultMusee.adresse == uneAdresse

        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == unGestionnaire

        and: "le gestionnaire a dans sa liste de musée le musée passé en paramètre"
        unGestionnaire.musees.contains(resultMusee)
    }
}
