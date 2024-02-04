<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Управление доступом пользователей</title>
</head>
<body>
<div>
    <div class="container">
        <h1 align="center">Список пользователей</h1>
         <a href="chat?command=chat">Назад</a>
        <div>
        <table border="1">
            <thread>
                <tr>
                    <th>login</th>
                    <th>password</th>
                    <th>name</th>
                    <th>userType</th>
                    <th>online</th>
                    <th>access</th>
                    <th>edit access</th>
                </tr>
            </thread>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.userType}</td>
                    <c:choose>
                        <c:when test="${user.isOnline()==true}">
                            <td>online</td>
                            <br />
                        </c:when>
                        <c:otherwise>
                            <td>offline</td>
                            <br />
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${user.isPermissionToSendMessage()==true}">
                                <td>+</td>
                                <br />
                            </c:when>
                            <c:otherwise>
                                <td>-</td>
                                <br />
                            </c:otherwise>
                        </c:choose>

                            <c:choose>
                            <c:when test="${user.isPermissionToSendMessage()==true}">
                                <td><input type="checkbox" onclick= "checkPermission('${user.login}')"  id="permission" checked /><td>
                                <br />
                            </c:when>
                            <c:otherwise>
                                <td><input type="checkbox" onclick="checkPermission('${user.login}')"  id="permission" unchecked /><td>
                                <br />
                            </c:otherwise>
                            </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>

    </div>
</div>
</body>
<script>
    <%@include file="../js/adminAccessControl.js"%>
</script>
</html>
