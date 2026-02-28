<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="modal fade" id="successModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header"><h5 class="modal-title">Registration Successful</h5>
         </div>
       <div class="modal-body text-center"><p>${successMessage}</p></div>
                <div class="modal-footer justify-content-center">
                    <a href="registerForm" class="btn btn-primary">Back to Registration</a>
                </div></div></div></div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>

        window.onload = function() {
      var myModal = new bootstrap.Modal(document.getElementById('successModal'));
            myModal.show();};
    </script>
</body>
</html>