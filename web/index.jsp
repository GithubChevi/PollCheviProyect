<%-- 
    Document   : index
    Created on : 05-dic-2016, 20:05:30
    Author     : jvictor
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<% 
    String msg = (String)session.getAttribute("msg");
    session.invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/styles.css"/>
        <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
        <script type="text/javascript" src="JS/js.js"></script>
        <title>Anime Poll Github</title>
    </head>
    <body id="body">
        <header id="header">
            <img id="naruto_1" class="img_header" src="SRC/naruto_1.jpg"/>
            <img id="header_anime" class="img_header" src="SRC/anime.png"/>
            <h3 id="h3_header">Welcome to the new Poll<hr>Which is the best Anime?</h3>
            <img id="ban_1" class="img_header" src="SRC/ban_1.jpg"/>
            <p> Jorge Esta modificando tu proyecto</p>
            <p> Jorge Esta modificando tu proyecto</p>
            <p> Jorge Esta modificando tu proyecto</p>
            <p> Jorge Esta modificando tu proyecto</p>
            <p> Jorge Esta modificando tu proyecto</p>
            <p> Jorge Esta modificando tu proyecto</p>
        </header>
        <div id="div_login">
            <div id="div_login_1">
                <form id="form_2" action="Dispatcher">
                    <table id="yo" style="margin-top: 75px;">
                        <tr>
                            <th style="text-align: center;" colspan="8">User login</th>
                        </tr>
                        <tr>
                            <td colspan="2">NIF :</td>
                            <td colspan="2"><input name="nif" type="text" maxlength="9" size="9" required="required" placeholder="Type your nif" style="margin-left:5px;"/></td>
                            <td colspan="2">Password :</td>
                            <td colspan="2"><input name="pass" type="password" maxlength="20" required="required" size="20" placeholder="Type the pass" style="margin-left:5px;"/></td>
                        </tr>
                    </table>
                <button id="b_1" name="Submit" type="submit" value="signUp" class="b_form_2" style="margin-right: 75px;">Sign up</button>
                <button id="b_2" name="Submit" type="submit" value="logIn" class="b_form_2" style="margin-right: 30px;">Log In</button>
                <button id="b_3" name="Submit" type="submit" value="deleteUser" class="b_form_2" style="margin-right: 30px;">Delete User</button>
                </form>
                <button id="b_4" name="Submit" onclick="location.assign('Results_servlet')" value="results" class="b_form_2" style="margin-right: 30px;">Results</button>
                <button id="b_5" name="Submit" onclick="location.assign('Census_servlet')" value="census" class="b_form_2" style="margin-right: 30px;">Census</button>
                <button id="b_6" name="Submit" onclick="location.assign('ClosePoll')" value="end" class="b_form_2" style="margin-right: 30px;">End the Poll</button>
                <br>
                <br>
                <br>
                <% 
                    if(msg != null){ %>
                    <p style="margin-left: 20px;color: red;"><%=msg%></p>
                    <% }
                %>
            </div>
        </div>
        
    </body>
</html>
