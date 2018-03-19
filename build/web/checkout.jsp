<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="WEB-INF/myTagLibrary.tld" prefix="ij" %>
<!DOCTYPE html>
<html lang="en">
    <title>My Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <body>

        <div class="w3-container w3-grey" style="position:relative">

            <h1 class="w3-jumbo w3-text-black" style="text-shadow:1px 1px 0 #444">Confirm Order</h1>
        </div>

        <div class="w3-grey w3-animate-zoom" style="padding:20px 50px;background-image:url('');
             background-size:cover;">

            <div class="w3-section w3-row-padding">

                <div class="w3-twothird">
                    <div class="w3-card-4">

                        <div class="container">
                            <form action="confirmOrder">
                                <label><b>Delivery Address</b></label><br>
                                <input  style="font-family: FontAwesome; width: 55px;" type="text" placeholder="&#xf041; Number" name="street" required>
                                <input  style="font-family: FontAwesome;" type="text" placeholder="Street Name" name="add" required><br><br>
                                <label><b>City</b></label><br>
                                <select name="city" size="1">
                                    <option value="Mississauga">Mississauga</option>
                                    <option value="Brampton">Brampton</option>
                                </select>
                                <button class="w3-button w3-green w3-round-xxlarge">Confirm</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="w3-third w3-container w3-center">
                    <div class="w3-card-4">
                        <div class="w3-container">
                            
                           
                            
                            <table class="w3-table-all w3-card-4">
                                <tr>
                                    <td>
                                       
                                        <c:forEach items='${BigMacList}' var="bm">
                                            ${bm.getQty()} ${bm.getName()} &nbsp; &nbsp; ${bm.getQty() * 10.99} <br> 
                                           
                                            
                                        </c:forEach>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <c:set var="total" value="${0}"/>
                                     <c:forEach items='${NuggetList}' var="nm">
                                        ${nm.getQty()} ${nm.getName()} &nbsp; &nbsp; ${nm.getQty() * 8.99} <br>  
                                         
                                            
                                                <c:set var="total" value="${total + nm.getQty() * 8.99}" />
                                     </c:forEach>
                                         
                                    </td>     
                                </tr>
                                <tr>
                                    <td>
                                     <c:forEach items='${HappyMealList}' var="bm">
                                        ${bm.getQty()} ${bm.getName()} &nbsp; &nbsp; <ij:FormatMoney money='${bm.getQty() * 4.99}'/> <br>                  
                                     </c:forEach>
                                    </td>     
                                </tr>
                                
                            </table>
                            <div align="right">
                              
                                <p >Subtotal: <ij:FormatMoney money='${Subtotal + total}'/> </p>
                                <p >Delivery Fee: $3.00</p>
                                <p >Taxes: <ij:FormatMoney money='${(Subtotal + total) * 0.13}'/></p>
                                Total: &nbsp;<button class="w3-button w3-black w3-round-xlarge"><i class="fa fa-usd" aria-hidden="true"></i> <ij:FormatMoney money='${(Subtotal + total) * 1.13 + 3}'/>  </button>
                            </div>
                        </div>
                        <div class="w3-container w3-white">
                            <button class="w3-button w3-black w3-round-xlarge"><i class="fa fa-car" aria-hidden="true"></i> &nbsp; 20-30 min</button>
                            <br><br>
                            <form action="order_history.jsp">
                            <button class="w3-button w3-black w3-round-xlarge"> Order History</button>
                            </form>
                        </div>
                    </div>
                            <c:set var="totalValue" value="${(Subtotal + total) * 1.13 + 3}" scope="session" />
                            
                            <c:set var="Rtax" value="${(Subtotal + total) * 0.13}" scope="session" />
                            
                            
                </div>
            </div>







        </div>
        <img src="images/mcd_logo.png" alt="Avatar" class="avatar" height="420px" width="90%">


    </body>
</html>
