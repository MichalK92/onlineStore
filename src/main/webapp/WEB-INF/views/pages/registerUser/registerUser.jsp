<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
	<p>Register User</p>

	<form:form modelAttribute="userAccountForm" action="register"
		method="POST">
		<div>
			<label>Login: </label>
			<form:input type="text" path="login" placeholder=""></form:input>
			<form:errors path="login"></form:errors>
		</div>

		<div>
			<label>User First Name: </label>
			<form:input type="text" path="firstName" placeholder=""></form:input>
			<form:errors path="firstName"></form:errors>
		</div>

		<div>
			<label>User Last Name: </label>
			<form:input type="text" path="lastName" placeholder=""></form:input>
			<form:errors path="lastName"></form:errors>
		</div>

		<div>
			<label>Email Address: </label>
			<form:input type="text" path="emailAddress" placeholder=""></form:input>
			<form:errors path="emailAddress"></form:errors>
		</div>

		<div>
			<label>Email Address: </label>
			<form:input type="text" path="emailAddress" placeholder=""></form:input>
			<form:errors path="emailAddress"></form:errors>
		</div>

		<div>
			<label>Password: </label>
			<form:input type="text" path="password" placeholder=""></form:input>
			<form:errors path="password"></form:errors>
		</div>

		<div>
			<label>Repeat password: </label>
			<form:input type="text" path="password2" placeholder=""></form:input>
			<form:errors path="password2"></form:errors>
		</div>

		<div>
			<button type="submit">Register</button>
		</div>
	</form:form>
</div>
