<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">Websitename</a>


</div>
<ul class="nav navbar-nav">
<li class="active"><a href="Welcome">home</a></li> 
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">page 1 <span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="#">page1-1</a></li>
<li><a href="#">page1-2</a></li>
<li><a href="#">page1-3</a></li>
</ul>     
</li>

<!-- <li><a href="#">page 1</a></li> -->
<li><a href="#">page 2</a></li>
<li><a href="#">page 3</a></li>

</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="registration"><span class="glyphicon glyphicon-user"></span>SIGNUP</a>
<li><a href="login"><span class="glyphicon glyphicon-login"></span>LOGIN</a>

</ul>
<form class="navbar-form navbar-right">
<div class="input-group">
<input type="text" class="form-control" placeholder="search">
<div class="input-group-btn">
<button class="btn btn-info" type="submit">
<i class="glyphicon glyphicon-search"></i>

</button>

</div>


</div>
</form>

</div>


</nav>
</body>
