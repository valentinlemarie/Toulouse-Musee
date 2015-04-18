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
    void "test la validite d'un gestionaire valide"(String nomNom){
        given: "un gestionnaire initialise correctement"
        Gestionnaire gestionnaire = new Gestionnaire(nom: nomNom)
        expect: "un gestionnaire  valide"
        gestionnaire.validate() == true

        where:
        nomNom
        "valentin"
    }

    @Unroll
    void "test la validite d'un gestionaire invalide"(String nomNom){
        given: "un gestionnaire initialise correctement"
        Gestionnaire gestionnaire = new Gestionnaire(nom: nomNom)
        expect: "un gestionnaire  invalide"
        gestionnaire.validate() == false

        where:
        nomNom
        ""
        null
    }
}
