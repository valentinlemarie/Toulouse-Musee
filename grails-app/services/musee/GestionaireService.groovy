package musee

import grails.transaction.Transactional

@Transactional
class GestionaireService {


    Gestionnaire insertOrUpdateGestionnaire(Gestionnaire gestionnaire1){
        gestionnaire1.save()
    }

    def deleteGestionaire(Gestionnaire gestionnaire1){
        gestionnaire1.delete()
    }
}
