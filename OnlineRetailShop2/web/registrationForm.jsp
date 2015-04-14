<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="aRegistration" class="retailshop.registration" scope="request"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registration Page</title>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
            <link rel="stylesheet" type="text/css" href="register.css" />
            <script type="text/javascript">
                function transparent(im)
                {
                    if (!im.transparented && (/\.png/.test(im.src)))
                    {
                        im.transparented = 1;
                        var picture = im.src;
                        var w = im.width;
                        var h = im.height;
                        im.src = "images/spacer.gif";
                        im.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod='scale', src='" + picture + "');";
                        im.width = w;
                        im.height = h;
                    }
                    return "transparent";
                }
            </script>
        </head>
        <body>
            <div id="content">
                <div id="header">
                    <ul class="top_menu">

                        <li><a href="#"><b>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </b></a></li>
                        <li><a href="home.jsp" class="active">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <b>Home&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</b></a>|</li>                      
                        <li><a href="myAccountController"><b>My Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</b></a>|</li>
                        <li><a href="#"><b>Contacts</b></a></li>
                    </ul>
                    <div id="search">
                        Product Search<br />																																																							
                        <form action="CategoryController">
                            <select>
                                <option>Category</option>
                            </select>


                            <select id='category'>
                            <c:forEach var="category" items="${aCategory.categoryList}">
                                <option>${category}</option>
                            </c:forEach>
                        </select>
                        <a href="CategoryController?category=category"><img src="images/ok.jpg" alt="setalpm" width="44" height="23" /></a>
                    </form>
                </div>
                <img src="images/tel.jpg" alt="" width="181" height="13" class="tel" /></div>
            <div id="wrapper">
                <div id="background">
                    <div id="left">
                        <h4 class="title1">Shop by category</h4>
                        <c:forEach var="category" items="${aCategory.categoryList}">
                            <ul id="list">
                                <li><a href="showByCategory.jsp" class="type1">${category}</a></li>

                            </ul>
                        </c:forEach>
                        <h4 class="title2">News &amp; Events</h4>
                        <div class="news">
                            <span>6 december</span>
                            <p>Sony just launched a new series of VAIO TX3 notebooks and part of the family is the advanced and stylish VGN-TX92S. The latest Vaio VGN-TX92S holds a Vista Ready icon, and, from what the manufacturer says, it can be tailored under the Vaio "Owner Made" program, which enables the user to pick the right combination of hardware, software and notebook color, informs Mobile Whack.</p>
                            <a href="http://news.softpedia.com/news/Sony-s-Latest-Vaio-VGN-TX92S-Notebook-26417.shtml" class="more">read more</a>
                        </div>
                        <div class="news">
                            <span>6 december</span>
                            <p>Tablet PC News Archives; NEWS CATEGORIES; Apple iPad News; ... Looking for a Tablet PC deal? Find the latest deals and coupons on TabletPCReview.com. HP Special Offers. </p>
                            <a href=""http://www.tabletpcreview.com"" class="more">read more</a>
                        </div>
                        <img src="images/cash.png" alt="" width="182" height="111" class="" />
                    </div>
                    <%--Center Start--%>
                    <div id="center" class="entries">         	

                        <center>
                            <br /><br />
                            <h2><u>Customer Registration Form</u></h2><br /><br /><br /><br />
                            <form action="registrationController" method="post">
                                Enter first name:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fName"/><br /><br /><br />
                                Enter last name:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lName"/><br /><br /><br />
                                Enter Contact:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="contact"/><br /><br /><br />
                                Enter Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"/><br /><br /><br />
                                Enter Type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="type" value="customer" disabled="on click"/><br /><br /><br />
                                Enter email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"/><br /><br /><br />
                                Enter password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pass"/><br /><br /><br />
                                Confirm password:&nbsp;<input type="password" name="conPass"/><br /><br /><br />
                                <input type="submit" name="submit" value="Submit"/><br /><br /><br />
                                <!-- <a href="#"><img src="images/ok.jpg" alt="setalpm" width="44" height="23" /></a>-->
                                <script lang="text/javascript">
                                    alert("${regMessage}")
                                </script> 
                            </form>
                        </center>
                    </div>
                    <%--Center End--%>
                    <div id="right">
                        <img src="images/coupon1.png" alt="" width="182" height="111" class="" />

                        <div class="entry">
                            <form action="#">
                                Login<br />
                                <input type="text" /><br />
                                Password<br />
                                <input type="text" /><br />
                                <a href="#" class="forgot">Forgot password</a>
                            </form>
                        </div>
                        <p class="below"><a href="#">Registr</a> <a href="#"><img src="images/enter.jpg" alt="" width="52" height="23" /></a></p>
                        <div class="users">
                            <p>Currently Active Users:</p>
                            <p><font>257</font></p>
                        </div>
                        <h4 class="title3">Shop by brand</h4>
                        <ul class="brands">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <div>

                <p id="bft">Copyright &copy;. All rights reserved. Design by Mr.Kaiser & Saif Alam</p>																																																																																			
            </div>
        </div>
    </body>
</html>
