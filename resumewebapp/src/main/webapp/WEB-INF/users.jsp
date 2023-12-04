
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/css/users.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="../assets/js/users.js" ></script>
    <title>JSP Page</title>

</head>
<body>

<div class="container">
    <div class="raw">
        <div class="col-4">
            <f:form action="" method="GET" modelAttribute="user">
                <div class="form-group">
                    <label>Name:</label>
                    <f:input onkeyup="writeWhatIamTyping()"
                            placeholder="Enter name"
                             class="form-control"
                             path="name"/>
                    <f:errors path="name"/>
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <f:input placeholder="Enter surname"
                             class="form-control"
                             path="surname"/>
                    <f:errors path="surname"/>
                </div>
                <f:button type="submit"  class="btn btn-primary" id="btnsearch">Search</f:button>
            </f:form>
        </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${u.nationality.name}</td>
                <td style="width: 5px">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button class="btn btn-danger" type="submit" value="delete"
                                data-bs-toggle="modal" data-bs-target="#exampleModal"
                                onclick="setIdForDelete(${u.id})">
                            <i class="btn_table fa fa-trash-o"></i>
                        </button>
                </td>
                <td>
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <input type="hidden" name="action" value="update"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            <i class="fa fa-pencil"></i>
                        </button>
                    </form>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
