<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinuka
  Date: 7/17/17
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Book</title>
    <style type="text/css">
        .error{
            color: brown;
        }
    </style>
</head>
<body>
<form:form id="" modelAttribute="book" action="registerbook" method="post">
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

        <tr>
            <td></td>
            <td><input type="submit" value="Add Book"></td>
        </tr>
    </table>

</form:form>


<br><br>

<a href="home"><button>Go To Home Page</button></a>
</body>
</html>
