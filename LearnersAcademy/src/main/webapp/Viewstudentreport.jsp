<%@page language="java" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enrolled Student Details</h1>
<form method="post">

<table border="2">
<tr>
<td>FIRST NAME</td>
<td>LAST NAME</td>
<td>EMAIL ID</td>
<td>CITY</td>
</tr>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/newdbtrg";
String username="root";
String password="Rajakumar@2213";
String query="select * from student";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
   <tr>
    <td><%=rs.getString("fname") %></td>
    <td><%=rs.getString("lname") %></td>
    <td><%=rs.getString("email") %></td>
     <td><%=rs.getString("city") %></td>
</tr>
        <%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>
<br/>
<a href="student.html">Back</a>
</form>
</body>
</html>