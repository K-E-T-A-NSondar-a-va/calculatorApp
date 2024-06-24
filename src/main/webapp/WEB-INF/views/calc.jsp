<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<form action="/calculate" method="post">
			<h2>
				Enter 1st operand: 
				<input type="text" name="operand1" />	
				
				<br>
				Enter 2nd operand: 
				<input type="text" name="operand2" />	
				
				<br>
				Enter math operator: 
				<input type="text" name="operator" />	
								
				<br>
				<button type="submit">submit</button>
			</h2>
		</form>
	</div>
</body>
</html>