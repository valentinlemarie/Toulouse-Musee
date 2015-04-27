package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire valide"(String unNom, int test){
        given: "un gestionnaire initialise correctement"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "un gestionnaire valide"
        gestionnaire.validate() == true

        where:
        unNom   | test
        "salut" | 10
    }

    @Unroll
    void "test l'invalidite d'un gestionnaire invalide"(String unNom, int test) {
        given: "un gestionnaire mal initialise"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "un gestionnaire invalide"
        gestionnaire.validate() == false

        where:
        unNom | test
        ""    | 10
        null  | 10
    }

    @Unroll
    void "test l'affichage personnalisé du gestionnaire"() {
        given: "un gestionnaire"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "Mairie de Toulouse")

        expect: "un affichage correct"
        gestionnaire.toString() == "Mairie de Toulouse"
    }
}
