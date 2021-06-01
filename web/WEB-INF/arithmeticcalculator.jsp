<%-- 
    Document   : helloWorldForm
    Created on : May 25, 2021, 2:29:37 PM
    Author     : 854950
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post">
            <label>First:</label>
            <input type="text" name="first_number" value="${firstNumber}" placeholder="1">
            <br>
            <label>Second:</label>
            <input type="text" name="second_number" value="${secondNumber}" placeholder="2">
            <br>
            
            <input type="submit" name="button" class="button1" value="+">
            <input type="submit" name="button" class="button2" value="-">
            <input type="submit" name="button" class="button3" value="*">
            <input type="submit" name="button" class="button4" value="%">         
        </form>
        <p>Result: ${message}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>
