
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab5</title>
        <script>

        </script>
    </head>
    <body>
        Licznik odwiedzin: ${sessionScope.Counter} <br>
        <h1>Tabela osób</h1>
        <table style="width:50%" border="solid black">
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${lista}"  var="dane">
                <tr>
                    <td>
                        ${dane.firstName}
                    </td>
                    <td>
                        ${dane.lastName}
                    </td>
                    <td>
                        ${dane.email}
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action='/Lab5/personList' method='post'>
            Podaj imie:
            <input type='text' name='imie'>
            Podaj nazwisko:
            <input type='text' name='nazwisko'>
            Podaj email:
            <input type='text' name='email'>
            <input type='submit'>
        </form>
        
    </body>
</html>
