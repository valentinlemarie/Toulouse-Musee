package musee

import grails.transaction.Transactional

@Transactional
class AdresseService {

    Adresse adresse
    Musee musee
    def serviceMethod() {

    }

    Adresse UpdateAdresse(Adresse adresse1){
        adresse1.save()
        adresse.setCodePostal(adresse1.codePostal);
        adresse.setNumero(adresse1.numero)
        adresse.setRue(adresse1.rue)
        adresse.setVille(adresse1.ville)
        adresse
    }
}
