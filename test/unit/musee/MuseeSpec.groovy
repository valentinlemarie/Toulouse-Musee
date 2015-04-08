package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String unNom, String desHoraires, String unTelephone, String unAccesMetro, String unAccesBus){
        given: "un musee initialise correctement"
        Musee musee = new Musee(nom: unNom, horairesOuverture: desHoraires, telephone: unTelephone, accesMetro: unAccesMetro, accesBus: unAccesBus)

        expect: "le musee est valide"
        musee.validate() == true

        where:
        unNom       | desHoraires                                           | unTelephone   | unAccesMetro  | unAccesBus
        "Musee"     | "lundi au vendredi de 10h a 20h"                      | "0563214582"  | "13, 17"      | "1, 2"
        "Musee 2"   | "lundi au vendredi de 10h a 20h, samedi de 9h a 22h"  | "0548612458"  | "21, 48, 78"  | ""
        "Musee 3"   | "lundi au vendredi de 10h a 21h"                      | "0548784154"  | ""            | "3, 5"
        "Musee 4"   | "lundi au vendredi de 12h a 20h, samedi de 10h a 22h" | "0515218756"  | ""            | ""
        "Musee 5"   | "lundi au vendredi de 10h a 20h"                      | "0531285631"  | "2, 41, 48"   | null
        "Musee 6"   | "lundi au vendredi de 10h a 20h, samedi de 9h a 21h"  | "0578485612"  | null          | "4, 5"
        "Musee 7"   | "lundi au vendredi de 10h a 22h, samedi de 9h a 0h"   | "0597521824"  | null          | null

    }
}
