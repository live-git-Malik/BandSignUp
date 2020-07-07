<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

	<%
		// create the connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alcorn_band", "root", "gu00re705A$");
			System.out.println("Connection Established!");
			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from students"); %>
	<div class="container" style="height: 500px; width: 500px">
		<table class="table table-dark">
			<thead class="thead-light">
				<tr>
					<th scope="col">Anumber ID</th>
					<th scope="col">Student Name</th>
					<th scope="col">BandFee</th>
				</tr>
			</thead>
			<% // Iterate the resultSet
			while (resultSet.next()) { %>
			<tr>
				<td><%= resultSet.getString("Anumber_ID") %></td>
				<td><%= resultSet.getString("Student_Name") %></td>
				<td><%= resultSet.getString("Band_Fee") %></td>
			</tr>
			<% } %>
		</table>
	</div>
	<% } catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}%>
	<%-- <table>
   <tr>
      <td>Anumber ID</td>
      <td>Student Name</td>
      <td>BandFee</td>
   </tr>
      <tr>
      <td><%out.println(1); %></td>
      <td><%out.println("James"); %></td>
      <td><%out.println("Bond"); %></td>
   </tr>
   
</table> --%>
</body>
</html>