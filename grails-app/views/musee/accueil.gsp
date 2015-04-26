
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
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
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
</div>
</body>
</html>
