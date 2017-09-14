<%@include file="Header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="Login" method="post" role="form">
<div class="form-group">
<label for="txtmail"> Enter mail id </label>

<input type="email" name="txtmail"required class="form-control"><br>

<label for="txtpass"> </label>enter password<input type="password"name="txtpass"required class="form-control"><br>

<!-- <input type="submit" value="Register">
<input type="reset" value="danger">
 -->
  <button type="submit" class="btn btn-success">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <button type="button" class="btn btn-danger">Cancel</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
</div>





</form>
</div>

</div>

</body>
</html>