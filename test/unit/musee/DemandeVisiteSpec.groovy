package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande valide"(String unAccesMetro, String unAccesBus){
        given: "une demande initialise correctement"
        Musee musee = new Musee(nom: "Musee", horairesOuverture: "lundi au vendredi de 10h a 20h", telephone: "0563214582", accesMetro: unAccesMetro, accesBus: unAccesBus)

        expect: "la demande est valide"
        musee.validate() == true

        where:
        unAccesMetro  | unAccesBus
        "13, 17"      | "1, 2"
        "21, 48, 78"  | ""
        ""            | "3, 5"
        ""            | ""
        "2, 41, 48"   | null
        null          | "4, 5"
        null          | null

    }

    @Unroll
    void "test l'invalidite d'une demande invalide"(String unNom, String desHoraires, String unTelephone){
        given: "une demande initialise sans code, dates, personnes ou statut"
        Musee musee = new Musee(nom: unNom, horairesOuverture: desHoraires, telephone: unTelephone)

        expect: "la demande est invalide"
        musee.validate() == false

        where:
        unNom       | desHoraires                                           | unTelephone
        "Musee"     | "lundi au vendredi de 10h a 20h"                      | ""
        "Musee 2"   | "lundi au vendredi de 10h a 20h, samedi de 9h a 22h"  | null
        "Musee 3"   | "lundi au vendredi de 10h a 21h"                      | "05487854"
        "Musee 4"   | "lundi au vendredi de 12h a 20h, samedi de 10h a 22h" | "051521874556"
        "Musee 5"   | ""                                                    | "0531285631"
        "Musee 6"   | null                                                  | "0578485612"
        ""          | "lundi au vendredi de 10h a 22h, samedi de 9h a 0h"   | "0597521824"
        null        | "des horaires"                                        | "0575749416"

    }
}
