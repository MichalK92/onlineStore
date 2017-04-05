<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- TODO:FROM FILE --%>
<title>LOGIN PAGE</title>
</head>
<body>
	<div>
		<c:url var="loginUrl" value="/login" /> 
		<form action="${loginUrl}"	method="post">
			
			<c:if test="${param.error != null}">
				<div class="alert alert-danger alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
						<%-- TODO:FROM FILE --%>
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
						<%-- TODO:FROM FILE --%>
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<fieldset>
				<div class="row">
					<div class="form-group">
						<input class="form-control" placeholder="User_name"
							name='ssoId' type="text">
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="password" name='password'
							type="password" value="">
					</div>
					<input class="btn btn-success btn-block" type="submit"
						value="Login">
				</div>
			</fieldset>
		</form>
	</div>
</body>