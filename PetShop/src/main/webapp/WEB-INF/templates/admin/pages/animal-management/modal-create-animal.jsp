<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form class="modal-content" method="POST" action="/PetShop/admin/animal-management/create"
              name="createAnimalForm"
              onsubmit="return validateCreateAnimal()"
            >
                <div class="modal-header">
                    <h5 class="modal-title">Thêm thú cưng mới</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        X
                    </button>
                </div>
                <div class="modal-body">
									<div class="input-group">
									  <span class="input-group-text">Tên động vật</span>
									  <input type="text" class="form-control" placeholder="Tên" aria-label="Username" aria-describedby="basic-addon1" name="animalName">
									</div>
                </div>
                <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
					        <button type="submit" class="btn btn-primary">Thêm</button>
					      </div>
            </form>
        </div>
    </div>
    
    <script>
    function validateCreateAnimal() {
    	const form = document.forms["createAnimalForm"];
    	const animalName = form["animalName"].value;
    	if (animalName == null || animalName == '') {
    		alert('Vui lòng nhập tên');
    		return false;
    	}
    	return true;
    }
    </script>