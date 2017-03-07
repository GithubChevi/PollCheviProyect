<%-- 
    Document   : Results
    Created on : 13-dic-2016, 23:22:31
    Author     : Chevi
--%>

<%@page import="com.sun.org.apache.xml.internal.security.utils.Base64"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Toolkit"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.swing.ImageIcon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Anime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Anime> list = (ArrayList<Anime>)session.getAttribute("anime_list");
    BufferedImage img;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/styles.css"/>
        <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
        <title>Results</title>
    </head>
    <body id="body_results">
        <div id="div_results">
               <% for(Anime anime:list){
                   String photo = Base64.encode(anime.getImg());
               %>
            <div class="div_res">
               <p class="p_res"><%=anime.getName()%></p>
               <img class="img_res" src="data:img/png;base64,<%=photo%>">
               <p style="text-align: center;margin-top: -5px;"><%=anime.getVotes()%> votes</p>
            </div>
            <% }
            %>
            <div class="div_back2" onclick="location.assign('../index.jsp')">
            <img src="../SRC/left_icon.png" class="img_back"/>
            <a class="label1">Go to the Index</a>
            </div>
        </div>
        <footer id="footer">
            <img id="social" src="../SRC/social_bar.png"/>
        </footer>
    </body>
</html>
