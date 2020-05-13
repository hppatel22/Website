<!doctype html>
<html lang="en" dir="ltr">
<%@page import="com.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AdminDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- soccer/project/register.html  07 Jan 2020 03:42:43 GMT -->
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="icon" href="favicon.ico" type="image/x-icon"/>

<title>:: Soccer :: Register</title>

<!-- Bootstrap Core and vandor -->
<link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css" />

<!-- Core css -->
<link rel="stylesheet" href="assets/css/main.css"/>
<link rel="stylesheet" href="assets/css/theme1.css"/>


</head>
<body class="font-montserrat">
<form action="AdminList">
<div class="auth">
    <div class="auth_left">
        <div class="card">
            <div class="text-center mb-5">
                <a class="header-brand" href="index-2.jsp"><i class="fa fa-soccer-ball-o brand-logo"></i></a>
            </div>
            <div class="card-body">
                <div class="card-title">Create new account</div>
                <div class="form-group">
                    <label class="form-label">Name</label>
                    
                    <input type="text" class="form-control" placeholder="Enter name" name="txtname">
                    
                </div>
                <div class="form-group">
                    <label class="form-label">Email address</label>
                    <input type="email" class="form-control" placeholder="Enter email" name="txtemail">
                </div>
                <div class="form-group">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" placeholder="Password" name="txtpassword">
                </div>
                <div class="form-group">
                    <label class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" />
                    <span class="custom-control-label">Agree the <a href="#">terms and policy</a></span>
                    </label>
                </div>
                <div class="form-footer">
                    <button type="submit" class="btn btn-primary btn-block">Create new account</button>
                </div>
            </div>
            <div class="text-center text-muted">
                Already have account? <a href="login.jsp ">Sign in</a>
            </div>
        </div>
    </div>
    <div class="auth_right full_img"></div>
</div>

<script src="assets/bundles/lib.vendor.bundle.js"></script>
<script src="assets/js/core.js"></script>
</form>
</body>

<!-- soccer/project/register.html  07 Jan 2020 03:42:43 GMT -->
</html>