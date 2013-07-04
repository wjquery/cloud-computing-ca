<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
							<tr class="overview-item">
								<td>Employee Name</td>
								<td style="font-weight: bold;">Leave Type</td>
								<td style="font-weight: bold;">From Date</td>
								<td style="font-weight: bold;">To Date</td>
								<td style="font-weight: bold;">Leave Days</td>
								<td style="font-weight: bold;">Action</td>
							</tr>
							<tr class="overview-item">
								<td>Tan Ah Kow</td>
								<td>Annual</td>
								<td>15/07/2013</td>
								<td>17/07/2013</td>
								<td>3</td>
								<td class="drill"><a href="/supervisor/list.jsp?id=3">Details</a></td>
							</tr>
							<tr class="overview-item">
								<td>Lim Ah Thet</td>
								<td>Medical</td>
								<td>01/07/2013</td>
								<td>01/07/2013</td>
								<td>1</td>
								<td class="drill"><a href="/supervisor/list.jsp?id=2">Details</a></td>
							</tr>
							<tr class="overview-item">
								<td>Alvin Ng</td>
								<td>No-pay</td>
								<td>25/06/2013</td>
								<td>26/06/2013</td>
								<td>2</td>
								<td class="drill"><a href="/supervisor/list.jsp?id=1">Details</a></td>
							</tr>
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