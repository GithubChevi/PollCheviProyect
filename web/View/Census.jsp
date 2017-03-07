<%-- 
    Document   : Census
    Created on : 14-dic-2016, 19:27:25
    Author     : Chevi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<User> list = (ArrayList<User>)session.getAttribute("census_list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/styles.css"/>
        <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
        <title>Census</title>
    </head>
    <body id="body_census">
        <div id="div_census">
            <div class="div_info">
                <table id="table_census" class="table_census">
                    <tr>
                        <th colspan="3">NIF</th>
                        <th colspan="1">Voted?</th>
                    </tr>
                    <%
                        for(User user:list){ %>
                            <tr>
                                <td colspan="3"><%=user.getNif()%></td>
                                <%
                                    if(user.getVote() == true){ %>
                                    <td colspan="1">Yes</td> <%
                                    }
                                    else{ %>
                                    <td colspan="1">No</td> <%
                                    }
                                %>
                            </tr>
                    <%  }
                    %>
                </table>
            </div>
            <div class="div_back2" onclick="location.assign('../index.jsp')">
            <img src="../SRC/left_icon.png" class="img_back"/>
            <a class="label1">Go to the Index</a>
            </div>
        </div>
                <div>Arriba la práctica 12 de Despliegue - by Chevy</div>
        <footer id="footer">
            <img id="social" src="../SRC/social_bar.png"/>
        </footer>
    </body>
</html>
