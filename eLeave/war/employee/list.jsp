<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<%@include file="/shared/resources.html"%>
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
					<form action="/employee/create.jsp" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Employee Name</td>
									<td style="font-weight: bold;">Designation</td>
									<td style="font-weight: bold;">Date Joined</td>
									<td style="font-weight: bold;">Action</td>
								</tr>
								<tr class="overview-item">
									<td>Tan Ah Kow</td>
									<td>Software Engineer</td>
									<td>01/01/2013</td>
									<td class="drill">
										<a href="/employee/details.jsp?id=1">Details</a>&nbsp;
										<a href="/employee/edit.jsp?id=1">Edit</a>
									</td>
								</tr>
								<tr class="overview-item">
									<td/><td/><td/>
									<td>
										<input type="submit" value="New Employee" class="sbutton" />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
						username: ${employees[0].username}<br>
						name: ${employees[0].name}<br>
						designation: ${employees[0].designation}
				</div>
			</td>
		</tr>
		<tr>
			<td><%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
	<script type="text/javascript">
	$(function() {
		var index = $('#menu a[href="#tabs-5"]').parent().index();
		$("#menu").tabs("option", "active", index);
		$("#employees").addClass("selected");
	});
	</script>
</body>
</html>