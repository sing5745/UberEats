
<%@taglib uri="WEB-INF/myTagLibrary.tld" prefix="ij" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ca.sheridancollege.beans.*"%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
  <h2>Order History</h2>
  

  <table class="w3-table-all">
    <tr>
      <th>Order no.</th>
      <th>Email</th>
      <th>Address</th>
      <th>Items</th>
      <th>Total</th>
      <th>Order Date</th>
      
    </tr>
    <c:forEach items='${Orders}' var="o">
                    <tr>
                        <td>${o.getOrderno()}</td>
                        <td>${o.getEmail()}</td>
                        <td>${o.getAddress()}</td>
                        <td>${o.getItems()}</td>
                        <td><ij:FormatMoney money='${o.getTotal()}'/></td>
                        <td>${o.getDate()}</td>
                    </tr>
                    </c:forEach>
    
                    
                   
  </table>
  <a href="session">Start again</a>
</div>

</body>
</html>
