<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h1><%= "Hello World!" %></h1> <br/>

<h1>Current time: <p id="time"> </p></h1>

<a href="hello-servlet">Hello Servlet</a>

<h3>Parametrii</h3>
<form method="GET" action="parameters-servlet">
    <input type="text" name="param1" placeholder="First parameter"></input> <br />
    <input type="text" name="param2" placeholder="Second parameter"></input> <br />
    <input type="text" name="param3" placeholder="Third parameter"></input> <br />
    <button>Send.</button>
</form>

<h3>Tabel</h3>
<form method="POST" action="table-servlet">
    <input type="text" name="name" placeholder="First Name"></input> <br />
    <input type="text" name="lastname" placeholder="Last Name"></input> <br />
    <button>Send</button>
</form>

<h3>Code</h3>
<form method="POST" action="code-servlet">
    <textarea rows="6" cols="40" name="code"></textarea>
    <button>Send</button>
</form>

<h3>User details</h3>
<form method="POST" action="user-details-servlet">
    <input type="text" name ="firstName", placeholder="First Name"></input> <br />
    <input type="text" name ="lastName", placeholder="Last Name"></input> <br />
    <input type="email" name ="email", placeholder="Email"></input> <br />
    <button>Send</button>
</form>

<script>
    function updateTime() {
        fetch("time-servlet")
            .then(response => response.text())
            .then(html => {
                document.getElementById("time").innerHTML = html;
            })
        .catch(err => console.log(err));
    }

    updateTime();

    setInterval(updateTime, 5000);
</script>

</body>
</html>