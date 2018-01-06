<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人中心</title>
<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="/css/bootstrap-table.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="/css/bootstrap-editable.css"></c:url>'
	rel="stylesheet">

	
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					
					<a class="navbar-brand" href="#">智游云盘</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="index.jsp"> 我的网盘 </a>
						</li>
						<li >
							<a href='<c:url value="/video"></c:url>'> 分享 </a>
						</li>
						<li>
							<a href='<c:url value="/speaker"></c:url>'>隐藏空间</a>
						</li>
						<li>
							<a href='<c:url value="/course"></c:url>'>功能宝箱</a>
						</li>
						<li>
							<a href='<c:url value="/subject"></c:url>' onclick="logout()">退出登录</a>
						</li>
						<li>
							<a href="#"><%=request.getAttribute("getEmail") %></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		
		
		
		<div class="panel panel-primary">
			<div class="panel-heading">个人中心</div>
			<div id="toolbar" class="btn-group" role="group" aria-label="...">
				
				<button type="button" id="btn_delete" class="btn btn-default"
					onclick="deleteSomeVideo()">
					<span class=" glyphicon glyphicon-open" aria-hidden="true"></span>
					上传
				</button>
				<button type="button" id="btn_delete" class="btn btn-default"
					onclick="getPath()">
					<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
					下载
				</button>
				<button type="button" id="btn_delete" class="btn btn-default"
					onclick="deleteSomeDirectory()">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除
				</button>
				<button type="button" id="btn_add" class="btn btn-default"
					onclick="showAddModal()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					新建文件夹
				</button>
			<div>
			<button type="button" class="btn btn-default"
					onclick="getback()">
					<span class="glyphicon glyphicon-share-alt" aria-hidden="true">&emsp;上一页</span>
				</button>
				<button type="button" id="btn_add" class="btn btn-default"
					onclick="backHome()">
					<span class="glyphicon glyphicon-home" aria-hidden="true">&emsp;首页</span>
				
				</button>
			</div>
			</div>
			<!-- Table -->
			<table class="table"></table>
		</div>
	</div>
<!-- 点击添加,跳出的模态框 -->
	<div class="modal fade" id="modal_add" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">新建文件夹</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">文件名：</label>
							<input type="text" class="form-control" id="add_name">
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="addDirectory()">添加</button>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src='<c:url value="/js/jquery-3.2.1.min.js"></c:url>'></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-table.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-table-zh-CN.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-editable.min.js"></c:url>'></script>
	<script
		src='<c:url value="/js/bootstrap-table-editable.min.js"></c:url>'></script>


	<script>
		// 声明一个方法，不需要设置返回值，参数随意写，只写名字，不写类型

		// 点击增加按钮 弹出添加模态框
		function showAddModal() {

			// 清空已经输入的内容
			// 选择器可以连接，进行多个条件限制
			// eg：选中 id = modal_add 标签内的 class = form-control 的标签
			$('#modal_add .form-control').val("");

			// 弹出模态框
			$('#modal_add').modal('show');
		}

		function addDirectory() {
			var name = $('#add_name').val();
			
			/* alert(name) */
			$.ajax({

				url : '<c:url value="/directory/add"></c:url>',

				type : 'POST',
				data : JSON.stringify({
					'name' : name,
				}),

				dateType : 'json',

				contentType : 'application/json',

				success : function(responseVO) {

					if (responseVO.errorCode == 0) {
						// 添加成功，收回模态框
						$('#modal_add').modal('hide');

						// 刷新表格
						$('.table').bootstrapTable('refresh');
					}
				},
				error : function(error) {
					alert("出错了");
				}
			});
		}
	/* 单选删除   */
		function deleteDirectory(id) {

			$.ajax({

				url : "<c:url value='/directory/" + id + "'></c:url>",

				type : 'DELETE',

				success : function(responseVO) {

					if (responseVO.errorCode == 0) {

						// 刷新表格
						$('.table').bootstrapTable('refresh');
					}
				},

				error : function(error) {

					alert(error);
				}
			});

		}
		/*  批量删除 */
		function deleteSomeDirectory(ids) {

			var list = $('.table').bootstrapTable('getSelections');

			if (list != null) {

				var idArray = new Array();
				// $.each(需要遍历的集合对象, function(索引，值){});
				$.each(list, function(index, value) {

					// 遍历 list 取出每一个的 id 放入 idArray 这个数组
					idArray[index] = value.id;
				});

				// 生成拼接后的 id 字符串
				var ids = idArray.join(",");

				$.ajax({

					url : "<c:url value='/directory/" + ids + "'></c:url>",

					type : 'DELETE',

					success : function(responseVO) {

						if (responseVO.errorCode == 0) {

							// 刷新表格
							$('.table').bootstrapTable('refresh');
						}
					},

					error : function(error) {

						alert(error);
					}
				});
			}
		}
		/* 获取下载链接  */
	function getPath(ids){

		var list = $('.table').bootstrapTable('getSelections');

		if (list != null) {

			var idArray = new Array();
			// $.each(需要遍历的集合对象, function(索引，值){});
			$.each(list, function(index, value) {

				// 遍历 list 取出每一个的 id 放入 idArray 这个数组
				idArray[index] = value.id;
			});

			// 生成拼接后的 id 字符串
			var ids = idArray.join(",");

			$.ajax({

				url : "<c:url value='/directory/" + ids + "'></c:url>",

				type : 'DELETE',

				success : function(responseVO) {

					if (responseVO.errorCode == 0) {

						// 刷新表格
						$('.table').bootstrapTable('refresh');
					}
				},

				error : function(error) {

					alert(error);
				}
			});
		}
		
	}
