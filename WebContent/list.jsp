<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>编号</td>
			<td>用户名</td>
			<td>生日</td>
		</tr>
		<s:iterator value="#request.list" var="user" status="ss">
			<td>编号<s:property value="#ss.count"/></td>
			<td>用户名<s:property value="#user.name"/></td>
			<td>生日<s:property value="#user.birth"/></td>
		</s:iterator>
	</table>
	</body>
</body>
</html>