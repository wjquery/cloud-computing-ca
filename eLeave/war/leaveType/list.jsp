<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Type List</title>
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
					<form action="/leaveType/create.jsp" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Leave Type Name</td>
									<td style="font-weight: bold;">Default Entitlement</td>
									<td style="font-weight: bold;">Action</td>
								</tr>
								<!--tr class="overview-item">
									<td>Annual</td>
									<td class="drill"><a href="/leaveType/edit.jsp?id=1">18</a></td>
									<td/>
								</tr>
								<tr class="overview-item">
									<td>Medical</td>
									<td class="drill"><a href="/leaveType/edit.jsp?id=2">14</a></td><td/>
								</tr>
								<tr class="overview-item">
									<td>No-pay</td>
									<td class="drill"><a href="/leaveType/edit.jsp?id=3">N.A.</a></td><td/>
								</tr-->
								<c:forEach var="ltype" items="${leaveTypes}">
									<tr class="overview-item">
										<td>${ltype.name}</td>
										<td><fmt:formatNumber type="number" maxFractionDigits="0" value="${ltype.defaultEntitlement}" /></td>
										<td class="drill">
											<a href="/leaveType/details.jsp?leaveTypeId=${ltype.leaveTypeId}">Details</a>&nbsp;
											<a href="/leaveType/edit.jsp?leaveTypeId=${ltype.leaveTypeId}">Edit</a>
										</td>
									</tr>
								</c:forEach>
								<tr class="overview-item">
									<td/><td/>
									<td>
										<input type="submit" value="Add Leave Type" class="sbutton" />
									</td>
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