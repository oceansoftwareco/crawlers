<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>News</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <c:forEach items="${page.content}" var="news">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:out value="${news.title}" />
                        </h5>
                        <div class="card-text">
                            <c:out value="${news.content}" />
                        </div>
                        <a href="${news.url}" class="card-link">Прочети още</a>
                    </div>
                </div>
            </c:forEach>

            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${page.previousOrFirstPageable()}">Previous</a></li>
                <c:forEach var="page" begin="1" end="${page.totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="/?page=${page}">
                            <c:out value="${page}" />
                        </a>
                    </li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="${page.nextOrLastPageable()}">Next</a></li>
            </ul>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>