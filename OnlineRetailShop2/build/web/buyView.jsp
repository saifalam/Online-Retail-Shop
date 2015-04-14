<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="aProductInfo" class="retailshop.ProductInfo" scope="session" ></jsp:useBean>
<jsp:useBean id="aCategory" class="retailshop.Category" scope="session" ></jsp:useBean>
<jsp:useBean id="aSupplier" class="retailshop.Supplier" scope="session" ></jsp:useBean>
<jsp:useBean id="aCategoryShow" class="retailshop.CategoryShow" scope="session" ></jsp:useBean>
<jsp:useBean id="aProductDetailList" class="retailshop.ProductDetailList" scope="session" ></jsp:useBean>
<jsp:useBean id="aPrice" class="retailshop.Price" scope="session" ></jsp:useBean>
<jsp:useBean id="aLoginInfo" class="retailshop.LoginInfo" scope="session" ></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy view</title>
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
                                <li><a href="CategoryController?category" class="type1">${category}</a></li>

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
                    <div id="center"> 
                        <div id="photo1"><img src="images/tpart.png" alt="" width="49" height="23" class="transparent" /><br>           
                        </div>
                        <form action="TransactionController" method="post">
                            <c:forEach var="product" items="${aProductDetailList.productList}">
                                <table>
                                    <tr> 
                                    </tr>
                                    <th><p class="more1">Product Name :</p></th>
                                    <td><input type="text" name="productName" value="${product.productName}"/> ></td>
                                    <th><p class="more1">Quantity :</p></th>
                                    <td>
                                        <input type="text" name="quantity" value="1">
                                    </td>
                                    <tr>
                                    </tr>
                                    <th><p class="more1">Unit Price :</p></th>
                                    <td><input type="text" name="price" value=<fmt:formatNumber value="${product.price}"/> ></td>
                                    <th><input type="submit" value="Transaction" name="submit"/></th>

                                    <%--  <th><a href="ShoppingCartController?quantity"><img src="images/shopping.jpg" alt="" width="60" height="30" /></a></th>--%>
                                    <tr>
                                    </tr>                             
                                </table>
                                <center> <b><font color="red">${stock}</font></b></center>
                                    </c:forEach>

                        </form>

                    </div>
                    <%--Center End--%>
                    <div id="right">
                        <c:forEach var="log" items="${aLoginInfo.loginList}" >
                            <b><font color="black">  ${message}&nbsp;</font><font color="green" size="1"><i>${log.firstName}</font></i></b>
                            </c:forEach>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="LogoutController">${logoutMessage}</a>
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
                        <p class="below"><a href="#">Register</a> <a href="#"><img src="images/enter.jpg" alt="" width="52" height="23" /></a></p>
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

                <p id="bft">Copyright &copy;. All rights reserved. Design by Mr.Kaiser & Saif Alam</p>																																																																																			
            </div>
        </div>
    </body>
</html>

