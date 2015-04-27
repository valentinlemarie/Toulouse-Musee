
<%@ page import="musee.Adresse; musee.Musee" %>
<!DOCTYPE html>
<html>
	<head>
        <style type="text/css" media="screen">
        body {
            background: none repeat scroll 0% 0% #FFF;
            color: #333;
            overflow-x: hidden;
            box-shadow: 0px 0px 0.3em #255B17;
            max-width: 1400px;
        }
        #status {
            background-color: #eee;
            border: .2em solid #fff;
            padding: 1em;
            width: 12em;
            float: left;
            -moz-box-shadow: 0px 0px 1.25em #ccc;
            -webkit-box-shadow: 0px 0px 1.25em #ccc;
            box-shadow: 0px 0px 1.25em #ccc;
            -moz-border-radius: 0.6em;
            -webkit-border-radius: 0.6em;
            border-radius: 0.6em;
        }

        .ie6 #status {
            display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
        }

        #status ul {
            font-size: 0.9em;
            list-style-type: none;
            margin-bottom: 0.6em;
            padding: 0;
        }

        #status li {
            line-height: 1.0;
        }

        #status h1 {
            text-transform: uppercase;
            font-size: 1.1em;
            margin: 0 0 0.3em;
        }

        #page-body {
            width: 100%;
        }

        h2 {
            margin-top: 1em;
            margin-bottom: 0.3em;
            font-size: 1em;
        }

        p {
            line-height: 1.2;
            margin: 0.25em 0;
        }

        #controller-list ul {
            list-style-position: inside;
        }

        #controller-list li {
            line-height: 0.7;
            list-style-position: inside;
            margin: 0.25em 0;
        }

        @media screen and (max-width: 800px) {
            #status {
                display: none;
            }

            #page-body {
                margin: 0 1em 1em;
            }

            #page-body h1 {
                margin-top: 0;
            }
        }
        #musee{
            float: left;
            position: relative;
        }
        #list-musee {
            align-content: center;

            width: -moz-min-content;
        }
        #prefere {
            width: 35%;
            float: right;
        }
        </style>
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
            <br><br><div id="myDiv">${text}</div><br>
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:if test="${museeInstanceList.findAll(){it.status==true}.size()>0 }">
                <div id="prefere">
                    <h1>Mes Musees préférés</h1>
                    <g:form action="demandevisitePage"  > <g:actionSubmit action="demandevisitePage" value="Effectuer une demande de visite" /> </g:form>

                    <table>
                        <thead>
                        <tr>

                            <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
                            <g:if test="${museeInstanceList.findAll(){it.status==true}.size()>=2}">
                            <g:sortableColumn property="status" title="${message(code: 'musee.status.label', default: 'Status')}" />
                            </g:if>
                        </tr>

                        </thead>
                        <tbody>

                        <g:findAll  in="${museeInstanceList}" expr="${it.status==true}" >

                            <tr>
                                <td> ${it.nom}</td>
                                <g:if test="${museeInstanceList.findAll(){it.status==true}.size()>=2}">
                                <td>
                                    <g:form action="updateMuseePrefere" id="${it.id}" > <g:actionSubmit action="updateMuseePrefere" value="Retirer de mes preferes" /> </g:form>
                                </td>
                                </g:if>
                            </tr>
                        </g:findAll>

                        </tbody>
                    </table>
                </div>
            </g:if>
            <g:form controller="musee" action="doSearchMusees" method="post">
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="nom">
                            Le nom du musée contient :
                        </label>
                        <g:textField name="nom"/>
                        <label for="codePostal">
                            Le code postal du musée correspond à :
                        </label>
                        <g:select name="codePostal" from="${(musee.Adresse.list().codePostal.unique() << "").sort()}"/>
                    </div>
                    <div class="fieldcontain">
                        <label for="rue">
                            La rue du musée contient :
                        </label>
                        <g:textField name="rue"/>
                    </div>
                    <div style="float: right">
                        <g:actionSubmit action="doSearchMusees" value="Rechercher" />
                    </div>
                </fieldset>
            </g:form>

            <div id="musee">
            <h1>Musee</h1>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />
					
						<g:sortableColumn property="telephone" title="${message(code: 'musee.telephone.label', default: 'Telephone')}" />
					
						<g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />
					
						<g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />
					
						<th><g:message code="musee.adresse.label" default="Adresse" /></th>
                        <th><g:message code="musee.gestionaire.label" default="Gestionnaire" /></th>
<g:if test="${museeInstanceCount >=3}">
                        <g:sortableColumn property="status" title="${message(code: 'musee.status.label', default: 'Status')}" />
    </g:if>
</tr>

</thead>
				<tbody>
				<g:each  in="${museeInstanceList}" status="i" var="museeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>
					
						<td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "telephone")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "adresse")}</td>
                        <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>
                    <g:if test="${museeInstanceCount >=3}">
                        <td>
                            <g:if test="${museeInstance.status == false}">
                                <g:form action="updateMuseePrefere" id="${museeInstance.id}" > <g:actionSubmit action="updateMuseePrefere" value="Ajouter a mes preferes" /> </g:form>
                            </g:if>
                        </td>
                        </g:if>
					</tr>
				</g:each>
				</tbody>
			</table>

            </div>

		</div>
	</body>
</html>
