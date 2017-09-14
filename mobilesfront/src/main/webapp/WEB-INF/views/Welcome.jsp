<%@include file="Header.jsp" %>
<style>
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
margin:auto;

}
</style>

<body>
	<div class="container">
		<h2>carousel example</h2>
		<div id="mycarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
				<li data-target="#mycarousel" data-slide-to="1"></li>
				<li data-target="#mycarousel" data-slide-to="2"></li>
				<li data-target="#mycarousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox" style="width:100%; height:300px !important;"> 
			
				<div class="item active">
					<img src="images/11.jpg" alt="aamir" style="width: 100%";">
					<div class="carousel-caption">
						<h3>aamir</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/22.jpg" alt="pasha" style="width: 100%";">
					<div class="carousel-caption">
						<h3>pasha</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/33.jpg" alt="abhi" style="width: 100%";">
					<div class="carousel-caption">
						<h3>abhi</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/44.jpg" alt="pasha" style="width: 100%";">
					<div class="carousel-caption">
						<h3>hgygb</h3>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#mycarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> 
				<span class="sr-only">previous</span>
			</a> <a class="right carousel-control" href="#mycarousel"
				data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right"></span> 
				<span class="sr-only">next</span>
			</a>



		</div>


	</div>
<%@include file="Footer.jsp"%>