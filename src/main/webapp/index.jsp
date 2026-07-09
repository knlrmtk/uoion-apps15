<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.InetAddress" %>

<%
    request.setAttribute("hostname", InetAddress.getLocalHost().getHostName());
%>

<!DOCTYPE html>
<html>
<head>
    <title>UOION</title>
</head>
<body>
    <h1>Welcome to UOION</h1>
    <h2>
        Application deployed successfully on Tomcat Server...!<br>
        Hostname: ${hostname}
    </h2>
</body>
</html>
