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
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <title>Document</title>
  </head>
  <body>
    <div class="petshop-cart">
      <div class="wrap cf">
        <div class="heading cf">
          <h1>ThÃ´ng tin mua hÃ ng</h1>

          <a href="#" class="continue">Quay láº¡i giá» hÃ ng</a>
        </div>
        <div class="cart">
          <!--    <ul class="tableHead">
              <li class="prodHeader">Product</li>
              <li>Quantity</li>
              <li>Total</li>
               <li>Remove</li>
            </ul>-->

          <div class="container">
            <div class="row">
              <!-- column 1-->
              <div class="col">
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="HoVaTen"
                  />
                  <label for="floatingInput">Há» vÃ  tÃªn</label>
                </div>
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" placeholder="SDT" />
                  <label for="floatingPassword">Sá» Äiá»n thoáº¡i</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    type="email"
                    class="form-control"
                    placeholder="name@example.com"
                  />
                  <label for="floatingPassword">Email</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="DiaChi"
                  />
                  <label for="floatingPassword">Äá»a chá»</label>
                </div>
                <div class="form-floating mb-3">
                  <select
                    class="form-select"
                    id="floatingSelect"
                    aria-label="Floating label select example"
                  >
                    <option selected>---</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                  <label for="floatingSelect">Tá»nh thÃ nh</label>
                </div>
                <div class="form-floating mb-3">
                  <select
                    class="form-select"
                    id="floatingSelect"
                    aria-label="Floating label select example"
                  >
                    <option selected>---</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                  <label for="floatingSelect">Quáº­n huyá»n</label>
                </div>
                <div class="form-floating mb-3">
                  <select
                    class="form-select"
                    id="floatingSelect"
                    aria-label="Floating label select example"
                  >
                    <option selected>---</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                  <label for="floatingSelect">PhÆ°á»ng xÃ£</label>
                </div>
                <div class="form-floating mb-3">
                  <textarea
                    class="form-control"
                    id="floatingTextarea"
                  ></textarea>
                  <label for="floatingTextarea">Ghi chÃº (tÃ¹y chá»n)</label>
                </div>
              </div>
              <div class="col">
                <h2>PhÆ°Æ¡ng thá»©c thanh toÃ¡n</h2>
                <div class="card" style="width: 18rem">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div class="form-check">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="flexRadioDefault"
                          id="flexRadioDefault1"
                        />
                        <label class="form-check-label" for="flexRadioDefault1">
                            Chuyá»n khoáº£n qua ngÃ¢n hÃ ng
                        </label>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <div class="form-check">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="flexRadioDefault"
                          id="flexRadioDefault1"
                        />
                        <label class="form-check-label" for="flexRadioDefault1">
                          Chuyá»n khoáº£n qua momo
                        </label>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <div class="form-check">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="flexRadioDefault"
                          id="flexRadioDefault1"
                        />
                        <label class="form-check-label" for="flexRadioDefault1">
                          Thanh toÃ¡n khi giao hÃ ng (COD)
                        </label>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col">
                <!-- column 2-->
                
                <ul class="cartWrap">
                    <h2>ÄÆ¡n hÃ ng</h2>
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
                          <input type="text" class="qty" placeholder="3" /> x
                          $5.00
                        </p>

                      </div>

                      <div class="prodTotal cartSection">
                        <p>$15.00</p>
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
                          <input type="text" class="qty" placeholder="3" /> x
                          $5.00
                        </p>

                      </div>

                      <div class="prodTotal cartSection">
                        <p>$15.00</p>
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
                          <input type="text" class="qty" placeholder="3" /> x
                          $5.00
                        </p>

                      </div>

                      <div class="prodTotal cartSection">
                        <p>$15.00</p>
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
                          <input type="text" class="qty" placeholder="3" /> x
                          $5.00
                        </p>

                        
                      </div>

                      <div class="prodTotal cartSection">
                        <p>$15.00</p>
                      </div>

                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div class="subtotal cf">
          <ul>
            <li class="totalRow">
              <span class="label">Táº¡m tÃ­nh</span
              ><span class="value">$35.00</span>
            </li>

            <li class="totalRow">
              <span class="label">PhÃ­ váº­n chuyá»n</span
              ><span class="value">$5.00</span>
            </li>

            <li class="totalRow final">
              <span class="label">Tá»ng cá»ng</span><span class="value">$44.00</span>
            </li>
            <li class="totalRow">
              <a href="#" class="btn continue">Äáº·t hÃ ng</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
