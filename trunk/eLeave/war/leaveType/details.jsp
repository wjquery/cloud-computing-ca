<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="sg.edu.nus.iss.eleave.service.impl.*,sg.edu.nus.iss.eleave.dto.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Type Details</title>
<%@include file="/shared/resources.html"%>
<%
	LeaveType leaveType = new LeaveTypeServiceImpl().findLeaveTypeById(request.getParameter("leaveTypeId"));
	request.setAttribute("ltype", leaveType);
%>
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
					<form class="new" action="/leaveType/findAll" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>LeaveTypeId:</td>
									<td>${ltype.leaveTypeId}</td>
								</tr>
								<tr class="overview-item">
									<td>Leave Type Name:</td>
									<td>${ltype.name}</td>
								</tr>
								<tr class="overview-item">
									<td>Default Entitlement</td>
									<td><fmt:formatNumber type="number" maxFractionDigits="0" value="${ltype.defaultEntitlement}" /></td>
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
		$("#leaveTypes").addClass("selected");
	});
	</script>
</body>
</html>