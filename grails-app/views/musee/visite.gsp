
<%@ page import="musee.Adresse; musee.Musee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<div id="list-musee" class="content scaffold-list" role="main">
    <h1>Formualaire d'une demande :</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form controller="musee" action="valideVisite"  method="post">
        <fieldset class="form">
            <div>
                <g:select name="museeInstance" from="${museeInstanceList.findAll(){it.status}}" value="${museeInstanceList.id}" optionKey="id" required="" class="many-to-one"/>
            </div>
            <div class="fieldcontain">
                <label for="debut">
                    La visite souhaité commence  à la date :
                </label>
                <g:datePicker id="debut" name="debut" value="${new Date()}"></g:datePicker>
            </div>
            <div class="fieldcontain">
                <label for="fin">
                    La visite souhaité finit  à la date :
                </label>
                <g:datePicker id="fin" name="fin" value="${new Date()}"></g:datePicker>
            </div>
            <div class="fieldcontain">
                <label for="nombre">
                    Le nombre de personne pour cette visite est :
                </label>
                <g:field type="nomber" id="nb" name="nombre" placeholder=" 6 est le maximum de visiteur possible " ></g:field>
            </div>

             <g:actionSubmit action="valideVisite" value="Demande de visite" />

        </fieldset>
    </g:form>

    <g:if test="${museeInstanceList.findAll(){it.status==true}.size()>0 }">
        <h1>Mes Musee préférés</h1>

        <table>
            <thead>
            <tr>
                <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
            </tr>

            </thead>
            <tbody>

            <g:findAll  in="${museeInstanceList}" expr="${it.status==true}" >
                <tr>
                    <td> ${it.nom}</td>

                </tr>
            </g:findAll>

            </tbody>
        </table>
    </g:if>
</div>
</body>
</html>
