import musee.Adresse
import musee.AdresseService
import musee.GestionaireService
import musee.Gestionnaire

class BootStrap {

    AdresseService adresseService
    GestionaireService gestionaireService

    def init = { servletContext ->
        adresseService.insertOrUpdateAdresse( new Adresse(rue: "rue de Rudel",numero: 26,codePostal: "81000",ville: "Albi")  )
        gestionaireService.insertOrUpdateGestionnaire(new Gestionnaire(nom: "ToTo"))
    }
    def destroy = {
    }
}
