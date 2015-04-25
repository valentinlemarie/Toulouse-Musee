package musee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {
    MuseeService museeService
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

    def valideVisite(){



        def museeList = museeService.searchMusees(params,nom ,codepostal ,rue)

        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size()] )

    }


    def doSearchMusees() {

        if(nom == null || params.nom != null){
            nom = params.nomMusee
        }
        if(codepostal == null || params.codePostal != null){
            codepostal = params.codePostal
        }
        if(rue == null || params.rue != null){
            rue = params.nomRue
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
