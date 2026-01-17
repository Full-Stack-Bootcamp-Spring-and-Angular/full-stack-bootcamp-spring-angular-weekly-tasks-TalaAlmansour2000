<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="signup-form">
        <div class="text-center">
            <h2 class="text-success">Success!</h2><p class="text-muted">Account details registered successfully</p>
        </div>
        <hr>

        <div class="mt-3">
            <p><strong>Username:</strong> <span class="text-secondary">${userModel.userName}</span></p>
            <p><strong>Country:</strong> <span class="text-secondary">${userModel.country}</span></p>
            <p><strong>Language:</strong> <span class="text-secondary">${userModel.programLang}</span></p>

            <p><strong>Operating Systems:</strong>
                <span class="text-secondary">
                    <c:forEach var="os" items="${userModel.operationSystem}" varStatus="status">
                        ${os}${!status.last ? ', ' : ''}
                    </c:forEach></span></p></div>

        <hr> <div class="d-grid mt-4">
            <a href="${pageContext.request.contextPath}/showForm" class="btn btn-primary">Back to Form</a> </div></div>
</body>
</html>