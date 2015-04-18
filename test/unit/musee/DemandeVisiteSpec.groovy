package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
// test commit
/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"(String monCode, Date maDateDebutPeriode, Date maDateFinPeriode, int monNbPersonnes, boolean monStatus) {
        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: monCode, dateDebutPeriode: maDateDebutPeriode, dateFinPeriode: maDateFinPeriode, status: monStatus)
        expect: "une demande de visite  valide"
        demandeVisite.validate() == true

        where:
        monCode | maDateDebutPeriode  | maDateFinPeriode    | monNbPersonnes | monStatus
        "code"  | new Date(2014,03,25,10,15).parse('dd.MM.yyyy hh:mm', it) | new Date(2014,03,25,10,55).parse('dd.MM.yyyy hh:mm', it) | 1              | true
        "code"  | new Date(2014,03,25,10,15).parse('dd.MM.yyyy hh:mm', it) | new Date(2014,03,25,10,15).parse('dd.MM.yyyy hh:mm', it) | 10             | false
    }

    @Unroll
    void "test l'invalidite d'une demande de visite invalide"(String monCode, Date maDateDebutPeriode, Date maDateFinPeriode, int monNbPersonnes, boolean monStatus) {
        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: monCode, dateDebutPeriode: maDateDebutPeriode, dateFinPeriode: maDateFinPeriode, status: monStatus)
        expect: "une demande de visite  invalide"
        demandeVisite.validate() == false

        where:
        monCode | maDateDebutPeriode  | maDateFinPeriode            | monNbPersonnes | monStatus
        ""      | new Date(2014,03,25,10,15).parse('dd.yyyy hh:mm', it)          | new Date(2014,023,25,10,30).parse('d.M.yyy hh:m', it)       | 0             | true
        null    | new Date(2014,03,25,10,15).parse('dd.MM.yyy hh:m', it)       | new Date(2014,03,250,100,155).parse('dd.MM.yyy hh:m', it)        | -10             | false
    }
}