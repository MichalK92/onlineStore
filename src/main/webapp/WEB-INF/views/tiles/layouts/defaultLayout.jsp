<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
  
<body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>    
        <section id="leftsidemenu">
            <tiles:insertAttribute name="leftMenu" />
        </section>             
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         <section id="rightsidemenu">
            <tiles:insertAttribute name="rightMenu" />
        </section>            
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>