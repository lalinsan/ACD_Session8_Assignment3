<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<h1 align="center">Welcome Back to Website </h1> <!-- Welcome Message -->
<h2 align="center">Session Information</h2>
		
		<!-- Session Tracking Information -->
		<table border="1" align="center">
		<tr>
		<th bgcolor="#ADA19B"> Session Info</th>
		<th bgcolor="#ADA19B"> value </th>
		</tr>
		
		<tr> 
			<td bgcolor="#DCDAD9">Session ID:</td>
			<td>${sessionScope.id}</td> <!-- Call session ID -->
		
		</tr>
		
		<tr>
		    <td align="left" bgcolor="#DCDAD9">User Name:</td>
			<td align="left">${sessionScope.userName}</td> <!-- Call User Name -->
		</tr>
		
		<tr>
		    <td align="left" bgcolor="#DCDAD9">Creation Time:</td>
			<td align="left">${sessionScope.createTime}</td> <!-- Call session Creation Time-->
		</tr>
		
		<tr>
		    <td align="left" bgcolor="#DCDAD9">Time of Last Accessed:</td>
			<td align="left">${sessionScope.lastAccessTime}</td> <!-- Call session Last Access -->
		</tr>
		
		<tr>
		    <td align="left" bgcolor="#DCDAD9">User ID:</td>
			<td align="left">${sessionScope.userID}</td> <!-- Call session User ID -->
		</tr>
		
		<tr>
		    <td align="left" bgcolor="#DCDAD9">Number of Visits:</td>
			<td align="left">${sessionScope.visitCountKey}</td> <!-- Call session Number of Visits -->
		</tr>
		</table>

	
</body>
</html>