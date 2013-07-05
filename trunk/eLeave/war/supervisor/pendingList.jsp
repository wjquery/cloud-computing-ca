<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approving Officer</title>
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
					<table class="overview-eleave-items">
						<tbody>
							<c:choose>
							    <c:when test="${empty pending}">
							    <tr class="overview-item"><td>
							        No Pending Application Found.
							    </td></tr>
							    </c:when>
							    <c:otherwise>
								<tr class="overview-item">
									<td>Employee Name</td>
									<td style="font-weight: bold;">Leave Type</td>
									<td style="font-weight: bold;">From Date</td>
									<td style="font-weight: bold;">To Date</td>
									<td style="font-weight: bold;">Leave Days</td>
									<td style="font-weight: bold;">Action</td>
								</tr>
								<c:forEach var="app" items="${pending}">
								<tr class="overview-item">
									<td>${app.applicantId}</td>
									<td>${app.leaveTypeId}</td>
									<td><fmt:formatDate value="${app.fromDate}" pattern="dd/MM/yyyy"/></td>
									<td><fmt:formatDate value="${app.toDate}" pattern="dd/MM/yyyy"/></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="0" value="${app.days}" /></td>
									<td class="drill">
										<a href="/supervisor/viewdetail.jsp?id=${app.applicationId}">Details</a>
									</td>
								</tr>
								</c:forEach>
							    </c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>


			</td>
		</tr>
		<tr>
			<td><%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
	<script type="text/javascript">
	$(function() {
		var index = $('#menu a[href="#tabs-4"]').parent().index();
		$("#menu").tabs("option", "active", index);
		$("#pendingApp").addClass("selected");
	});
	</script>
</body>
</html>