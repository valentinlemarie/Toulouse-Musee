package musee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMusee(Musee musee, Adresse adresse1,Gestionnaire gestionnaire1){
        musee.gestionnaire=gestionnaire1
        musee.adresse = adresse1
        musee.save()
    }

    void deleteMusee(Musee musee1)
    {
        musee1.gestionnaire.removeFromMusees(musee1)
        musee1.delete()
    }
}
