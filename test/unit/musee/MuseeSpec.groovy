package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Time

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee correctement forme"(String unNom, String desHoraires, int unTelephone, String unAccesBus, String unAccesMetro){
        given: "un musee initialise correctement"
        Musee musee = new Musee()

    }
    def setup() {

    }

    def cleanup() {
    }

    void "test something"() {
    }
}
