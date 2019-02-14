<%--
  Created by IntelliJ IDEA.
  User: Aqualon
  Date: 14.02.2019
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Статья добавлена</title>
    <spring:url value="/resources/img/article-added.png" var="articleAdded" />
    <spring:url value="/resources/css/fonts.css" var="fontsCss" />
    <spring:url value="/resources/css/styles.css" var="stylesCss" />
    <link rel="stylesheet" href="${fontsCss}">
    <link rel="stylesheet" href="${stylesCss}">
</head>
    <body class="added-article-message">
        <div class="added-article-wrapper">
            <img class="article-added-success" src="${articleAdded}" alt="Успешное добавление статьи">
            <a href="/blog" class="cancel-btn new-article-btn">Вернуться на главную</a>
        </div>
    </body>
</html>
