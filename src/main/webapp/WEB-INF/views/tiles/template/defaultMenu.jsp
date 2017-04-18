<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<h1>
		<a href='<spring:url value="/"/>'>Main Page</a>
		<sec:authorize access="isAnonymous()">
			<a href='<spring:url value="/login"/>'>Login Page</a>
			<a href='<spring:url value="/register"/>'>Register Page</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/logout" />">Logout</a>
		</sec:authorize>
	</h1>
</div>