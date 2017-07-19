<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  FormUser: dinuka
  Date: 7/17/17
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Register User</title>
    <style type="text/css">
        .error{
            color: brown;
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(window).on('load',
            function(){
            $('#onload').modal('show');
        });
    </script>
</head>
<body>

<a href="home"><button type="button" class="btn btn-default" >Go To Home Page</button></a>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true"  id="onload">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title"><i class="fa fa-exclamation-circle"></i>Add a new user</h4>
            </div>
            <div class="modal-body">
                <form:form id="" modelAttribute="user" action="register" method="post">
                    <table>
                        <tr>
                            <td>User Id</td>
                            <td><form:input path="userId" id="userId" disabled="true"/><br></td>
                            <td><form:errors path="userId" id="userId" /></td>
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
                        <tr>
                            <td></td>
                            <td><input type="submit" class="btn btn-default" value="Register"></td>
                        </tr>
                    </table>
                </form:form>
            </div>
            <div class="modal-footer">
                <a href="home"><button type="button" class="btn btn-default">Go To Home Page</button></a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
