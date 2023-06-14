<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>News</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <nav class="nav mb-1 mt-1">
                <a class="nav-link" href="#">Начало</a>
                <a class="nav-link" href="#">Общи</a>
                <a class="nav-link" href="#">Контакт</a>
            </nav>
            <div class="row">
                <div class="col-md-8">
                    <div class="list-group">
                        <c:forEach items="${page.content}" var="news">
                            <a href="/${news.id}" class="list-group-item list-group-item-action">${news.title}</a>
                        </c:forEach>
                    </div>
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/?page=${previousPage.pageNumber}">Previous</a></li>
                        <c:forEach var="page" begin="1" end="${page.totalPages}">
                            <li class="page-item">
                                <a class="page-link" href="/?page=${page}">
                                    <c:out value="${page}" />
                                </a>
                            </li>
                        </c:forEach>
                        <li class="page-item"><a class="page-link" href="/?page=${nextPage.pageNumber}">Next</a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    Column
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>