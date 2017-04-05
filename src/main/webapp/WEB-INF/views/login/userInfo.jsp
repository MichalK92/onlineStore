<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- TODO:FROM FILE --%>
<title>LOGIN PAGE</title>
</head>
<body>
	<div>

		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/logout" />">Logout</a>
		</sec:authorize>

		${principal}
	</div>
</body>