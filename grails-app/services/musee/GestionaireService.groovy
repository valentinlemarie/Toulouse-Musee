package musee

import grails.transaction.Transactional

@Transactional
class GestionaireService {
    Gestionnaire gestionnaire
    Musee musee
    def serviceMethod() {

    }

    def insertOrGestionnaire(Gestionnaire gestionnaire1,Musee musee1){
        gestionnaire1.save()
        gestionnaire1.addToMusees(musee1)
        musee1.save()
        gestionnaire1
    }

    def removeGestionaire(Gestionnaire gestionnaire1,Gestionnaire gestionnaire2){

        gestionnaire2.addToMusees(gestionnaire1.getMusees())
        gestionnaire1.getMusees().remove();
        gestionnaire1

    }
}
