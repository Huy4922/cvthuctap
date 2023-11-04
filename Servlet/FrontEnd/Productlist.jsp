<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
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
	      <div class="order-lg-last btn-group">
          
          
        </div>

	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        
	          <li class="nav-item active"><a href="index.jsp" class="nav-link">Trang chủ</a></li>
	          <li class="nav-item"><a href="NhanVienListServlet" class="nav-link">Nhân viên</a></li>
	          <li class="nav-item"><a href="ProductListServlet" class="nav-link">Danh sách sản phẩm</a></li>
	          <li class="nav-item dropdown">
              
              
            </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp">Trang chủ <i class="fa fa-chevron-right"></i></a></span> <span>Sản phẩm <i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">Sản phẩm</h2>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="row mb-4">
							<div class="col-md-12 d-flex justify-content-between align-items-center">
								<a href="newProduct.jsp" >+Thêm sản phẩm</a>	
				<form action="Search" method="post" class="form-inline my-2 my-lg-0">
	            <div class="input-group input-group-sm">
	            <input name="txtSearch" type="text" class="form-control"
	            aria-label=""Small aria-describedby="inputGroup-sizing-sm"
	            placeholder="Tìm kiếm sản phẩm">
	            <div class="input-group-append">
	               <button type="submit" class="btn btn-secondary btn-number">
	               <i class="fa fa-search"></i>
	               </button>
	            </div>
	            </form>						
							</div>
						</div>
						<div class="row">							
  <c:forEach items="${productList}" var="product" >
    <div class="col-md-4 d-flex ">
      <div class="col-md-12 mb-4">
        <div class="product ftco-animate">
          <div class="img d-flex align-items-center justify-content-center" style="background-image: url(${product.image});">
            <div class="desc">
              <p class="meta-prod d-flex">
                <a href="editProductServlet?id=${product.id}" class="d-flex align-items-center justify-content-center">Chỉnh</span></a>
                <a href="deleteProductServlet?id=${product.id}" class="d-flex align-items-center justify-content-center">Xóa</span></a>
                
              </p>
            </div>
          </div>
          <div class="text text-center">
            <span class="category">${product.type}</span>
            <h2>${product.name}</h2>
            <span class="price">$${product.price}</span>
          </div>
        </div>
      </div>
    </div>
    <c:if test="${(productStatus.index + 1) % 4 == 0}">
      <div class="w-100"></div>
    </c:if>
  </c:forEach>
</div>					
					</div>

					
				</div>
			</div>
		</section>

    <footer class="ftco-footer">
      
      <div class="container-fluid px-0 py-5 bg-black">
      	<div class="container">
      		<div class="row">
	          <div class="col-md-12">
		
	            
	          </div>
	        </div>
      	</div>
      </div>
    </footer>
    
  

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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>