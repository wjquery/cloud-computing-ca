<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approving Officer</title>
<%@include file="/shared/resources.html"%>
<style type="text/css">
a:link {
	color: #000000;
	text-decoration: underline
}

a:visited {
	color: #000000;
	text-decoration: none
}

a:active {
	color: #ff0000;
	text-decoration: none
}

a:hover {
	color: #ff0000;
	text-decoration: underline
}
</style>
<script type="text/javascript" src="../scripts/d3.v3.js"></script>
<script type="text/javascript" src="../scripts/nv.d3.js"></script>
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
					<div id="chart">
						<svg></svg>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td><%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
</body>
</html>