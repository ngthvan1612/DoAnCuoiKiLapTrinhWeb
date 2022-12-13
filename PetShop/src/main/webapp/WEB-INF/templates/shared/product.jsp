<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Sản phẩm"/>
  </c:import>
</head>

<body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
    
    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="container">
            <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                <h6 class="text-primary text-uppercase">Sản phẩm</h6>
                <h1 class="display-7 text-uppercase mb-0">Chuồng cho chó</h1>
            </div>
            <div class="row">
              <c:forEach items='${listProducts}' var='product'>
              <div class="col-3">
		            <div class="pb-5">
		                <div class="product-item bg-light text-center">
		                    <img class="img-fluid mb-4" src="/PetShop/static/img/product-1.png" alt="">
		                    <h6 class="text-uppercase">${product.getProductName()}</h6>
		                    <h5 class="text-primary mb-0 vnd">${product.getPrice()}</h5>
    						<c:import url="/WEB-INF/templates/shared/components/productmodal.jsp"/>
		                </div>
		            </div>
	            </div>
              </c:forEach>
            </div>
          </div>
        </div>
  <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
  <script>
  const vndFormat = (x) => x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
  const vnds = document.getElementsByClassName('vnd');
  for (const vnd of vnds) {
	  vnd.textContent = vndFormat(parseInt(vnd.textContent));
  }
  </script>
</body>
</html>