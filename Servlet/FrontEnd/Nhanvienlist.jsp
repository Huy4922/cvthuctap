<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Liquor Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>

  	<div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
							
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="social-media mr-4">
			    		<p class="mb-0 d-flex">
			    			
			    		</p>
		        </div>
		        

					</div>
				</div>
			</div>
		</div>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Quản <span>Lý</span></a>
	      

	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        
	          <li class="nav-item active"><a href="index.jsp" class="nav-link">Trang chủ</a></li>
	          <li class="nav-item"><a href="NhanVienListServlet" class="nav-link">Nhân viên</a></li>
	          <li class="nav-item"><a href="ProductListServlet" class="nav-link">Danh sách sản phẩm</a></li>
	          
	          <li class="nav-item dropdown">
              
              <div class="col-md-12 d-flex justify-content-between align-items-center">
								
				<form action="SearchNV" method="post" class="form-inline my-2 my-lg-0">
	            <div class="input-group input-group-sm">
	            <input name="txtSearch" type="text" class="form-control"
	            aria-label=""Small aria-describedby="inputGroup-sizing-sm"
	            placeholder="Tìm kiếm nhân viên">
	            <div class="input-group-append">
	               <button type="submit" class="btn btn-secondary btn-number">
	               <i class="fa fa-search"></i>
	               </button>
	            </div>
	            </form>						
							</div>
            </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <style>
.center h1 {
    color: #000; /* Màu chữ trắng */
    text-align: center; /* Canh lề giữa */
    font-size: 24px; /* Kích thước chữ */
    margin-top: 20px; /* Khoảng cách từ trên xuống */
}
.center button {
    margin-top: 1000px; /* Khoảng cách từ trên xuống */
    box-shadow: 0 0 5px #000; /* Đổ bóng */
    font-weight: bold; /* Làm đậm chữ */
}
	  </style>
    <!-- END nav -->
    
    <div class="hero-wrap" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-8 ftco-animate d-flex align-items-end">
          	
	            <center>
	            <h1 style="color:white">Danh sách nhân viên</h1>
 <p style="color: red;">${errorString}</p>
 <table border="1" cellpadding="5" cellspacing="1" >
 <tr style="color:white">
 <th>Mã nhân viên</th>
 <th>Tên nhân viên</th>
 <th>Giới tính</th>
 <th>Chức vụ</th>
 <th>Chỉnh sửa</th>
 <th>Xóa</th>
 </tr>
 <c:forEach items="${nhanvienList}" var="nhanvien" >
 <tr>
 <td style="color:white">${nhanvien.id}</td>
 <td style="color:white">${nhanvien.username}</td>
 <td style="color:white">${nhanvien.gender}</td>
 <td style="color:white">${nhanvien.chucvu}</td>
 <td>
 <a href="editNhanVienServlet?id=${nhanvien.id}">Edit</a>
 </td>
 <td>
 <a href="deleteNhanVienServlet?id=${nhanvien.id}">Delete</a>
 </td>
 </tr>
 </c:forEach>
 </table>
 <a href="newNhanvien.jsp" >Thêm nhân viên</a>
	            
	            </center>
            
          </div>
        </div>
      </div>
    </div>

    

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>