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
    void "test valide musee correctement forme"(String nom, Time horaire ,int numero,String accesBus , String accesMetro){
        given: "un musee initialise correctement"

    }
    def setup() {

    }

    def cleanup() {
    }

    void "test something"() {
    }
}
