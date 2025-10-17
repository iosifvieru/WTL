<!DOCTYPE HTML>
<html>
<head>
    <title>Schimba culoarea</title>
</head>
<body>

<%
    String bgClr = (String) session.getAttribute("backgroundColor");
    String txtClr = (String) session.getAttribute("textColor");
%>

<form method="POST" action="change-session-colors">
    <label for="backgroundColor">Culoare de fundal: </label>
    <input type="color" name="backgroundColor" id="backgroundColor" value="<%= (bgClr != null) ? bgClr : "#ff0000" %>" />

    <label for="textColor">Culoare textului: </label>
    <input type="color" name="textColor" id="textColor" value="<%=  (txtClr != null) ? txtClr : "#ffff00" %>" />

    <button>Schimba</button>
</form>

</body>
</html>