
<!-- form tag prefix  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Form - Task6</title>
    <!-- style -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6 form-container shadow-sm p-4 bg-white border rounded">


            <h2 class="text-center mb-4">User Form</h2>


<form:form action="${pageContext.request.contextPath}/processForm" modelAttribute="userModel">
<div class="mb-3"><form:input path="userName" class="form-control" placeholder="Name" required="true" /></div>


<div class="mb-3"><form:password path="password" class="form-control" placeholder="Password" required="true" /></div>

<div class="mb-3"><form:select path="country" class="form-select">
                        <form:option value="Syria">Syria</form:option>
                        <form:option value="Brazil">Brazil</form:option>
                        <form:option value="Egypt">Egypt</form:option>
                        <form:option value="Italy">Italy</form:option><form:option value="Germany">Germany</form:option></form:select></div>
<div class="mb-3"><label class="form-label d-block text-secondary">Preferred Programming Language</label>
                    <div class="form-check form-check-inline">
                        <form:radiobutton path="programLang" value="Java" id="java" class="form-check-input" /> <label class="form-check-label" for="java">Java</label></div>
<div class="form-check form-check-inline">
                        <form:radiobutton path="programLang" value="C#" id="csharp" class="form-check-input" />
                        <label class="form-check-label" for="csharp">C#</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:radiobutton path="programLang" value="PHP" id="php" class="form-check-input" />
                        <label class="form-check-label" for="php">PHP</label>
                    </div></div>

<div class="mb-3">
                    <label class="form-label d-block text-secondary">Preferred Operating System</label>
                    <div class="form-check form-check-inline">
                        <form:checkbox path="operationSystem" value="Linux" id="linux" class="form-check-input" />
                        <label class="form-check-label" for="linux">Linux</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:checkbox path="operationSystem" value="Mac OS" id="macos" class="form-check-input" />
                        <label class="form-check-label" for="macos">Mac OS</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:checkbox path="operationSystem" value="Windows" id="windows" class="form-check-input" />
                        <label class="form-check-label" for="windows">Windows</label></div> </div>
<button type="submit" class="btn btn-danger w-100 mt-3">Submit</button>
                       </form:form>
        </div>
    </div>
</div>
</body>
</html>