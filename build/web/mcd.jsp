<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}

a{text-decoration: none;}
a:hover{
    color:orange;
    
}


</style>
<body class="w3-light-grey w3-content" style="max-width:1600px">



<!-- !PAGE CONTENT! -->
<div class="w3-main">
 <header align="right">
    <div class="w3-container">
        <h1><b></b> <a style="hover: red;" href="login.html"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span class="w3-badge w3-red">${items} </span></a></h1> 
                   
       
    </div>
</header>
  
  <!-- First Photo Grid-->
 
  
      
      <div class="w3-third w3-container" style="cursor: pointer; height:40px;">
          
          <div class="w3-container w3-white" >
              <img src="images/mcd.jpg" width="300px">
              <p><b>Double Big Mac Meal</b></p>
              <p>Comes with medium fries or side salad and medium fountain drink</p>
              <p>$10.99</p>
              <form action="addMcd">
                  <p><input  type="number" name="BigMacMeal" min="1" max="5"> <button class="w3-button w3-black w3-round-xxlarge">Add</button>
              </form>     
          </div>
         
          
      </div>
     
     
      <div class="w3-third w3-container" style="cursor: pointer; height:40px;">

         <div class="w3-container w3-white" >
              <img src="images/mcd2.jpg" width="300px">
              <p><b>Nugget Meal</b></p>
              <p>Comes with medium fries, medium fountain drink and nuggets</p>
              <p>$8.99</p>
              <form action="addMcd">
               <p><input type="number" name="NuggetMeal" min="1" max="5"> <button class="w3-button w3-black w3-round-xxlarge">Add</button>
              </form> 
          </div>
           
      </div>
     
     
      <div class="w3-third w3-container" style="cursor: pointer; height:40px;">

          <div class="w3-container w3-white" >
              <img src="images/mcd3.jpg" width="300px">
              <p><b>Happy Meal</b></p>
              <p>Comes with a nuggets, fries, beverage, strawberry yogurt tube and book or toy.</p>
              <p>$4.99</p>             
              <form action="addMcd">
               <p><input  type="number" name="HappyMeal" min="1" max="5"> <button class="w3-button w3-black w3-round-xxlarge">Add</button>
              </form> 
          </div>
          <div>
            <c:forEach items='${BigMacList}' var="bm">
                    <h3>${bm.getQty()} ${bm.getName()}    </h3>
             </c:forEach>
             <c:forEach items='${NuggetList}' var="nm">
                    <h3>${nm.getQty()} ${nm.getName()}</h3>
             </c:forEach>
             <c:forEach items='${HappyMealList}' var="hm">
                    <h3>${hm.getQty()} ${hm.getName()}</h3>
             </c:forEach>       

         </div>
          
      </div>
      
   

 
  

<!-- End page content -->
</div>
        
        

  

<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 

</script>

</body>
</html>
