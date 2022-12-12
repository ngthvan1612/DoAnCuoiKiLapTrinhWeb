<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link href="/PetShop/static/css/productmodal.css" rel="stylesheet" type="text/css">	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <div class="product-modal">
      <div id="modal-container">
        <div class="modal-background">
          <div class="modal">
            <div class="wrapper">
              <section class="columns">
                <div class="column">
                  <img
                    src="./phukienpet.vn-image-cache-data-chuongchothucung-chuongchocho-nemchochomeohinhvuong1-min-100x100.png"
                  />
                </div>

                <div class="column">
                  <h2>Chuồng cho mèo</h2>

                  <p>Gía: 140000</p>
                  <p>Mô tả:</p>
                  <div class="product-description">
                    This HTML scroll box has had color added. You can add color
                    to the background of your scroll box. You can also add color
                    to the scroll bars.This HTML scroll box has had color added.
                    You can add color to the background of your scroll box. You
                    can also add color to the scroll bars.This HTML scroll box
                    has had color added. You can add color to the background of
                    your scroll box. You can also add color to the scroll
                    bars.This HTML scroll box has had color added. You can add
                    color to the background of your scroll box. You can also add
                    color to the scroll bars.This HTML scroll box has had color
                    added. You can add color to the background of your scroll
                    box. You can also add color to the scroll bars.This HTML
                    scroll box has had color added. You can add color to the
                    background of your scroll box. You can also add color to the
                    scroll bars.
                  </div>
                  <p>Product Code: HEGYWT6D</p>

                  <a href="https://www.google.com/" class="btn continue">Thêm vào giỏ hàng</a>
                </div>
              </section>
            </div>
            <svg
              class="modal-svg"
              xmlns="http://www.w3.org/2000/svg"
              width="100%"
              height="100%"
              preserveAspectRatio="none"
            >
              <rect
                x="0"
                y="0"
                fill="none"
                width="1000px"
                height="500px"
                rx="3"
                ry="3"
              ></rect>
            </svg>
          </div>
        </div>
      </div>
      <div class="content">
        <div class="buttons">
          <div id="six" class="button">Xem sản phẩm</div>
        </div>
      </div>
    </div>
    <script>
      $(".button").click(function () {
        var buttonId = $(this).attr("id");
        $("#modal-container").removeAttr("class").addClass(buttonId);
        $("body").addClass("modal-active");
      });

      $("#modal-container").click(function () {
        $(this).addClass("out");
        $("body").removeClass("modal-active");
      });
    </script>

