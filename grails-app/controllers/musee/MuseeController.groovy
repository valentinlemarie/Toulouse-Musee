package musee


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {
    MuseeService museeService
    DemandeVisiteService demandeVisiteService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def rue
    def codepostal
    def nom

    def updateMuseePrefere(){
        def prefere =Musee.get(params.id)
        System.out.println(params.id)
        if(prefere){
            prefere.status= !prefere.status
            museeService.insertOrUpdateMusee(prefere,prefere.getAdresse(),prefere.getGestionnaire())
        }
        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue  )
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()] )
    }

    def demandevisitePage() {

        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue  )

        render(view: 'visite', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()] )
    }

    def accueil(){
        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue  )

        render(view: 'accueil', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()] )
    }

    def valideVisite(){

        String alphabet =  (('A'..'Z')+('0'..'9')).join() ;
        String randomString =new Random().with {
            (1..10).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
        }

        DemandeVisite demandeVisite = new DemandeVisite( dateDebutPeriode: params.debut ,dateFinPeriode: params.fin,code: randomString )
        def demande = demandeVisiteService.insertOrUpdateDemandeVisite(demandeVisite,Musee.get(params.museeInstance))
        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue)


        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size(),text:".    Le code de votre Demande est:  "+randomString] )

    }


    def doSearchMusees() {
        if(nom == null || params.nom != null){
            nom = params.nom
        }
        if(codepostal == null || params.codePostal != null){
            codepostal = params.codePostal
        }
        if(rue == null || params.rue != null){
            rue = params.rue
        }



        params.max = 5


        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue  )

        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()] )
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 5, 100)
        respond Musee.list(params), model:[museeInstanceCount: Musee.count()]
    }

    def show(Musee museeInstance) {
        respond museeInstance
    }

    def create() {
        respond new Musee(params)
    }



    @Transactional
    def save(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'create'
            return
        }

        museeService.insertOrUpdateMusee(museeInstance, museeInstance.getAdresse(), museeInstance.getGestionnaire())

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: CREATED] }
        }
    }

    def edit(Musee museeInstance) {
        respond museeInstance
    }

    @Transactional
    def update(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'edit'
            return
        }

        museeService.insertOrUpdateMusee(museeInstance, museeInstance.getAdresse(), museeInstance.getGestionnaire())

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*'{ respond museeInstance, [status: OK] }
        }
    }
    @Transactional
    def delete(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        museeService.deleteMusee(museeInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musee.label', default: 'Musee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
