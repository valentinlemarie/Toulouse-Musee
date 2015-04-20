package musee

import grails.transaction.Transactional

@Transactional
class DemandeVisiteService {

    DemandeVisite demandeVisite
    Musee musee
    def serviceMethod() {

    }

    def insertOrUpdateDemande(DemandeVisite demandeVisite1,Musee musee1){
        demandeVisite1.save()
        musee1.setDemandes(demandeVisite1)
        demandeVisite1
    }

    def removeVisite(DemandeVisite demandeVisite1,Musee musee1){
        musee1.removeFromDemandes(demandeVisite1)
        demandeVisite1.delete()
        demandeVisite1
    }
}
