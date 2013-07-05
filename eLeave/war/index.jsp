<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>eLeave</title>
    <link rel="stylesheet" href="/styles/reset.css" type="text/css" />
    <link rel="stylesheet" href="/styles/logon.css" type="text/css" />
</head>

<body>
	<div id="header">
		<div class="titles">
			<div id="title" style="font-family: Georgia;">
				eLeave Management System
			</div>
		</div>
	</div>
	<div class="content">
		<div class="error">
			<br> <br>
		</div>
		<div id="main-form">
			<div class="logon-heading">Sign in</div>
			<form name="login_form" method="post" action="login">
				<table>
					<tr>
						<td class="logon-company" style="color: white">Company</td>
						<td>
							<div align="left">
								<input id="companyId" style="width: 250px;" type="text"
									name="companyId" size="32" maxlength="32" value="NTU" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="logon-username">Username</td>
						<td>
							<div align="left">
								<input id="username" style="width: 250px;" type="text"
									name="username" size="32" maxlength="32" value="bill" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="logon-password">Password</td>
						<td>
							<div align="left">
								<input id="password" style="width: 250px;" type="password"
									name="password" size="32" maxlength="32" value="password" />
							</div>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input id="logon"
							type="submit" class="button" value="Sign in" /></td>
					</tr>
					<tr><td/><td class="logon-reset" ><span id="logon-reset-message">Can't access your account?</span></td></tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="/shared/footer.html" %>
</body>
</html>