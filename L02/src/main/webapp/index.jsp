<!DOCTYPE html>
<html>
<head>
    <title>Web Technologies and Languages</title>
</head>
<body>
<h1>
    WTL02 laboratory
</h1>
<br/>
<a href="cookies">All Cookies Servlet</a>
<br/>
<a href="repeat-cookie">Repeat Cookie Servlet</a>
<br/>
<a href="count-cookie">Count Cookie Servlet</a>
<br/>
<a href="first-urlwrite?userName=firstUserUrlRewrite">First UrlRewrite Servlet</a>
<br/>
<a href="first-hidden?userName=firstUserHidden">First Hidden Servlet</a>
<br/>
<a href="first-session?userName=firstUserSession">First Session Servlet</a>
<br/>
<a href="show-session">Show Session Servlet</a>

<br/><br/>

<a href="table-cookies">Tabel cu cookies si sesiuni</a>

<br />

<a href ="colored-page">Catre pagina cu text colorat si fundal. </a>

<br/><br/>
<%
    String error = (String) session.getAttribute("errorMessage");
    String firstName = (String) session.getAttribute("firstName");
    String lastName = (String) session.getAttribute("lastName");
    String email = (String) session.getAttribute("email");

    if(error != null) {
%>
    <p style="color: red;"><%= error %></p>
<%
    session.removeAttribute("errorMessage");
    }
%>

<form method="POST" action="profile-servlet">
    <input type="text" placeholder="First Name" name="firstName"
           value="<%= (firstName != null) ? firstName : "" %>" /> <br />

    <input type="text" placeholder="Last Name" name="lastName"
           value="<%= (lastName != null) ? lastName : "" %>" /> <br />

    <input type="email" placeholder="Email" name="email"
           value="<%= (email != null) ? email : "" %>" /> <br />
    <input type="submit" value="Submit"/>
</form>


<br /><br /><br />
<h3>Buy items.</h3>

<%
    String shoppingError = (String) session.getAttribute("shoppingCartError");
    if(shoppingError != null) {
%>
    <p style="color: red;"><%= shoppingError %></p>
<%
    session.removeAttribute("shoppingCartError");
    }
%>
<form method="POST" action="add-to-cart">
    <input type="text" placeholder="Product Name" name="productName"></input><br />
    <button>Buy</button>
</form>

<%@ page import="java.util.List" %>
<%@ page import="org.L02.models.Product" %>
<h3>Your items</h3>
<ul>
<%
    List<Product> shoppingCart = (List<Product>) session.getAttribute("shopping-cart");
    if (shoppingCart != null && !shoppingCart.isEmpty()) {
        for (Product p : shoppingCart) {
%>
    <li>ProductName: <%= p.getProductName() %> Quantity: <%= p.getQuantity() %></li>
<%
        }
    } else {
%>
    <li>No items in your cart.</li>
<%
    }
%>
</ul>

</body>
</html>