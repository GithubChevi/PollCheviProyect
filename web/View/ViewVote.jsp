<%@page import="Model.User"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<% 
    User user = (User)session.getAttribute("user");
    String nif = user.getNif();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/styles.css"/>
        <link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">
        <script type="text/javascript" src="../JS/js.js"></script>
        <title>Vote page</title>
    </head>
    <body id="body">
        <header id="header">
            <img id="naruto_1" class="img_header" src="../SRC/naruto_1.jpg"/>
            <img id="header_anime" class="img_header" src="../SRC/anime.png"/>
            <h3 id="h3_header">Welcome to the new Poll<hr>Which is the best Anime?</h3>
            <img id="ban_1" class="img_header" src="../SRC/ban_1.jpg"/>
        </header>
        <div id="div_1">
            <div id="div_1_1">
                <h6 style="margin-left: 30px;">Welcome <%=nif%> !</h6>
                <form id="form_1" class="form_1" action="../Vote_servlet">
                    <h3 style="text-align: center;">Anime List</h3>
                    <hr>
                    <div id="anime_list_left">
                        <img class="img_width" src="../SRC/onepiece_1.jpg"/>
                        <label class="label_center"><input class="input_center" style="margin-top: 15px;" type="radio" name="anime_list" value="One Piece"/>One Piece</label>
                        <br>
                        <img class="img_width" src="../SRC/naruto_2.png"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Naruto"/>Naruto</label>
                        <br>
                        <img class="img_width" src="../SRC/fullmetal_1.jpg"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Fullmetal Alchemist"/>Fullmetal Alchemist</label>
                        <br>
                        <img class="img_width" src="../SRC/nanatsu_1.jpg"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Nanatsu no Taizai"/>Nanatsu no Taizai</label>
                    </div>
                    <div id="anime_list_right">
                        <img class="img_width" src="../SRC/kuroko_1.jpg"/>
                        <label class="label_center"><input style="margin-top: 15px;" type="radio" name="anime_list" value="Kuroko no Basket"/>Kuroko no Basket</label>
                        <br>
                        <img class="img_width" src="../SRC/bleach_1.jpg"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Bleach"/>Bleach</label>
                        <br>
                        <img class="img_width" src="../SRC/fairy_1.jpg"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Fairy Tail"/>Fairy Tail</label>
                        <br>
                        <img class="img_width" src="../SRC/shingeki_1.jpg"/>
                        <label class="label_center"><input type="radio" name="anime_list" value="Shingeki no Kyojin"/>Shingeki no Kyojin</label>
                        <button id="b_vote" style="float: right;width: 80px;" type="submit">Vote</button>
                    </div>
                </form>
            </div>
            <aside id="aside_1">
                <h4 style="text-align: center;">Random Anime</h4>
                <hr>
                <br>
                <%
                    
                    //JOptionPane.showMessageDialog(null, nif,"hi",JOptionPane.INFORMATION_MESSAGE);
                    int x = (int)(Math.random()*8+1);
                    switch(x){
                        case 1:
                            %><h2 style="text-align: center;">One Piece</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Monkey D. Luffy wants to be the pirate king, therefore he groups people
                            to join him to become a legend and get the treasure.</p>
                            <img  src="../SRC/onepiece_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 2:
                            %><h2 style="text-align: center;">Naruto</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Uzumaki Naruto is a ninja who started a story with his group (Group 7 with Sasuke and Sakura)
                            to become Hogake and bring peace around the world.</p>
                            <img  src="../SRC/naruto_2.png" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 3:
                            %><h2 style="text-align: center;">Fullmetal Alchemist</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Edward Elric is an alchemist who wants to bring his brother to life and restore
                            the peace in the alchemists world.</p>
                            <img  src="../SRC/fullmetal_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 4:
                            %><h2 style="text-align: center;">Nanatsu no Taizai</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Meliodas is the captain of a group with a total of 7 members, also called 'The seven Sins'
                            and they fight to bring peace in the kingdom, however the demons' door is closely opened...</p>
                            <img  src="../SRC/nanatsu_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 5:
                            %><h2 style="text-align: center;">Kuroko no Basket</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Several years ago there was a basketball team that never had lost, nobody knows where they are
                            but the season is about to start...</p>
                            <img  src="../SRC/kuroko_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 6:
                            %><h2 style="text-align: center;">Bleach</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Ichigo Kurosaki got the power of a shinigami, as from that he should defend the good souls from 
                            hollows.</p>
                            <img  src="../SRC/bleach_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 7:
                            %><h2 style="text-align: center;">Fairy Tail</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">Natsu, Lucy and Happy starts a story to join Fairy Tail's group, a popular
                            guild of magic.</p>
                            <img  src="../SRC/fairy_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        case 8:
                            %><h2 style="text-align: center;">Shingeki no Kyojin</h2>
                            <br>
                            <h4 style="text-align: center;">Description</h4>
                            <hr>
                            <p id="p_desc" style="text-align: center;">The humanity lives around walls,¿why? Nobody knows. One day in Shiganshina a 60 meters
                            titan appeared alongside a reinforced titan, now the humanity has to defend itself.</p>
                            <img  src="../SRC/shingeki_1.jpg" id="img_desc" style="margin-left: 25px;" class="img_width"/><%
                            break;
                        default:
                            break;
                    }
                %>
            </aside>
        </div>
        <footer id="footer">
            <div class="div_back2" onclick="location.assign('../index.jsp')">
            <img src="../SRC/left_icon.png" class="img_back"/>
            <a class="label1">Go to the Index</a>
            </div>
            <img id="social" src="../SRC/social_bar.png"/>
        </footer>
    </body>
</html>
