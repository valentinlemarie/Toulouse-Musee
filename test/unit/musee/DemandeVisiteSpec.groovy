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
    void "test la validite d'une demande de visite valide"(String monCode, Date maDateDebutPeriode, Date maDateFinPeriode, int monNbPersonnes, String monStatus) {
        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: monCode, dateDebutPeriode: maDateDebutPeriode, dateFinPeriode: maDateFinPeriode, nbPersonnes: monNbPersonnes, statut: monStatus)

        expect: "une demande de visite valide"
        demandeVisite.validate() == true
        maDateDebutPeriode < maDateFinPeriode

        where:
        monCode | maDateDebutPeriode         | maDateFinPeriode           | monNbPersonnes | monStatus
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,55) | 1              | "C"
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,11,15) | 10             | "A"
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,45) | 18             | "R"
    }

    @Unroll
    void "test l'invalidite d'une demande de visite invalide"(String monCode, Date maDateDebutPeriode, Date maDateFinPeriode, int monNbPersonnes, String monStatus) {
        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: monCode, dateDebutPeriode: maDateDebutPeriode, dateFinPeriode: maDateFinPeriode, nbPersonnes: monNbPersonnes, statut: monStatus)
        expect: "une demande de visite  invalide"
        demandeVisite.validate() == false || maDateDebutPeriode >= maDateFinPeriode

        where:
        monCode | maDateDebutPeriode         | maDateFinPeriode           | monNbPersonnes | monStatus
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,30) | 1              | "salut"
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,30) | 1              | null
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,55) | -10            | "C"
        "code"  | new Date(2014,03,25,10,15) | new Date(2014,03,25,10,55) | 0              | "C"
        "code"  | new Date(2014,03,25,10,15) | null                       | 10             | "C"
        "code"  | null                       | new Date(2014,03,25,10,55) | 10             | "C"
        "code"  | new Date(2014,03,25,10,15) | new Date(2011,03,25,10,55) | 10             | "C"
        ""      | new Date(2014,03,25,10,15) | new Date(2011,03,25,10,55) | 10             | "C"
        null    | new Date(2014,03,25,10,15) | new Date(2011,03,25,10,55) | 10             | "C"
    }
}