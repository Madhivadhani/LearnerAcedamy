<%@page language="java" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Detailed Report</h1>
<form method="post">

<table border="2">
<tr>
<td>STUDENT NAME</td>
<td>CLASS</td>

<td>TEACHER</td>
<td>SUBJECT</td>
</tr>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/newdbtrg";
String username="root";
String password="Rajakumar@2213";
String query="select fname,classno,teacher,subject  from student";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
   <tr>
    <td><%=rs.getString("fname") %></td>
    <td><%=rs.getString("classno") %></td>
    <td><%=rs.getString("teacher") %></td>
     <td><%=rs.getString("subject") %></td>
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