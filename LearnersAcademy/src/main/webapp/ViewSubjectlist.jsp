<%@page language="java" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Subject Details</h1>
<form method="post">

<table border="2">
<tr>
<td>SUBJECT NAME</td>

</tr>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/newdbtrg";
String username="root";
String password="Rajakumar@2213";
String query="select subjectname from subject";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
   <tr>
    <td><%=rs.getString("subjectname") %></td>
    
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
<a href="subject.html">Back</a>
</form>
</body>
</html>