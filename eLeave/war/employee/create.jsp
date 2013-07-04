<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Employee</title>
<%@include file="/shared/resources.html"%>
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
					<form class="new" action="/employee/insert" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>Employee ID:</td>
									<td><input name="employeeId" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Employee Name:</td>
									<td><input name="name" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Designation:</td>
									<td><input name="designation" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Date Joined:</td>
									<td><input id="joinDate" name="joinDate" type="text" />&nbsp;
										<img id="joinCal" src="/images/cal.png" height="18px;"></td>
								</tr>
								<tr class="overview-item">
									<td>Supervisor:</td>
									<td><input name="supervisor" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Email Address:</td>
									<td><input name="email" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>User Role:</td>
									<td><input name="userrole" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Username:</td>
									<td><input name="username" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Password:</td>
									<td><input name="password" type="password" /></td>
								</tr>
								<tr class="overview-item">
									<td>Reenter Password:</td>
									<td><input name="repassword" type="password" /></td>
								</tr>
								<tr class="overview-item">
									<td />
									<td><p>
											<input type="submit" value="Save" class="sbutton" /> &nbsp;
											<input type="reset" value="Reset" class="sbutton" />
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