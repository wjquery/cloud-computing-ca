<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="sg.edu.nus.iss.eleave.service.impl.*,sg.edu.nus.iss.eleave.dto.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<%@include file="/shared/resources.html"%>
<%
	Employee emp = new EmployeeServiceImpl().findEmployee(request.getParameter("employeeId"));
	request.setAttribute("emp", emp);
%>
<script type="text/javascript">
	$(function() {
		var dateformat = "dd/mm/yy";
		$("#joinDate").datepicker(
				{
					defaultDate : 1,
					minDate : 1,
					numberOfMonths : 1,
					dateFormat : dateformat
				});

		$('#joinCal').click(function() {
			$('#joinDate').datepicker('show');
		});
		
	});
</script>
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
					<form class="new" action="/employee/findAll" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Employee Name:</td>
									<td>${emp.name}</td>
								</tr>
								<tr class="overview-item">
									<td>Designation:</td>
									<td>${emp.designation}</td>
								</tr>
								<tr class="overview-item">
									<td>Date Joined:</td>
									<td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></td>
								</tr>
								<tr class="overview-item">
									<td>Department:</td>
									<td></td>
								</tr>
								<tr class="overview-item">
									<td>Supervisor:</td>
									<td></td>
								</tr>
								<tr class="overview-item">
									<td>Email Address:</td>
									<td>${emp.email}</td>
								</tr>
								<tr class="overview-item">
									<td>User Role:</td>
									<td>${emp.userrole}</td>
								</tr>
								<tr class="overview-item">
									<td>Username:</td>
									<td>${emp.username}</td>
								</tr>
								<tr class="overview-item">
									<td />
									<td><p>
											<input type="submit" value="Back" class="sbutton" /> &nbsp;
										</p></td>
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
	<script type="text/javascript">
	$(function() {
		var index = $('#menu a[href="#tabs-5"]').parent().index();
		$("#menu").tabs("option", "active", index);
		$("#employees").addClass("selected");
	});
	</script>
</body>
</html>