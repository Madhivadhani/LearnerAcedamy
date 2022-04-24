<%@page language="java" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Teacher List</h1>
<form method="post">

<table border="2">
<tr>
<td>TEACHER NAME</td>
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
String query="select * from teacher";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
   <tr>
    <td><%=rs.getString("name") %></td>
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
<a href="home.html">Back</a>
</form>
</body>
</html>