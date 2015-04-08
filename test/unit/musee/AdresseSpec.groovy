package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {


    @Unroll
    void "test la validite d'une adresse valide"(int unNumero, String uneRue , String unCodePostal , String uneVille){
        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: unNumero,rue: uneRue ,codePostal: unCodePostal,ville: uneVille)
        expect: "une adresse  valide"
        adresse.validate() == true

        where:
        unNumero    | uneRue         | unCodePostal   | uneVille
        26          | "rue de rudel" | "81000"        | "Albi"

    }

    @Unroll
    void "test l'invalidite d'une adresse invalide"(int unNumero, String uneRue , String unCodePostal , String uneVille){
        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: unNumero,rue: uneRue ,codePostal: unCodePostal,ville: uneVille)

        expect: "une  adresse invalide"
        adresse.validate() == false

        where:
        unNumero    | uneRue         |  unCodePostal  | uneVille
        0           | ""             | ""             |""
        -1          | ""             | "8100"         |""
        -1          |""              | "810000"       |""

    }

}
