<%@ page isELIgnored="false" %>

<html>
<head> <title>Accessing Bean Properties</title> </head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
<TR> <TH CLASS="TITLE"> Accessing Bean Properties
</TABLE> <P>

<p> ${course} </p>

<UL>
<LI><B>First name instructor:</B> ${course.instructor.firstName}
<LI><B>Last name instructor:</B> ${course.instructor.lastName}
<LI><B>Course code:</B> ${course.subject.code}
<LI><B>Course name:</B> ${course.subject.name}
</UL>
</body>
</html>