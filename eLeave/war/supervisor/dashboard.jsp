<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approving Officer</title>
<%@include file="/shared/resources.html"%>
<style type="text/css">
#chart1 svg {
  height: 450px;
  margin: 10px;
  min-width: 100px;
  min-height: 100px;
/*
  Minimum height and width is a good idea to prevent negative SVG dimensions...
  For example width should be =< margin.left + margin.right + 1,
  of course 1 pixel for the entire chart would not be very useful, BUT should not have errors
*/
}
</style>
<script type="text/javascript" src="../scripts/d3.v2.js"></script>
<script type="text/javascript" src="../scripts/nv.d3.js"></script>
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
								<td>
									<div id="chart1" style="width: 900px; height: 380px;">
										<svg></svg>
									</div>
								</td>
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
		var testdata = [
				{
					"key" : "Quantity",
					"bar" : true,
					"values" : [ [ 1136005200000, 1271000.0 ],
							[ 1138683600000, 1271000.0 ],
							[ 1141102800000, 1271000.0 ], [ 1143781200000, 0 ],
							[ 1146369600000, 0 ], [ 1149048000000, 0 ],
							[ 1151640000000, 0 ], [ 1154318400000, 0 ],
							[ 1156996800000, 0 ], [ 1159588800000, 3899486.0 ],
							[ 1162270800000, 3899486.0 ],
							[ 1164862800000, 3899486.0 ],
							[ 1167541200000, 3564700.0 ],
							[ 1170219600000, 3564700.0 ],
							[ 1172638800000, 3564700.0 ],
							[ 1175313600000, 2648493.0 ],
							[ 1177905600000, 2648493.0 ],
							[ 1180584000000, 2648493.0 ],
							[ 1183176000000, 2522993.0 ],
							[ 1185854400000, 2522993.0 ],
							[ 1272600000000, 1543784.0 ],
							[ 1275278400000, 1543784.0 ],
							[ 1277870400000, 1309915.0 ],
							[ 1280548800000, 1309915.0 ],
							[ 1283227200000, 1309915.0 ],
							[ 1285819200000, 1331875.0 ],
							[ 1288497600000, 1331875.0 ],
							[ 1291093200000, 1331875.0 ],
							[ 1293771600000, 1331875.0 ],
							[ 1296450000000, 1154695.0 ],
							[ 1298869200000, 1154695.0 ],
							[ 1301544000000, 1194025.0 ],
							[ 1304136000000, 1194025.0 ],
							[ 1306814400000, 1194025.0 ],
							[ 1309406400000, 1194025.0 ],
							[ 1312084800000, 1194025.0 ],
							[ 1314763200000, 1244525.0 ],
							[ 1317355200000, 475000.0 ],
							[ 1320033600000, 475000.0 ],
							[ 1322629200000, 475000.0 ],
							[ 1325307600000, 690033.0 ],
							[ 1327986000000, 690033.0 ],
							[ 1330491600000, 690033.0 ],
							[ 1333166400000, 514733.0 ],
							[ 1335758400000, 514733.0 ] ]
				},
				{
					"key" : "Price",
					"values" : [ ]
				} ].map(function(series) {
			series.values = series.values.map(function(d) {
				return {
					x : d[0],
					y : d[1]
				}
			});
			return series;
		});

		var chart;

		nv.addGraph(function() {
			chart = nv.models.linePlusBarChart().margin({
				top : 30,
				right : 0,
				bottom : 100,
				left : 70
			}).x(function(d, i) {
				return i
			}).color(d3.scale.category10().range());

			chart.xAxis.tickFormat(function(d) {
				var dx = testdata[0].values[d] && testdata[0].values[d].x || 0;
				return dx ? d3.time.format('%x')(new Date(dx)) : '';
			});

			chart.y1Axis.tickFormat(d3.format(',f'));

			chart.y2Axis.tickFormat(function(d) {
				return '$' + d3.format(',.2f')(d)
			});

			chart.bars.forceY([ 0 ]);
			//chart.lines.forceY([0]);

			d3.select('#chart1 svg').datum(testdata).transition().duration(500)
					.call(chart);

			nv.utils.windowResize(chart.update);

			chart.dispatch.on('stateChange', function(e) {
				nv.log('New State:', JSON.stringify(e));
			});

			return chart;
		});
		$(function() {
			var index = $('#menu a[href="#tabs-4"]').parent().index();
			$("#menu").tabs("option", "active", index);
			$("#dashboard").addClass("selected");
		});
	</script>
</body>
</html>