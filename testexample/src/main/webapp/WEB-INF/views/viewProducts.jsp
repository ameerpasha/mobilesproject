<%@include file="Header.jsp" %>
<script>
$(document).ready(function(){
	var path="http//localhost:8080/testexample/pics"
	$("#producttable").DataTable({
		"ajax":{
			"url":"http//localhost:8080/testexample/allproducts","datasrc": ""
		},
		"columns":[
			{"data":"prodname"},
			{"data": "",
				"render":function(data,type,row)
				{
					return "&#8360;."+row.price+"";
					
				}	
				},
				
				{"data":"qty"},
				
				{"data":"prodname",
					"render":function(data,type,row){
						return '<img src="'+path+data+'.jpg" width="25px"height="25px"></img>';
					}
					
				},
				{"data":"prodid",
				"render":function(data,type,row){
					return"<a href='http://localhost:8080/testexample/Pics"+row.prodid+"/viewDetails' class='btn btn-primary'>view</a>";
				}	
				
				},
				/* {"data":"",
					"render":function(data,type,row){
						return"<a href='http://localhost:8080/testexample/"+row.prodid+"/addtocart' class='btn btn-primary'>add to cart</a>";
					}	
					
					} */
			
			
		]
		
	});
});

</script>
<div class="container-fluid">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">
<table class="table table-hover" id="producttable">
<thread>
<tr>
<th>product name</th>
<th>product price</th>
<th>quantity</th>
<th></th>
<th></th>
<th></th>
</tr>
</thread>

</table>

</div>
</div>
</div>