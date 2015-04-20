package musee

import grails.transaction.Transactional

@Transactional
class ServiceMuseeService {

    Musee musee
    Adresse adresse
    Gestionnaire gestionnaire
    def serviceMethod() {

    }


    def insertOrUpdateMusee(Musee musee,Adresse adresse1,Gestionnaire gestionnaire1){
        musee.save()
        musee.setAdresse(adresse1)
        gestionnaire1.save()
        musee.setGestionaire(gestionnaire1)
        musee
    }

    def removeMusse(Musee musee1)
    {
        musee1.gestionaire
        musee1.getGestionaire().removeFromMusees(musee1)
        musee1.delete();
        musee1
    }
}
