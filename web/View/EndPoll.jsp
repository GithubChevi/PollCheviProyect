<%-- 
    Document   : EndPoll
    Created on : 18-dic-2016, 14:14:14
    Author     : Chevi
--%>

<%@page import="com.sun.org.apache.xml.internal.security.utils.Base64"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Anime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int cont=0;
    int num = (Integer)session.getAttribute("numwinner");
    ArrayList<Anime> list = (ArrayList<Anime>)session.getAttribute("listwinner");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/styles.css"/>
        <title>And the winner is..</title>
    </head>
    <body>
        <div class="closepoll">
            <h1 id="h_winner" style="text-align: center;color:white;">And the winner with <%=num%> votes is...</h1>
            <%
                for(Anime anime:list){
                    cont++;
                    String photo = Base64.encode(anime.getImg());
            %>
                <div class="box_1">
                    <h4 style="text-align: center;"><%=anime.getName()%></h4>
                    <hr>
                    <img class="img_res" src="data:img/png;base64,<%=photo%>"/>
                </div> <%
                }
                
                if(cont > 1){ %>
                <script>document.getElementById("h_winner").innerHTML = "It's a draw with "+<%=num%>+" votes";</script> <%
                }
            %>
            
        </div>
        <div class="div_back2" onclick="location.assign('../index.jsp')">
            <img src="../SRC/left_icon.png" class="img_back"/>
            <a class="label1">Go to the Index</a>
        </div>
        <footer id="footer">
            <img id="social" src="../SRC/social_bar.png"/>
        </footer>
    </body>
</html>
