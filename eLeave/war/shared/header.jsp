<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="header">
	<div class="titles">
		<div id="title">eLeave Management System</div>
	</div>
	<div class="userinfo">
		<div class="avatar">
			<img src="/images/eleaveicon.png">
		</div>
		<div class="username">Welcome, ${empty sessionScope.myName ? "Administrator":sessionScope.myName}!</div>
		<div class="actions">
			<a href="" id="settings-action">Settings</a> | <a href="/logout" id="signout-action">Sign out</a>
		</div>
	</div>
	<form action="logout" method="POST" id="logoff-form"></form>
</div>