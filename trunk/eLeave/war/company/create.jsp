<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up New Account</title>
<%@include file="/shared/resources.html"%>
<link rel="stylesheet" href="/styles/reset.css" type="text/css" />
<link rel="stylesheet" href="/styles/logon.css" type="text/css" />
</head>
<body>
	<div id="header">
		<div class="titles">
			<div id="title">eLeave Management System</div>
		</div>
	</div>
	<div class="content">
		<div class="error">
			<br> <br>
		</div>
		<div
			style="margin: 0 auto; height: 30px; padding: 10px; width: 420px; text-align: center; background: none repeat scroll 0 0 #005588; font-size: 150%; color: white;">Sign
			Up New Account</div>
		<div style="margin: 0 auto; padding: 0px 0; width: 440px;">
			<form method="post" action="/company/insert">
				<table class="overview-eleave-items">
					<tbody>
						<tr class="overview-item">
							<td>Company Name:</td>
							<td><input id="companyName" style="width: 200px;"
								type="text" name="companyName" size="32" maxlength="32" /></td>
						</tr>
						<tr class="overview-item">
							<td>Company Code:</td>
							<td><input id="companyCode" style="width: 200px;"
								type="text" name="companyCode" size="32" maxlength="32" /></td>
						</tr>
						<tr class="overview-item">
							<td>Subscription Type:</td>
							<td>
							<select name="subscriptionType">
								<option value="Free">Free</option>
								<option value="Premium">Premium</option>
								<option value="Platinum">Platinum</option>
							</select>
							</td>
						</tr>
						<tr class="overview-item">
							<td>Admin Username:</td>
							<td><input id="username" style="width: 200px;" type="text"
								name="username" size="32" maxlength="32" /></td>
						</tr>
						<tr class="overview-item">
							<td>Admin Password:</td>
							<td><input id="password" style="width: 200px;"
								type="password" name="password" size="32" maxlength="32" /></td>
						</tr>
						<tr class="overview-item">
							<td>Reenter Admin Password:</td>
							<td><input id="repassword" style="width: 200px;"
								type="password" name="repassword" size="32" maxlength="32" /></td>
						</tr>
						<tr class="overview-item">
							<td />
							<td><input type="submit" value="Sign up" class="sbutton" />
								<input class="sbutton" type="reset" value="Reset" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<%@include file="/shared/footer.html"%>
</body>
</html>