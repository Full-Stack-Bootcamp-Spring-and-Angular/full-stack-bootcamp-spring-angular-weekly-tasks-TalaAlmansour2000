<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>

            .error {
                color: #ff0000 !important;

                display: block;
                margin-top: 5px;
                font-weight: bold;
            }

            body { background-color: #f8f9fa; padding-top: 50px; }
            .card { border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
            .form-label { font-weight: 500; }
        </style>
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

<div class="mb-3"><label class="form-label">Confirm Password</label>
     <form:password path="repassword" class="form-control" placeholder="*****"/>
     <form:errors path="" cssClass="error"/></div>

    <button type="submit" class="btn btn-primary w-100">Submit</button>

                </form:form></div> </div></div></div>

</body>
</html>