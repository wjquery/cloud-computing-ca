<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
$(function() {
	$("#menu").tabs();
	
	//TODO refactor
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
	
	$("#employees").click(function() {
		window.location = "/shared/template.jsp";			
	});
	
	$("#leaveTypes").click(function() {
		window.location = "/shared/template.jsp";			
	});
	
	$("#holidays").click(function() {
		window.location = "/shared/template.jsp";			
	});
});
</script>
<div id="menu" style="padding: 0px; width: 960px;">
	<ul
		style="border: 0px; border-bottom-left-radius: 0px; border-bottom-right-radius: 0px;">
		<li><a href="#tabs-1">My Leave</a></li>
		<li><a href="#tabs-2">Calendar</a></li>
		<li><a href="#tabs-3">Approving Officer</a></li>
		<li><a href="#tabs-4">Admin</a></li>
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
			<li><span class="action" id="pendingApp">Pending
					Applications</span></li>
			<li><span class="action" id="subordinates">Subordinates</span></li>
			<li><span class="action" id="subHistory">Subordinate
					Leave History</span></li>
		</ul>
	</div>
		<div id="tabs-4" style="padding: 0px;">
		<ul class="action-menu">
			<li><span class="action" id="employees">Employees</span></li>
			<li><span class="action" id="leaveTypes">Leave Types</span></li>
			<li><span class="action" id="holidays">Public Holidays</span></li>
		</ul>
	</div>
</div>