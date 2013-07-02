<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Leave</title>
<%@include file="/shared/resources.html"%>
<style type="text/css">
a:link    { color: #000000; text-decoration: underline }
a:visited { color: #000000; text-decoration: none }
a:active  { color: #ff0000; text-decoration: none }
a:hover   { color: #ff0000; text-decoration: underline }
</style>
</head>
<body>
	<table align="center" style="width: 100%;">
		<tr>
			<td><%@include file="/shared/header.jsp"%></td>
		</tr>
		<tr>
			<td>
				<div style="margin: 2px; padding: 5px; width: 960px;">
					<%@include file="/shared/menu.jsp"%>
					<form action="/shared/template.jsp" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Leave Type</td>
									<td style="font-weight: bold;">Entitlement</td>
									<td style="font-weight: bold;">Balance</td>
									<td style="font-weight: bold;">Used</td>
								</tr>
								<tr class="overview-item">
									<td>Annual</td>
									<td>18</td>
									<td>15</td>
									<td>3</td>
								</tr>
								<tr class="overview-item">
									<td>Medical</td>
									<td>14</td>
									<td>13</td>
									<td>1</td>
								</tr>
								<tr class="overview-item">
									<td>No-pay</td>
									<td>N.A.</td>
									<td>N.A.</td>
									<td>2</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>


			</td>
		</tr>
		<tr>
			<td><%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
</body>
</html>