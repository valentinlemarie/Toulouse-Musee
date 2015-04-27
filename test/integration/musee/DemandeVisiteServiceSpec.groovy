package musee



import spock.lang.*

/**
 *
 */
class DemandeVisiteServiceSpec extends Specification {

    DemandeVisiteService demandeVisiteService
    void "test insertion ou mise à jour d'une demande de visite"() {

        given: "une adresse"
        Adresse uneAdresse = new Adresse(rue: "rue de Rudel", numero: 26, codePostal: "81000", ville: "Albi")

        and: "un gestionaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "marc")

        and: "un musee"
        Musee unMusee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582")

        and: "une demande de visite"
        DemandeVisite demandeVisite = new DemandeVisite(code: "champ81" ,nbPersonnes: 31 ,dateDebutPeriode: new Date(2015,04,20,15,00),dateFinPeriode:new Date(2015,04,20,17,45),statut: "C" )
        when: "on tente de répercuter en base la création ou la modification d'une demande de visite"
        DemandeVisite resultDemandeVisite = demandeVisiteService.insertOrUpdateDemandeVisite(demandeVisite,unMusee)

        then: "la demande de visite résultant pointe sur la demande de visite initiale"
        demandeVisite == resultDemandeVisite

        and: "la demande de visite résultante n'a pas d'erreur"
        !resultDemandeVisite.hasErrors()

        and: "la demande de visite résultant a un id"
        resultDemandeVisite.getId()!= null

        and: "la demande de visite est bien present en base"
        DemandeVisite.findById(resultDemandeVisite.id) != null

        and :"le musee connait cette nouvelle demande de visite "
        unMusee.demandes.contains(demandeVisite);
    }

    void "test suppression d'une demande de visite"() {

        given: "une musee "
        Musee unMusee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582")
        and : "une demande de vsite existant en base"
        DemandeVisite demandeVisite=  new DemandeVisite(code:new DemandeVisite(code: "champ81" ,nbPersonnes: 31 ,dateDebutPeriode: new Date(2015,04,20,15,00),dateFinPeriode:new Date(2015,04,20,17,45),statut: "C" ))
        demandeVisiteService.insertOrUpdateDemandeVisite(demandeVisite,unMusee)


        when: "on tente de supprimer le musée"
        demandeVisiteService.deleteDemandeVisite(demandeVisite,unMusee)

        then: "le musée n'existe plus en base"
        DemandeVisite.findById(demandeVisite.id) == null

        and: "le gestionnaire n'a plus le musée dans sa liste de musée"
        !unMusee.demandes.contains(demandeVisite)
    }
}
