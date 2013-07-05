<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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
					<form class="new" action="/leaveType/insert" method="post">
						<table class="overview-eleave-items">
							<tbody>
								<tr class="overview-item">
									<td>LeaveTypeId:</td>
									<td><input name="leaveTypeId" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Leave Type Name:</td>
									<td><input name="leaveTypeName" type="text" /></td>
								</tr>
								<tr class="overview-item">
									<td>Default Entitlement</td>
									<td><input name="defaultEntitlement" type="text" /></td>
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
		$("#leaveTypes").addClass("selected");
	});
	</script>
</body>
</html>