<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
        <style>
        .chat {
            border: 1px solid silver;
            width: 100%;
            height: 200px;
            overflow-y: scroll;
        }
        .msg {
            width: 90%;
            margin-bottom: 1em;
        }
        </style>
    </head>
    <body>
        <div align="center">
            <a href="chat?command=logout">Выход</a>

            <div align="left" class="chat">
                <c:forEach items="${messages}" var="message">
                    <div class = "msg">
                         ${message.user.name}: ${message.message}
                    </div>
                </c:forEach>
            </div>
            <form method="post" action="chat?command=show_chat_page">
                <input type="text" name="message" placeholder="Введите сообщение"/>
                <button type="submit">Отправить</button>
            </form>
           <c:if test="${user.userType == 'ADMIN'}">
               <a href="chat?command=show_admin_page">Настройки доступа</a>
           </c:if>
        </div>
    </body>
</html>