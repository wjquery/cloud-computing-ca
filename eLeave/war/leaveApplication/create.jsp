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
		var dateformat = "dd/mm/yy";
		var fromDate, toDate;
		var oneDay = 24 * 3600 * 1000;
		$("#fromDate").datepicker(
				{
					defaultDate : 1,
					minDate : 1,
					numberOfMonths : 1,
					dateFormat : dateformat,
					onClose : function(selectedDate) {
						if (selectedDate) {
							fromDate = $.datepicker.parseDate(dateformat,
									selectedDate);
							$("#toDate").datepicker("option", "minDate",
									new Date(fromDate.getTime()));
						}
					}
				});
		$("#toDate").datepicker({
			dateFormat : dateformat,
			onClose : function(selectedDate) {
				toDate = $.datepicker.parseDate(dateformat, selectedDate);
			}
		});
		$('#calFrom').click(function() {
			$('#').datepicker('show');
		});
		$('#calTo').click(function() {
			$('#').datepicker('show');
		});

		$("#menu").tabs();
		
		$("#leaveForm").click(function() {
			window.location = "/leaveApplication/create.jsp";			
		});
		
		$("#leaveHistory").click(function() {
			window.location = "/shared/template.jsp";			
		});
		
		$("#leaveSummary").click(function() {
			window.location = "/shared/template.jsp";			
		});
		
		$("#pendingApp").click(function() {
			window.location = "/shared/template.jsp";			
		});
		
		$("#subordinates").click(function() {
			window.location = "/shared/template.jsp";			
		});
		
		$("#subHistory").click(function() {
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
							<li><span class="action" id="pendingApp">Pending Applications</span></li>
							<li><span class="action" id="subordinates">Subordinates</span></li>
							<li><span class="action" id="subHistory">Subordinate Leave History</span></li>
						</ul>
					</div>
				</div></td>
		</tr>
		<tr>
			<td>
				<form action="/shared/template.jsp" method="post">
					<table class="overview-eleave-items" style="width: 960px;">
						<tbody>
							<tr class="overview-item">
								<td>Leave Type:</td>
								<td><select>
										<option>Annual</option>
										<option>Medical</option>
										<option>No-pay</option>
								</select></td>
							</tr>
							<tr class="overview-item">
								<td>From:</td>
								<td><input id="fromDate" name="fromDate" type="text" /></td>
							</tr>
							<tr class="overview-item">
								<td>To:</td>
								<td><input id="toDate" name="toDate" type="text" /></td>
							</tr>
							<tr class="overview-item">
								<td>Leave Days:</td>
								<td><input name="leaveDays" type="text" /></td>
							</tr>
							<tr class="overview-item">
								<td>Approving Officer:</td>
								<td><input type="text" /></td>
							</tr>
							<tr class="overview-item">
								<td>Reason for Leave:</td>
								<td><textarea name="reason" rows="3" cols="30"></textarea></td>
							</tr>
							<tr class="overview-item">
								<td colspan="2"><p>
										<input type="submit" value="Submit" />
										&nbsp; <input type="reset" value="Reset" />
									</p></td>
							</tr>
						</tbody>
					</table>
				</form> 
				<%@include file="/shared/footer.html"%></td>
		</tr>
	</table>
</body>
</html>