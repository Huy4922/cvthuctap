<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
              
              
            </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <style>
	  center h3,
center a {
  color: #FFFFFF;
}
body {
    color: #FFFFFF;
  }
center {
  background-color: black;
}
	  </style>
    <!-- END nav -->
    
    <div class="hero-wrap" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
      
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          
          	
          	
	            <center>
	            <h1>Cập nhật sản phẩm</h1>
 <form method="POST" action="editProductServlet?id=${product.id}" enctype="multipart/formdata">
 <table>
 <tr>
 <td>Mã sản phẩm</td>
 <td>"${product.id}"</td>
 </tr>
 <tr>
 <td>Tên sản phẩm</td>
 <td><input type="text" name="name"
value="${product.getName()}"/></td>
 </tr>
 <tr>
 <td>Loại sản phẩm</td>
 <td><input type="text" name="type"
value="${product.getType()}"/></td>
 </tr>
 <tr>
 <td>Giá sản phẩm</td>
 <td><input type="text" name="price"
value="${product.getPrice()}"/></td>
 </tr>
 <tr>
 <td>Hình sản phẩm</td>
 <td><input type="text" name="image"
value="${product.getImage()}"/></td>
 </tr>
 <tr>
 <td colspan="2"><a href = editProductServlet><button>Cập nhật</button><input type="reset"></td></a>
 </tr>
 </table>
 </form>
	            </center>
            
          
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