function getback(){
	window.location.href = document.referrer;
	window.history.back(-1);
}
function backHome(){
	alert("回到首页")
}

function logout(){
	if (confirm("你确定要注销身份吗？是－选择确定，否-选择取消")){
		window.location.href="localhost:8080/CloudPan/login.jsp"
		location.reload([bForceGet])  
	}
}
/* 展示所有  */
		$(document).ready(function() {

			$('.table').bootstrapTable(
			  {
				toolbar : '#toolbar',

				url : '<c:url value="/directory/list"></c:url>',

				columns : [{
							checkbox : true
							},
							{
							 /* title : '文件名',
							 field : 'name',
							 align : 'center',
							 */
								title : '文件名',
								align : 'center',
								formatter : function(
										value, row,
										index) {
										var span=row.name 

										if (row.isFile=0) {
											span="<span class='glyphicon glyphicon-folder-open'  aria-hidden='true'>&emsp;"+span
										}
										return span;
								},
								 editable : {
						           type : 'text',
								   title : '课程标题',
									validate : function(v) {if (!v)
												return '课程标题不能为空';
											}
										}
								},
							{
							 title : '大小',
							 field : 'size',
							 align : 'center',
							},
							{
							 title : '修改时间',
							 field : 'gmtModified',
							 align : 'center',
							},
							{
								field : 'id',
								title : '操作',
								align : 'center',

						formatter : function(value, row,index) {

							var deleteButton = "&emsp;<button class='btn btn-default ' type='button'  onclick='deleteDirectory("
										+ row.id
										+ ")'><span class='glyphicon glyphicon-trash'  aria-hidden='true'></span> </button>"
								
							return deleteButton;
						}
					} ],

								cache : false,

								pagination : true,

								// 启用搜索
								search : true,
								// 模糊查询 
								strictSearch :false,
								//搜索框右置 
								searchAlign:'right',

								sidePagination : 'server',

								pageSize : 5,

								pageList : [ 3, 5, 10 ],

								paginationLoop : false,

								paginationPreText : '上一页',

								paginationNextText : '下一页',

								dataField : "data",

								responseHandler : function(
										responseVO) {
									// 在ajax获取到数据，渲染表格之前，修改数据源  
									return {
										'total' : responseVO.data.count,
										'data' : responseVO.data.rows
										// 'data' : responseVO.listDate
									};
								},
								onEditableSave : function(
										field, row, oldValue,
										$el) {
										$.ajax({
												url : "<c:url value='/directory/rename/" + row.id + "'></c:url>",
												type : 'PUT',
												// 415 是 contentType 没有设置对
												contentType : 'application/json',
												data : JSON.stringify(row),

												success : function(responseVO) {
												},

												error : function(error) {
													alert(error);
												},
												
											});
								},
							});
		});
</script>
</body>
</html>