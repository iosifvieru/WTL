<%@ page isELIgnored="false" %>

<html>
<body>
<h2> Hello from Lab03 </h2>

<a href="scoped-vars">Scoped vars</a> <br/>
<a href="bean-props">Bean props</a> <br/>

<p style="color: red">${formError}</p>
<p style="color: blue">${formMessage}</p>
<form method="GET" action="triangle">
    <input type="number" name="a" placeholder="Latura 1"/> <br />
    <input type="number" name="b" placeholder="Latura 2"/> <br />
    <input type="number" name="c" placeholder="Latura 3"/> <br />

    <button>Send</button>
</form>

</body>
</html>
