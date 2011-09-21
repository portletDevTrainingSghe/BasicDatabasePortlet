<%@page language="java"%>
<%@page import="java.util.List, javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants,com.liferay.portal.kernel.util.HtmlUtil,com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.sungardhe.demo.portlets.bookportlet.model.BookItem, com.sungardhe.demo.portlets.bookportlet.model.BookItemDAO, com.sungardhe.demo.portlets.bookportlet.util.ConnectionPool" %>


<portlet:defineObjects/>

<table border="1" cellpadding="4" cellspacing="0" width="100%">
	<tr>
		<td><b>Book ID</b></td>
		<td><b>Title</b></td>
		<td><b>Price</b></td>
	</tr>

	<%
	List bookItems = BookItemDAO.getBookItems();
	for (int i=0; i<bookItems.size(); i++) {
		BookItem bookItem = (BookItem)bookItems.get(i);
	%>

	<tr>
		<td><%= bookItem.getBookItemId() %></td>
		<td><%= bookItem.getTitle() %></td>
		<td>$<%= bookItem.getPrice() %></td>
	</tr>

	<% } %>

</table>