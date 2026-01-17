<html>
<head>

    <title>Age Calculator - Result</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css?v=1" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="signup-form">
    <div class="form-content" style="background: white; padding: 30px; border-radius: 5px; text-align: center;">
        <h2 class="text-success">Calculation Result</h2>
        <hr>
        <div class="my-4">
            <h4 class="text-muted">Hello User!</h4>
            <h1 class="display-4 fw-bold text-dark">${userAge}</h1>
            <p class="lead">Years Old</p>
        </div>

        <div class="d-grid">
            <a href="ageForm" class="btn btn-outline-secondary">Calculate Again</a>
        </div>
    </div>
</div>

</body>
</html>