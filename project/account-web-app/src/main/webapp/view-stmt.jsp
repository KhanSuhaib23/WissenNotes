<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.wissen.model.Transaction"%>
<html>
<head>
<meta charset="UTF-8">
<title>spring MVC</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
</head>
<body class="container">

	<hr />
	<h1>Account Service Web App</h1>
	<hr />
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" href="txn.htm">Transfer</a></li>
		<li class="nav-item"><a class="nav-link" href="stmt.htm">Statement</a></li>
	</ul>
	<hr />

	<form action="stmt.htm" method="post">
		<div class="form-group">
			<label>Account Number</label> <input name="accNum" class="form-control">
		</div>
		<button class="btn btn-danger">Get TXNs</button>
	</form>
	
	<br />

	<div class="card">
		<div class="card-header">All Transactions</div>
		<div class="card-body">
			<table class="table table-sm table-bordered">
				<tr>
					<th>TXN ID</th>
					<th>Account Number</th>
					<th>Amount</th>
					<th>Closing Balance</th>
					<th>Time Stamp</th>
					<th>TXN Type</th>
				</tr>
				<%
					List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
					for (Transaction txn : transactions) {
				%>
				<tr>
					<td><%=txn.getId()%></td>
					<td><%=txn.getAccNum().getAccountNum()%></td>
					<td><%=txn.getAmount()%></td>
					<td><%=txn.getClosingBalance()%></td>
					<td><%=txn.getDataTime()%></td>
					<td><%=txn.getType().name()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>

</body>
</html>