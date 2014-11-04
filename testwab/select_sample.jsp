<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hoge.ConnectionManager,java.sql.*" %>

<%
try{
Connection con = ConnectionManager.getConnection();
Statement smt = con.createStatement();
ResultSet rs = smt.executeQuery("select * from account");
while(rs.next()){
	String s = "NAME=" + rs.getString("NAME") + ",MONEY=" + rs.getString("MONEY")+ "<br>"  ;
	out.println(s);
}
smt.close();
con.close();
System.out.println("end");
} catch(SQLException e) {
	e.printStackTrace();
	//aaaaaatestaaaaaaaaa
}
 %>