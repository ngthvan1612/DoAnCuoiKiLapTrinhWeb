<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/PetShop/static/css/cart.css" rel="stylesheet" type="text/css">	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Document</title>
  </head>
  <body>
    <div class="petshop-cart">
      <div class="wrap cf">
        <h1 class="projTitle">
          PETSHOP ABCDEF
        </h1>
        <div class="heading cf">
          <h1>Giá» hÃ ng cá»§a tÃ´i</h1>
          <a href="#" class="continue">Tiáº¿p tá»¥c mua sáº¯m</a>
        </div>
        <div class="cart">
          <!--    <ul class="tableHead">
        <li class="prodHeader">Product</li>
        <li>Quantity</li>
        <li>Total</li>
         <li>Remove</li>
      </ul>-->
          <ul class="cartWrap">
            <li class="items odd">
              <div class="infoWrap">
                <div class="cartSection">
                  <img
                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
                    alt=""
                    class="itemImg"
                  />
                  <p class="itemNumber">#QUE-007544-002</p>
                  <h3>Item Name 1</h3>

                  <p>
                    <input type="text" class="qty" placeholder="3" /> x $5.00
                  </p>

                  <p class="stockStatus">In Stock</p>
                </div>

                <div class="prodTotal cartSection">
                  <p>$15.00</p>
                </div>
                <div class="cartSection removeWrap">
                  <a href="#" class="remove">x</a>
                </div>
              </div>
            </li>
            <li class="items even">
              <div class="infoWrap">
                <div class="cartSection">
                  <img
                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
                    alt=""
                    class="itemImg"
                  />
                  <p class="itemNumber">#QUE-007544-002</p>
                  <h3>Item Name 1</h3>

                  <p>
                    <input type="text" class="qty" placeholder="3" /> x $5.00
                  </p>

                  <p class="stockStatus">In Stock</p>
                </div>

                <div class="prodTotal cartSection">
                  <p>$15.00</p>
                </div>
                <div class="cartSection removeWrap">
                  <a href="#" class="remove">x</a>
                </div>
              </div>
            </li>

            <li class="items odd">
              <div class="infoWrap">
                <div class="cartSection">
                  <img
                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
                    alt=""
                    class="itemImg"
                  />
                  <p class="itemNumber">#QUE-007544-002</p>
                  <h3>Item Name 1</h3>

                  <p>
                    <input type="text" class="qty" placeholder="3" /> x $5.00
                  </p>

                  <p class="stockStatus out">Out of Stock</p>
                </div>

                <div class="prodTotal cartSection">
                  <p>$15.00</p>
                </div>
                <div class="cartSection removeWrap">
                  <a href="#" class="remove">x</a>
                </div>
              </div>
            </li>
            <li class="items even">
              <div class="infoWrap">
                <div class="cartSection info">
                  <img
                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
                    alt=""
                    class="itemImg"
                  />
                  <p class="itemNumber">#QUE-007544-002</p>
                  <h3>Item Name 1</h3>

                  <p>
                    <input type="text" class="qty" placeholder="3" /> x $5.00
                  </p>

                  <p class="stockStatus">In Stock</p>
                </div>

                <div class="prodTotal cartSection">
                  <p>$15.00</p>
                </div>

                <div class="cartSection removeWrap">
                  <a href="#" class="remove">x</a>
                </div>
              </div>
              
            </li>
          </ul>
        </div>


        <div class="subtotal cf">
          <ul>
            
            <li class="totalRow final">
              <span class="label">Táº¡m tÃ­nh</span><span class="value">$35.00</span>
            </li>
            <li class="totalRow">
              <a href="#" class="btn continue">Tiáº¿p tá»¥c</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <script>
    $('a.remove').click(function(){
      event.preventDefault();
      $( this ).parent().parent().parent().hide( 400 );
    
    })
      $('a.btn.continue').click(function(){
        $('li.items').show(400);
    })
    </script>
  </body>
</html>
