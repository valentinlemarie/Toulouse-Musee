package musee

import grails.transaction.Transactional

@Transactional
class AdresseService {

    Adresse insertOrUpdateAdresse(Adresse adresse){
        adresse.save()
    }

    void deleteAdresse(Adresse adresse) {
        adresse.delete()
    }
}
