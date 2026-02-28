<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Age Calculator</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css?v=1" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="signup-form">
        <form action="${pageContext.request.contextPath}/calculateAge" method="post">
            <h2>Calculate Age</h2>
            <p class="text-center text-muted">Please enter your birth date</p>
            <hr>
            <div class="row g-2 mb-3">
                <div class="col-4"><input type="number" class="form-control" name="day" placeholder="DD" required></div>
                <div class="col-4"><input type="number" class="form-control" name="month" placeholder="MM" required></div>
                <div class="col-4"><input type="number" class="form-control" name="year" placeholder="YYYY" required></div>
            </div>
            <div class="d-grid mt-4">
                <button type="submit" class="btn btn-success btn-lg w-100">Calculate Now</button>
            </div>
        </form>
    </div>
</body>
</html>