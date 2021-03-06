package musee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMusee(Musee musee, Adresse adresse1,Gestionnaire gestionnaire1){
        gestionnaire1.save()
        gestionnaire1.addToMusees(musee)
        adresse1.save()
        musee.setAdresse(adresse1)
        musee.save(flush: true)
    }

    void deleteMusee(Musee musee1)
    {
        musee1.gestionnaire.removeFromMusees(musee1)
        musee1.delete()
    }

    List<Musee> searchMusees(def param ,String inNomMusee, String codePostal, String inNomRue ) {
        def criteria = Musee.createCriteria()

        List<Musee> res = criteria.list(max: param.max,offset: param.offset) {
            if (inNomMusee) {
                like 'nom', "%${inNomMusee.toUpperCase()}%"
            }
            if (codePostal) {
                adresse {
                    like 'codePostal', "%${codePostal}%"
                }
            }
            if (inNomRue) {
                adresse {
                    like 'rue', "%${inNomRue.toUpperCase()}%"
                }
            }
            order('nom')
        }
        res
    }

    List<Musee> searchPrefere(){
        def criteria = Musee.createCriteria()

        List<Musee> res = criteria.list (){
            eq("status",true)
        }
    }

}
