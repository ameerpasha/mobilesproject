<%@include file="Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="mainpage" method="post" role="form">
<div class="form group">
<label for="txtname">enter user name</label> <input type="text" name="txtuser"required class="form-control">
<label for="txtemail">enter user email</label> <input type="text" name="txemail"required class="form-control">
<label for="txphone">enter user phonr number</label> <input type="text" name="txtphone"required class="form-control">
<label for="txtpass">enter user password</label> <input type="text" name="txtpass"required class="form-control">
<label for="txtfirstname">enter user firstname</label> <input type="text" name="txtfirstname"required class="form-control">
<label for="txtlastname">enter user lastname</label> <input type="text" name="txtlastname"required class="form-control">

<button type="button" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-danger">cancel</button>



</div>
</div>



</form>
</body>

</html>