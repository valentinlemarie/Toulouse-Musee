package musee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMusee(Musee musee, Adresse adresse1,Gestionnaire gestionnaire1){
        gestionnaire1.save()
        gestionnaire1.addToMusees(musee)
        adresse1.save()
        musee.setAdresse(adresse1)
        musee.save()
    }

    void deleteMusee(Musee musee1)
    {
        musee1.gestionnaire.removeFromMusees(musee1)
        musee1.delete()
    }

    List<Musee> searchMusees(String inNomMusee, String codePostal, String inNomRue) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (inNomMusee) {
                like 'nom', "%${inNomMusee}%"
            }
            if (codePostal) {
                adresse {
                    like 'codePostal', "%${codePostal}%"
                }
            }
            if (inNomRue) {
                adresse {
                    like 'rue', "%${inNomRue}%"
                }
            }
            order('nom')
        }
        res
    }
}
