<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="sg.edu.nus.iss.eleave.service.impl.*,sg.edu.nus.iss.eleave.dto.*,java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Leave Application</title>
<%@include file="/shared/resources.html"%>
<%
	List<LeaveType> leaveTypes = new LeaveTypeServiceImpl().findAllLeaveTypesByCompany("NTU");
	request.setAttribute("leaveTypes", leaveTypes);
%>
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
		$('#fromCal').click(function() {
			$('#fromDate').datepicker('show');
		});
		$('#toCal').click(function() {
			$('#toDate').datepicker('show');
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
					<form class="new" action="/leaveApplication/insert" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Leave Type:</td>
									<td><select name="leaveTypeId">
										<c:forEach var="type" items="${leaveTypes}">
											<option value="${type.leaveTypeId}">${type.name}</option>
										</c:forEach>
									</select></td>
								</tr>
								<tr class="overview-item">
									<td>From:</td>
									<td><input id="fromDate" name="fromDate" type="text" />&nbsp;
										<img id="fromCal" src="/images/cal.png" height="18px;"></td>
								</tr>
								<tr class="overview-item">
									<td>To:</td>
									<td><input id="toDate" name="toDate" type="text" />&nbsp;
										<img id="toCal" src="/images/cal.png" height="18px;"></td>
								</tr>
								<tr class="overview-item">
									<td>Leave Days:</td>
									<td><input name="days" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Approving Officer:</td>
									<td><input type="text" readonly="readonly" /></td>
								</tr>
								<tr class="overview-item">
									<td>Reason for Leave:</td>
									<td><textarea name="reason" rows="3" cols="30"></textarea></td>
								</tr>
								<tr class="overview-item">
									<td />
									<td><p>
											<input type="submit" value="Submit" class="sbutton" />
											&nbsp; <input type="reset" value="Reset" class="sbutton" />
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
		var index = $('#menu a[href="#tabs-1"]').parent().index();
		$("#menu").tabs("option", "active", index);
		$("#leaveForm").addClass("selected");
	});
	</script>
</body>
</html>