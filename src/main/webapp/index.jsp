<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <title>UOION Demo Application</title>

    <style>

        body{
            font-family: Arial;
            background:#f4f6f9;
        }

        .card{

            width:700px;
            margin:auto;
            margin-top:40px;
            background:white;
            border-radius:10px;
            padding:25px;
            box-shadow:0 0 10px gray;

        }

        table{

            width:100%;
            border-collapse:collapse;

        }

        td{

            padding:12px;
            border-bottom:1px solid #ddd;

        }

        h1{

            color:#0077cc;

        }

        .value{

            color:green;
            font-weight:bold;

        }

    </style>

</head>

<body>

<div class="card">

<h1 align="center">🚀 UOION Demo Application</h1>

<h3 align="center">
Application Successfully Deployed on Apache Tomcat
</h3>

<table>

<tr>
<td><b>Application Version</b></td>
<td class="value">${version}</td>
</tr>

<tr>
<td><b>Hostname</b></td>
<td class="value">${hostname}</td>
</tr>

<tr>
<td><b>Private IP</b></td>
<td class="value">${privateIp}</td>
</tr>

<tr>
<td><b>Instance ID</b></td>
<td class="value">${instanceId}</td>
</tr>

<tr>
<td><b>Availability Zone</b></td>
<td class="value">${availabilityZone}</td>
</tr>

<tr>
<td><b>Instance Type</b></td>
<td class="value">${instanceType}</td>
</tr>

<tr>
<td><b>AMI ID</b></td>
<td class="value">${amiId}</td>
</tr>

<tr>
<td><b>Current Time</b></td>
<td class="value">${time}</td>
</tr>

</table>

<br>

<h3 align="center" style="color:red;">
Refresh the page to observe traffic distributed across EC2 instances via the AWS Application Load Balancer.
</h3>

</div>

</body>

</html>
