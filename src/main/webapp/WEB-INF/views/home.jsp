<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="resources/js/alljsfunction.js"></script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<table>
		<tr>
			<td>User Name:<input type="text" id="username" /></td>
			<td><input type="button" value="check name" onclick="checkit()"/></td>
			<td><div id="cctv"></div></td>
		</tr>
		<tr>
			<td>User password :<input type="password" id="password" /></td>
		</tr>
	</table>
	<input type="button" value="login" />
	
</body>
</html>
