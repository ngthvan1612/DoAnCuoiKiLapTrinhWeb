<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Navbar Start -->
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
    <a href="/PetShop/" class="navbar-brand ms-lg-5">
        <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>Pet Shop</h1>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse" style="padding-right:20px;">
        <div class="navbar-nav ms-auto py-0">
            <a href="/PetShop/" class="nav-item nav-link">Trang chủ</a>
            <div class="nav-item dropdown">
                <a href="/PetShop/san-pham?categoryName=Chó" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Chó</a>
                <div class="dropdown-menu m-0">
                    <a href="/PetShop/san-pham?categoryTitle=Chuồng cho chó" class="dropdown-item">Chuồng cho chó</a>
                    <a href="team.html" class="dropdown-item">The Team</a>
                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                    <a href="blog.html" class="dropdown-item">Blog Grid</a>
                    <a href="detail.html" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="/PetShop/san-pham?categoryName=Mèo" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Mèo</a>
                <div class="dropdown-menu m-0">
                    <a href="product.html" class="dropdown-item">Chuồng cho mèo</a>
                    <a href="team.html" class="dropdown-item">Thuốc cho mèo</a>
                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                    <a href="blog.html" class="dropdown-item">Blog Grid</a>
                    <a href="detail.html" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="/PetShop/san-pham?categoryName=Chim" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Chim</a>
                <div class="dropdown-menu m-0">
                    <a href="price.html" class="dropdown-item">Pricing Plan</a>
                    <a href="team.html" class="dropdown-item">The Team</a>
                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                    <a href="blog.html" class="dropdown-item">Blog Grid</a>
                    <a href="detail.html" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="/PetShop/san-pham?categoryName=Hamster" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Hamster</a>
                <div class="dropdown-menu m-0">
                    <a href="price.html" class="dropdown-item">Pricing Plan</a>
                    <a href="team.html" class="dropdown-item">The Team</a>
                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                    <a href="blog.html" class="dropdown-item">Blog Grid</a>
                    <a href="detail.html" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <a href="/PetShop/gio-hang" class="nav-item nav-link">Giỏ hàng</a>
            <a href="/PetShop/ve-chung-toi" class="nav-item nav-link">Liên hệ</a>
            <c:choose>
              <c:when test='${requestScope["isAuthenticated"] == true}'>
                <div class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Chào, ${requestScope["username"]}</a>
	                <div class="dropdown-menu m-0 dropdown-menu-end">
	                  <c:if test='${requestScope["isAdmin"]}'>
	                    <button class="dropdown-item">
	                     <a href="/PetShop/admin">Quản lý website</a>
	                    </button>
	                    <hr/>
	                  </c:if>
	                  <button class="dropdown-item">
	                    <a>Tài khoản</a>
	                  </button>
	                  <form action="/PetShop/logout" method="post">
	                   <button type="submit" class="btn-danger dropdown-item">Đăng xuất</button>
	                  </form>
	                </div>
                </div>
              </c:when>
              <c:otherwise>
                <a href="/PetShop/login" class="nav-item nav-link">Đăng nhập</a>
              </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<!-- Navbar End -->