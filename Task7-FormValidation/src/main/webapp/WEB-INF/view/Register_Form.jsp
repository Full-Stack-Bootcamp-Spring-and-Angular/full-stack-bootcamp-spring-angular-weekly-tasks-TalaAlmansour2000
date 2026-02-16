<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css?v=1.1" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card p-4 shadow"><h2 class="mb-4 text-center">Employee Registration Form</h2>
<form:form action="${pageContext.request.contextPath}/success" modelAttribute="employeeModel" method="POST">

<div class="mb-3"><label class="form-label">Username</label>
    <form:input path="name" class="form-control" placeholder="Enter Username"/>
    <form:errors path="name" cssClass="error"/></div>
 <div class="mb-3"><label class="form-label">Email address</label>
    <form:input path="email" class="form-control" placeholder="example@gmail.com"/>
    <form:errors path="email" cssClass="error"/></div>

<div class="mb-3"><label class="form-label">Password</label>
     <form:password path="password" class="form-control" placeholder="*******"/>
     <form:errors path="password" cssClass="error"/></div>

<div class="mb-3">
    <label class="form-label">Confirm Password</label>
    <form:password path="confirmedPassword" class="form-control" placeholder="*****"/>
    <form:errors path="confirmedPassword" cssClass="error"/>
</div>


    <button type="submit" class="btn btn-primary w-100">Submit</button>

                </form:form></div> </div></div></div>

</body>
</html>