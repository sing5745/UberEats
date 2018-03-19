<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="WEB-INF/myTagLibrary.tld" prefix="ij" %>
<html>
    <head>
        <style>
            #invoice-POS{
  box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);
  padding:2px;
  margin: 0 auto;
  width: 80mm;
  background: #FFF;
  
  
::selection {background: #f31544; color: #FFF;}
::moz-selection {background: #f31544; color: #FFF;}
h1{
  font-size: 1.5em;
  color: #222;
}
h2{font-size: .9em;}
h3{
  font-size: 1.2em;
  font-weight: 300;
  line-height: 2em;
}
p{
  font-size: .7em;
  color: #666;
  line-height: 1.2em;
}
 
#top, #mid,#bot{ /* Targets all id with 'col-' */
  border-bottom: 1px solid #EEE;
}

#top{min-height: 100px;}
#mid{min-height: 80px;} 
#bot{ min-height: 50px;}

#top .logo{
  
	height: 60px;
	width: 60px;
	background: url(http://michaeltruong.ca/images/logo1.png) no-repeat;
	background-size: 60px 60px;
}

.info{
  display: block;
 
  margin-left: 0;
}
.title{
  float: right;
}
.title p{text-align: right;} 
table{
  width: 100%;
  border-collapse: collapse;
}
td{
 
}
.tabletitle{
   margin: 2px;
  font-size: 2em;
  background: #EEE;
}
.service{border-bottom: 1px solid #EEE;}
.item{width: 50mm;}
.itemtext{font-size: .5em;}

#legalcopy{
  margin-top: 5mm;
}

  
  
}
        </style>
        
    </head>
    <body>
    <center>
        <div><h1>Thank You for ordering</h1></div>
    </center>
  <div id="invoice-POS">
    
    <center id="top">
      <div class="logo"></div>
      <div class="info"> 
        <h2>Uber Eats</h2>
      </div><!--End Info-->
    </center><!--End InvoiceTop-->
    
    <div id="mid">
      <div class="info">
        <h2>Contact Info</h2>
        <p> 
            Address : ${address}</br>
            Email   : ${email}</br>
            
        </p>
      </div>
    </div><!--End Invoice Mid-->
    
    <div id="bot">

					<div id="table">
						<table>
							<tr class="tabletitle">
								<td class="item"><h2>Item</h2></td>
								
								<td class="Rate"><h2>Sub Total</h2></td>
							</tr>

							<tr class="service">
								<td class="tableitem"><p class="itemtext">Big Mac Meal</p></td>
								
								<td class="tableitem"><p class="itemtext">${subBM}</p></td>
							</tr>

							<tr class="service">
								<td class="tableitem"><p class="itemtext">Nugget Meal</p></td>
								
								<td class="tableitem"><p class="itemtext">${subNM}</p></td>
							</tr>

							<tr class="service">
								<td class="tableitem"><p class="itemtext">Happy Meal</p></td>
								
								<td class="tableitem"><p class="itemtext">${subHM}</p></td>
							</tr>

							


							<tr class="tabletitle">
								<td></td>
								<td class="Rate"><h2>Tax</h2></td>
								<td class="payment"><h2><ij:FormatMoney money='${Rtax}'/></h2></td>
							</tr>

							<tr class="tabletitle">
								<td></td>
								<td class="Rate"><h2>Total</h2></td>
								<td class="payment"><h2><ij:FormatMoney money='${totalValue}'/></h2></td>
							</tr>

						</table>
					</div><!--End Table-->

					

				</div><!--End InvoiceBot-->
  </div><!--End Invoice-->
  <form action="order_history.jsp">
                            <button class="w3-button w3-black w3-round-xlarge"> Order History</button>
                            </form>
    </body>
</html>