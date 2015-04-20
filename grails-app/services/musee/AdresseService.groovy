package musee

import grails.transaction.Transactional

@Transactional
class AdresseService {

    Adresse insertOrUpdateAdresse(Adresse adresse1){
        adresse1.save()
    }
}
