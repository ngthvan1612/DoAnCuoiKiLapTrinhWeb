<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <c:import url="/WEB-INF/templates/admin/_layout/header.jsp">
    <c:param name="title" value="Quản lý danh sách động vật"/>
  </c:import>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <c:import url="/WEB-INF/templates/admin/_layout/sidebar.jsp"/>
        
        <c:import url="/WEB-INF/templates/admin/pages/animal-management/modal-create-animal.jsp">
          <c:param name="modalId" value="modalCreateAnimal" />
        </c:import>
        
        <c:import url="/WEB-INF/templates/admin/pages/animal-management/modal-update-animal.jsp">
          <c:param name="formName" value="formUpdateAnimal"/>
          <c:param name="modalId" value="modalUpdateAnimal"/>
        </c:import>
        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <c:import url="/WEB-INF/templates/admin/_layout/topbar.jsp"/>
                        
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Danh sách thú cưng đang kinh doanh</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="mb-4">
                              <div class="row">
                                <div class="col">
                                  <button
                                    class="btn btn-primary"
                                    data-toggle="modal" data-target="#modalCreateAnimal"
                                  >
                                    Thêm
                                  </button>
                                </div>
                              </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Tên</th>
                                            <th>Ngày tạo</th>
                                            <th>Cập nhật lần cuối</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Office</th>
                                            <th>Age</th>
                                            <th>Start date</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>Tiger Nixon</td>
                                            <td>System Architect</td>
                                            <td>Edinburgh</td>
                                            <td>61</td>
                                            <td>
                                              <button
                                                class="btn btn-link shadow-none btn-sm"
                                                onclick="onEditRowClick(1)"
                                            	  data-toggle="modal" data-target="#modalUpdateAnimal"
                                              >Sửa</button>
                                              <button class="btn btn-danger shadow-none btn-sm">Xóa</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Tiger Nixon</td>
                                            <td>System Architect</td>
                                            <td>Edinburgh</td>
                                            <td>61</td>
                                            <td>
                                              <button
                                                class="btn btn-link shadow-none btn-sm"
                                                onclick="onEditRowClick(2)"
                                                data-toggle="modal" data-target="#modalUpdateAnimal"
                                              >Sửa</button>
                                              <button class="btn btn-danger shadow-none btn-sm">Xóa</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ashton Cox</td>
                                            <td>Junior Technical Author</td>
                                            <td>San Francisco</td>
                                            <td>66</td>
                                            <td>2009/01/12</td>
                                        </tr>
                                        <tr>
                                            <td>Cedric Kelly</td>
                                            <td>Senior Javascript Developer</td>
                                            <td>Edinburgh</td>
                                            <td>22</td>
                                            <td>2012/03/29</td>
                                        </tr>
                                        <tr>
                                            <td>Airi Satou</td>
                                            <td>Accountant</td>
                                            <td>Tokyo</td>
                                            <td>33</td>
                                            <td>2008/11/28</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
    </div>
    <!-- End of Page Wrapper -->
    
    <c:import url="/WEB-INF/templates/admin/_layout/js-includes.jsp"/>

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    
    <script>
    function onEditRowClick(e) {
    	const form = document.forms["formUpdateAnimal"];
    	const animalName = form["animalName"];
    	animalName.value = "ahihi " + e;
    }
    </script>
</body>

</html>