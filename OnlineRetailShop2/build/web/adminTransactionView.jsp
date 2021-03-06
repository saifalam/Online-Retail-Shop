<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="aProductInfo" class="retailshop.ProductInfo" scope="session" ></jsp:useBean>
<jsp:useBean id="aCategory" class="retailshop.Category" scope="session" ></jsp:useBean>
<jsp:useBean id="aSupplier" class="retailshop.Supplier" scope="session" ></jsp:useBean>
<jsp:useBean id="aLoginInfo" class="retailshop.LoginInfo" scope="session" ></jsp:useBean>
<jsp:useBean id="aAdminTransaction" class="retailshop.AdminTransaction" scope="session"></jsp:useBean>
<jsp:useBean id="aAdminTransactionList" class="retailshop.AdminTransactionList" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin transaction view</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <link rel="stylesheet" type="text/css" href="style.css" />
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
                    <li><a href="#">
                            <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </b></a></li>
                    <li><a href="adminHome.jsp" class="active">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <b>Home&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</b></a>|</li>                     
                    <li><a href="myAccountController"><b>My Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</b></a>|</li>
                    <li><a href="AdminTransactionController"><b>Transaction&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</b></a></li>
                    <li><a href="#"><b>Inventory&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></a></li>
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
                                <li><a href="CategoryController?category=${category}" class="type1">${category}</a></li>

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
                    <div id="center">
                        <div id="items">
                            <center>
                                <b><i><font color="red" size="5"> ${adminMessage}</font></i></b><br/><br/><br/><br/>
                                <table border="2" bordercolor="white">
                                    <tr>
                                        <th style="color: antiquewhite">tId</th>
                                        <th style="color: antiquewhite">pId</th>
                                        <th style="color: antiquewhite">pName</th>
                                        <th style="color: antiquewhite">price</th>
                                        <th style="color: antiquewhite">quantity</th>
                                        <th style="color: antiquewhite">uId</th>
                                        <th style="color: antiquewhite">sellDate</th>
                                        <th style="color: antiquewhite">more info</th>
                                    </tr>
                                    <c:forEach var="transactionInfo" items="${aAdminTransactionList.adminTransactionList}">       
                                        <tr>
                                            <th style="color: antiquewhite">${transactionInfo.transactionId}</th>
                                            <th style="color: antiquewhite">${transactionInfo.productId}</th>
                                            <th style="color: antiquewhite">${transactionInfo.productName}</th>
                                            <th style="color: antiquewhite">${transactionInfo.price}</th>
                                            <th style="color: antiquewhite">${transactionInfo.quantity}</th>
                                            <th style="color: antiquewhite">${transactionInfo.uId}</th>
                                            <th style="color: antiquewhite">${transactionInfo.sellDate}</th>
                                            <th style="color: antiquewhite"><a href="CustomerDetailsController?id=${transactionInfo.transactionId}">more info</a></th>
                                        </tr>

                                    </c:forEach> 
                                </table>
                            </center>
                        </div>
                    </div>
                    <div id="right">
                        <c:forEach var="log" items="${aLoginInfo.loginList}" >
                            <b><font color="black">  ${message}&nbsp;</font><font color="green" size="1"><i>${log.firstName}</font></i></b>
                            </c:forEach>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="LogoutController">${logoutMessage}</a>
                        <h4 class="title2"><img src="images/cart.gif" alt="" width="18" height="19" class="cart" />Shopping Cart</h4>
                        <img src="images/coupon1.png" alt="" width="182" height="111" class="" />
                        <font face="sans-serif" color="red" size="4"> &nbsp;&nbsp;&nbsp;<blink>${warning}</blink> </font>
                        <h4 class="title3">Entry</h4>
                        <div class="entry">
                            <form action="loginController" method="post">
                                Login<br />
                                <input type="text" name="email" /><br />
                                Password<br />
                                <input type="password" name="password"/><br />
                                <!-- <a href="loginController" class="forgot">Forgot password</a>-->
                                <input type="submit" name="submit" value="login"/><br /> 
                                <!--  <script lang="text/javascript">
                                      alert("${loginMessage}")
                                  </script> -->
                            </form>
                        </div>

                        <p class="below"><a href="registrationForm.jsp">Registr</a> <a href="loginController"><img src="images/enter.jpg" alt="" width="52" height="23" /></a></p>

                        <div class="users">
                            <p>Currently Active Users:</p>
                            <p><font>257</font></p>
                        </div>

                        <h4 class="title3">Shop by brand</h4>
                        <ul class="brands">
                            <c:forEach var="supplier" items="${aSupplier.supplierList}">
                                <li class="color"><a href="#">${supplier}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <div>

                <p id="bft">Copyright &copy;. All rights reserved. Design by Mr.Kaiser & Saif Alam </p>																																																																																			
            </div>
        </div>
    </body>
</html>
