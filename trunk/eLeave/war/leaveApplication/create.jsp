<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Leave Application</title>
<%@include file="/shared/resources.html" %>
<script type="text/javascript">
    $(function () {
        var dateformat = "d M, yy";
        var fromDate, toDate;
        var oneDay = 24 * 3600 * 1000;
        $("#fromDate").datepicker({
            defaultDate: 1,
            minDate: 1,
            numberOfMonths: 2,
            dateFormat: dateformat,
            onClose: function (selectedDate) {
                if (selectedDate) {
                	fromDate = $.datepicker.parseDate(dateformat, selectedDate);
                	console.info(fromDate);
                    $("#toDate").datepicker("option", "minDate", new Date(indate.getTime()));
                }
            }
        });
        $("#toDate").datepicker({
            numberOfMonths: 1,
            dateFormat: dateformat,
            onClose: function (selectedDate) {
                toDate = $.datepicker.parseDate(dateformat, selectedDate);
            }
        });
        $('#calFrom').click(function () {
            $('#').datepicker('show');
        });
        $('#calTo').click(function () {
            $('#').datepicker('show');
        });
    });
</script>
<style type="text/css">
div.ui-datepicker, .ui-datepicker td
{
    font-size: 10px;
}
</style>
</head>
<body>

<table align="center" style="width: 940px;">
	<tr>
		<td colspan="2"><%@include file="/shared/header.html" %></td>
	</tr>
	<tr>
	<td></td>
	<td align="center">
		<div style="text-align: right;">
			Welcome, ${employeeName}!
		</div>
		<form action="/shared/test.html" method="post">
			<table>
				<tr>
					<td>Leave Type:</td>
					<td>
						<select>
							<option>Annual</option>
							<option>Medical</option>
							<option>No-pay</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>From:</td>
					<td><input id="fromDate" name="fromDate" type="text" /></td>
				</tr>
				<tr>
					<td>To:</td>
					<td><input id="toDate" name="toDate" type="text" /></td>
				</tr>
				<tr>
					<td>Approving Officer:</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Reason:</td>
					<td><textarea rows="3" cols="30"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit Application" /></td>
				</tr>
			</table>
		</form>
	</td>
	</tr>
	<tr></tr>
</table>
</body>
</html>