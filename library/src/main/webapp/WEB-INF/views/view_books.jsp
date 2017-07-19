<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinuka
  Date: 7/17/17
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Books</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-12">&nbsp;</div>
    </div>

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-3" align="left">
            <a href="home">
                <button type="button" class="btn btn-primary">Go To Home Page</button>
            </a>
        </div>
        <div class="col-md-7"></div>
    </div>

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" align="center">
            <h3>Books</h3><br>
            <table class="table table-bordered">
                <tr>
                    <th>Book Id</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Book Type</th>
                </tr>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookAuthor}</td>
                        <td>${book.bookType}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-2"></div>
    </div>

</div>

</body>
</html>
