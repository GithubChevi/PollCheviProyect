<%-- 
    Document   : ViewEnd
    Created on : 13-dic-2016, 19:39:39
    Author     : Chevi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/styles.css"/>
        <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
        <title>Thank You!</title>
    </head>
    <body>
        <h1 style="text-align: center;">You have voted in the Poll</h1>
        <p>Go to the index page if you want to see the details, the most voted and more! Thank you for your time.</p>
        <div class="div_back" onclick="location.assign('../index.jsp')">
            <img src="../SRC/left_icon.png" class="img_back"/>
        <a class="label1">Go to the Index</a>
        </div>
    </body>
</html>
