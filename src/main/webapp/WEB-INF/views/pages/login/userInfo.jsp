<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<div>
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/logout" />">Logout</a>
		</sec:authorize>
		${principal}
	</div>
