<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Leave Application</title>
<%@include file="/shared/resources.html"%>
<script type="text/javascript">
$(function() {
	$("#menu").tabs();
	
	$("#leaveForm").click(function() {
		window.location = "/leaveApplication/create.jsp";			
	});
	
	$("#leaveHistory").click(function() {
		window.location = "/shared/template.jsp";			
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
			<td><br />
				<div id="menu" style="padding: 0px; width: 960px;">
					<ul
						style="border: 0px; border-bottom-left-radius: 0px; border-bottom-right-radius: 0px;">
						<li><a href="#tabs-1">My Leave</a></li>
						<li><a href="#tabs-2">Calendar</a></li>
						<li><a href="#tabs-3">Approving Officer</a></li>
					</ul>
					<div id="tabs-1" style="padding: 0px;">
						<ul class="action-menu">
							<li><span class="action" id="leaveForm">eLeave Form</span></li>
							<li><span class="action" id="leaveHistory">Leave History</span></li>
							<li><span class="action" id="leaveSummary">Leave Summary</span></li>
						</ul>
					</div>
					<div id="tabs-2" style="padding: 0px;">
						<ul class="action-menu">
							<li><span class="action">Calendar</span></li>
						</ul>
					</div>
					<div id="tabs-3" style="padding: 0px;">
						<ul class="action-menu">
							<li><span class="action">Pending Applications</span></li>
							<li><span class="action">Subordinates</span></li>
							<li><span class="action">Subordinate Leave History</span></li>
						</ul>

					</div>
				</div></td>
		</tr>
		<tr>
			<td>
			<div style="padding: 5px; width: 960px;">
				<h2 style="font-size: 20pt;">Under Construction!</h2>
			</div>
			
				<%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
</body>
</html>