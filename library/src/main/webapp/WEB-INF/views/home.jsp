<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinuka
  Date: 7/19/17
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        .error {
            color: brown;
        }
    </style>
    <script type="text/javascript">
        $(window).on('load',
            function () {
                if (${userFormError}) {
                    $('#userModal').modal('show');
                }
            });
    </script>
    <script type="text/javascript">
        $(window).on('load',
            function () {
                if (${bookFormError}) {
                    $('#bookModal').modal('show');
                }
            });
    </script>

</head>
<body>

<div class="row">
    <div class="col-md-12">
        <img src="./images/libraries_lms.jpg" alt="">
    </div>
</div>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6" align="center">
        <a href="home"><h2>Library Home page</h2></a>
        <table class="table table-bordered">
            <tr>
                <td align="center">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#userModal">Add New
                        User
                    </button>
                </td>
                <td align="center">
                    <a href="viewusers">
                        <button type="button" class="btn btn-primary">View All Users</button>
                    </a>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#bookModal">Add New
                        Book
                    </button>
                </td>
                <td align="center">
                    <a href="viewbooks">
                        <button type="button" class="btn btn-primary">View All Books</button>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="col-md-3"></div>
</div>


<%--user register form--%>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true" id="userModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form id="" modelAttribute="user" action="register" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title"><i class="fa fa-exclamation-circle"></i>Add a new user</h4>
                </div>
                <div class="modal-body">
                    <table>
                        <tr>
                            <td>User Id</td>
                            <td><form:input path="userId" id="userId" disabled="true"/><br></td>
                            <td><form:errors path="userId" id="userId"/></td>
                        </tr>
                        <tr>
                            <td>Member Type</td>
                            <td>
                                <form:select path="memberType">
                                    <form:option value="" label="Select"/>
                                    <c:forEach items="${user.memberTypelist}" var="memberType">
                                        <form:option value="${memberType}" label="${memberType}"/>
                                    </c:forEach>
                                </form:select>
                                <br>
                            </td>
                            <td><form:errors path="memberType" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td><form:input path="userName" id="userName"/><br></td>
                            <td><form:errors path="userName" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><form:input path="userEmail" id="userEmail"/><br></td>
                            <td><form:errors path="userEmail" cssClass="error"/></td>
                        </tr>
                    </table>

                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="Register">
                </div>
            </form:form>
        </div>
    </div>
</div>


<%--book registration form--%>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true" id="bookModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form id="" modelAttribute="book" action="registerbook" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title"><i class="fa fa-exclamation-circle"></i>Add a new book</h4>
                </div>
                <div class="modal-body">
                    <table>
                        <tr>
                            <td>Book ID</td>
                            <td><form:input path="bookId" id="bookId" disabled="true"/><br></td>
                        </tr>
                        <tr>
                            <td>Book Name</td>
                            <td><form:input path="bookName" id="bookName"/><br></td>
                            <td><form:errors path="bookName" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Book Type</td>
                            <td>
                                <form:select path="bookType">
                                    <form:option value="" label="Select"/>
                                    <c:forEach items="${book.bookTypeList}" var="bookType">
                                        <form:option value="${bookType}" label="${bookType}"/>
                                    </c:forEach>
                                </form:select><br>
                            </td>
                            <td><form:errors path="bookType" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Author</td>
                            <td><form:input path="bookAuthor" id="bookAuthor"/><br></td>
                            <td><form:errors path="bookAuthor" cssClass="error"/></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="Add Book">
                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>
