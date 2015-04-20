package musee



import spock.lang.*

/**
 *
 */
class DemandeVisiteServiceSpec extends Specification {

    DemandeVisiteService demandeVisiteService
    void "test insertion ou mise à jour d'un  musee"() {

        given: "une adresse"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel", numero: 26, codePostal: "81000", ville: "Albi")

        and: "un gestionaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "marc");

        and: "un musee"
        Musee unMusee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582")

        and: "une demande de visite"
        DemandeVisite demandeVisite = new DemandeVisite(code: "champ81" ,nbPersonnes: 31 ,dateDebutPeriode: new Date(2015,04,20,15,00),dateFinPeriode:new Date(2015,04,20,17,45),statut: "C" )
        when: "on tente de répercuter en base la création ou la modification du musée"
        DemandeVisite resultDemandeVisite = demandeVisiteService.insertOrUpdateDemandeVisite(demandeVisite,unMusee)

        then: "le musée résultant pointe sur le musée initial"
        demandeVisite == resultDemandeVisite

        and: "le musée résultant n'a pas d'erreur"
        !resultDemandeVisite.hasErrors()

        and: "le musée résultant a un id"
        resultDemandeVisite.getId()!= null

        and: "le musée est bien present en base"
        demandeVisite.findById(resultMusee.id) != null

        and: "le musée a pour adresse l'adresse passée en paramètre"


        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == unGestionnaire

        and: "le gestionnaire a dans sa liste de musée le musée passé en paramètre"
        unGestionnaire.musees.contains(resultMusee)
    }

    void "test suppression d'un musée"() {

        given: "un musée existant en base"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel", numero: 26, codePostal: "81000", ville: "Albi")
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "marc");
        Musee unMusee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582")
        unMusee = museeService.insertOrUpdateMusee(unMusee, uneAdresse, unGestionnaire)

        when: "on tente de supprimer le musée"
        museeService.deleteMusee(unMusee)

        then: "le musée n'existe plus en base"
        Musee.findById(unMusee.id) == null

        and: "le gestionnaire n'a plus le musée dans sa liste de musée"
        !unGestionnaire.musees.contains(unMusee)
    }
}
