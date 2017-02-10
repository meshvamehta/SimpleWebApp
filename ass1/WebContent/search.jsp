<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
    <title>Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Bibliographer</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#">Home</a></li>
		      <li><a href="#">Browse</a></li>
		      <li><a href="#">Shopping Cart</a></li> 
		    </ul>
		    <form class="form-inline pull-xs-right">
			    <input class="form-control" type="text" placeholder="Search">
			    <button class="btn btn-outline-success" type="submit">Submit</button>
			</form>
		  </div>
		</nav>
		
		<form action="searchServlet" method="get">
		    User Name: <input type="text" name="realname">
		    Password: <input type="password" name="mypassword">
		    <input type="submit" value="Identification">
		</form> 

		<form class="form-inline pull-xs-right" action="searchServlet" method="post">
		  Publication:
		  <br>
		  <input type="text" name="Publication">
		  <br>
		  Author:
		  <br>
		  <input type="text" name="Author">
		  <br>
		  Venue:
		  <br>
		  <input type="text" name="Venue">
		  <br><br>
		  <button class="btn btn-outline-success" type="submit">Search</button>
		</form>
</body>
</html>

<style>
body {
    text-align: left;
   	padding-top: 5px;
    padding-right: 10px;
    padding-bottom: 50px;
    padding-left: 10px;
    color: black;
    background-color: #E3E9F5;
}
</style>