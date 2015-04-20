package musee

import grails.transaction.Transactional

@Transactional
class DemandeVisiteService {


    DemandeVisite insertOrUpdateDemandeVisite(DemandeVisite demandeVisite1,Musee musee1){
        musee1.save()
        musee1.addToDemandes(demandeVisite1)
        demandeVisite1.save()
    }

    void deleteDemandeVisite(DemandeVisite demandeVisite1,Musee musee1){
        musee1.removeFromDemandes(demandeVisite1)
        demandeVisite1.delete()
    }
}
