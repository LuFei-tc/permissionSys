/**
 * ajax
 */

//---------------------------common------------------------------
//获取数据
function getData(url,currentPage){
	config = {
		type:"get",
		url:url,
		data:{"currentPage":currentPage},
		success:function(data){
			$("#content").html(data);
		},
		error:function(xhr){
			if(xhr.status == 401){
				alert("暂无权限","",null,{type: 'warning', confirmButtonText: '确定'})
			}
		}
	};
	$.ajax(config);
}

function getDataByUrl(url){
	config = {
		type:"get",
		url:url,
		success:function(data){
			$("#content").html(data);
		},
		error:function(xhr){
			if(xhr.status == 401){
				alert("暂无权限","",null,{type: 'warning', confirmButtonText: '确定'})
			}
		}
	};
	$.ajax(config);
}
//删除数据
function deleteData(url,id){
	confirm("确定删除?","",function(isOk){
		if(isOk){
			config = {
				type:"get",
				url:url,
				data:{"id":id},
				success:function(data){
					$("#content").html(data);
					alert("删除成功","",null,{type: 'success', confirmButtonText: '确定'});
				},
				error:function(xhr){
					if(xhr.status == 401){
						alert("暂无权限","",null,{type: 'warning', confirmButtonText: '确定'})
					}
				}
			};
			$.ajax(config);
		}
	},{confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
}

//更新数据
function updateData(form,url){
	console.log($(form).serialize());
	config = {
		type:"post",
		url:url,
		data:$(form).serialize(),
		success:function(data){
			$("#content").html(data); 
			alert("更新成功","",null,{type: 'success', confirmButtonText: '确定'});
		},
		error:function(xhr){
			if(xhr.status == 401){
				alert("暂无权限","",null,{type: 'warning', confirmButtonText: '确定'})
			}
		}
	};
	$.ajax(config);
}

//-----------------------------sendEmail-------------------------------------------
function showSendModal(to){
	$("#mailModal #sendBtn").text("发送");
	$("#mailModal #sendBtn").click(function(){
		$("#mailModal #to").val(to); 
		$("#mailModal #sendBtn").text("发送中。。。");
		sendMail("/sendMail");
	});
	$("#mailModal #cancelSendBtn").click(function(){
		$("#mailModal").modal('hide');
	});
	$("#mailModal").modal();
}

function sendMail(url){
	config = {
		type:"post",
		url:url,
		data:$("#mailForm").serialize(),
		dataType:"json",
		success:function(data){
			if(data!=null && data.code != undefined){
				if(data.code == 1){
					alert("发送成功","",null,{type: 'success', confirmButtonText: '确定'})
					$("#mailModal").modal('hide');
				}else if(data.code == 101){
					alert(data.message,"",null,{type: 'error', confirmButtonText: '确定'})
					$("#mailModal #sendBtn").text("重新发送");
				}
			} 
		}
	};
	$.ajax(config); 
			 
}

//----------------------------sysUser----------------------------------------

function showUpdateData(surl,uurl,id){
	//查询数据id
	config = {
		type:"get",
		url:surl,
		data:{"id":id},
		dataType:"json",
		success:function(data){
			//将查询的数据展现在页面
			$("#userModal #myModalLabel").text("修改");
			$("#userModal #updateBtn").html("修改");
			$("#userForm").prepend('<input id="userId" name="user.userId" type="hidden">');
			$("#userModal #userId").val(data.userId);
			$("#userModal #username").val(data.username);
			$("#userModal #password").val(data.password);
			$("#userModal #email").val(data.email);
			$("#userModal #mobile").val(data.mobile);
			$("#userModal #status").val(data.status);
			
			$("#userModal .form-input").show();
			$("#userModal .form-check").hide();
			
			$("#userModal #nextBtn").click(function(){
				getModalData("/sysRoleJson",1,data.sysRoles);
				$("#userModal .form-input").hide();
				$("#userModal .form-check").show();
			})
			
			$("#userModal #preBtn").click(function(){
				$("#userModal .form-input").show();
				$("#userModal .form-check").hide();
			})
			
			$("#userModal #updateBtn").click(function(){
				updateData("#userForm",uurl);
				$("#userModal").modal('hide');
				$(".modal-backdrop").remove();
			});
			$("#userModal #cancelBtn").click(function(){
				$("#userModal").modal('hide');
			});
			$("#userModal").modal();
		}
	};
	$.ajax(config);
	//将页面更改的数据进行更新
}


function showAddModal(url){
	$("#userModal #myModalLabel").text("添加");
	$("#userModal #updateBtn").html("添加");
    $("#userForm #userId").remove();
    $("#userModal #userId").val("");
	$("#userModal #username").val("");
	$("#userModal #password").val("");
	$("#userModal #email").val("");
	$("#userModal #mobile").val("");
	$("#userModal #status").val("");
	
	$("#userModal .form-input").show();
	$("#userModal .form-check").hide();
	
	$("#userModal").modal();
	
	$("#userModal #nextBtn").click(function(){
		getModalData("/sysRoleJson",1);
		$("#userModal .form-input").hide();
		$("#userModal .form-check").show();
	})
	
	$("#userModal #preBtn").click(function(){
		$("#userModal .form-input").show();
		$("#userModal .form-check").hide();
	})
	
	$("#userModal #updateBtn").click(function(){
		updateData("#userForm",url);
		$("#userModal").modal('hide');
		$(".modal-backdrop").remove()
	});
	$("#userModal #cancelBtn").click(function(){
		$("#userModal").modal('hide');
	});
}



//获取角色列表
function getModalData(url,currentPage,hasRoles){
	  config = {
			type:"get",
			url:url,
			data:{"currentPage":currentPage},
			dataType:"json",
			success:function(data){
				$("#userModal .form-check .checks").html("");
				data.forEach(function(role){
					var checked = ""; 
					if(hasRoles!=null && hasRoles!=undefined){
						hasRoles.forEach(function(hasRole){
							if(hasRole.roleId == role.roleId){
								checked = "checked=checked";
							}
						})
					}
					$("#userModal .form-check .checks").append('<div class="checkbox">\
        <label>\
          <input type="checkbox" '+checked+' name="roleIds" value="'+role.roleId+'">'+ role.roleName+'\
        </label>\
      </div>');
				});
				 
			}
		};
		$.ajax(config);
}


//-----------------------------sysPerm--------------------------------------------
function showAddPermModal(url){
	$("#permModal #myModalLabel").text("添加");
	$("#permModal #updateBtn").html("添加");
    $("#permForm #permId").remove();
    $("#permForm #permId").val("");
	$("#permForm #name").val("");
	$("#permForm #type").val("");
	$("#permForm #perms").val("");
	$("#permForm #url").val("");
	$("#permForm #orderNum").val("");
	
	$("#permModal").modal();
	
	$("#permModal #updateBtn").click(function(){
		updateData("#permForm",url);
		$("#permModal").modal('hide');
		$(".modal-backdrop").remove()
	});
	$("#permModal #cancelBtn").click(function(){
		$("#permModal").modal('hide');
	});
}

function showUpdatePermData(surl,uurl,id){
	//查询数据id
	config = {
		type:"get",
		url:surl,
		data:{"id":id},
		dataType:"json",
		success:function(data){
			//将查询的数据展现在页面
			$("#permModal #myModalLabel").text("修改");
			$("#permModal #updateBtn").html("修改");
			$("#permForm").prepend('<input id="permId" name="permId" type="hidden">');
		    $("#permForm #permId").val(data.permId);
			$("#permForm #name").val(data.name);
			$("#permForm #type").val(data.type);
			$("#permForm #perms").val(data.perms);
			$("#permForm #url").val(data.url);
			$("#permForm #orderNum").val(data.orderNum);
		 
			$("#permModal #updateBtn").click(function(){
				updateData("#permForm",uurl);
				$("#permModal").modal('hide');
				$(".modal-backdrop").remove();
			});
			$("#permModal #cancelBtn").click(function(){
				$("#permModal").modal('hide');
			});
			$("#permModal").modal();
		}
	};
	$.ajax(config);
	//将页面更改的数据进行更新
}

//---------------------------------sysRole------------------------------------
function showUpdateRoleData(surl,uurl,id){
	//查询数据id
	config = {
		type:"get",
		url:surl,
		data:{"id":id},
		dataType:"json",
		success:function(data){
			//将查询的数据展现在页面
			$("#roleModal #myModalLabel").text("修改");
			$("#roleModal #updateBtn").html("修改");
			$("#roleForm").prepend('<input id="roleId" name="roleId" type="hidden">')
		    $("#roleModal #roleId").val(data.roleId);
			$("#roleModal #roleName").val(data.roleName);
			$("#roleModal #remark").val(data.remark);
			
			$("#roleModal .form-input").show();
			$("#roleModal .form-check").hide();
			
			$("#roleModal #nextBtn").click(function(){
				getModalPermData("/sysPermJson",1,data.sysPerms);
				$("#roleModal .form-input").hide();
				$("#roleModal .form-check").show();
			})
			
			$("#roleModal #preBtn").click(function(){
				$("#roleModal .form-input").show();
				$("#roleModal .form-check").hide();
			})
			
			$("#roleModal #updateBtn").click(function(){
				updateData("#roleForm",uurl);
				$("#roleModal").modal('hide');
				$(".modal-backdrop").remove();
			});
			$("#roleModal #cancelBtn").click(function(){
				$("#roleModal").modal('hide');
			});
			$("#roleModal").modal();
		}
	};
	$.ajax(config);
	//将页面更改的数据进行更新
}


function showAddRoleModal(url){
	$("#roleModal #myModalLabel").text("添加");
	$("#roleModal #updateBtn").html("添加");
    $("#roleForm #userId").remove();
    $("#roleModal #roleId").val("");
	$("#roleModal #roleName").val("");
	$("#roleModal #remark").val("");
	 
	
	$("#roleModal .form-input").show();
	$("#roleModal .form-check").hide();
	
	$("#roleModal").modal();
	
	$("#roleModal #nextBtn").click(function(){
		getModalPermData("/sysPermJson",1);
		$("#roleModal .form-input").hide();
		$("#roleModal .form-check").show();
	})
	
	$("#roleModal #preBtn").click(function(){
		$("#roleModal .form-input").show();
		$("#roleModal .form-check").hide();
	})
	
	$("#roleModal #updateBtn").click(function(){
		updateData("#roleForm",url);
		$("#roleModal").modal('hide');
		$(".modal-backdrop").remove()
	});
	$("#roleModal #cancelBtn").click(function(){
		$("#roleModal").modal('hide');
	});
}



//获取角色列表
function getModalPermData(url,currentPage,hasPerms){
	  config = {
			type:"get",
			url:url,
			data:{"currentPage":currentPage},
			dataType:"json",
			success:function(data){
				$("#roleModal .form-check .checks").html("");
				data.forEach(function(perm){
					var checked = ""; 
					if(hasPerms!=null && hasPerms!=undefined){
						hasPerms.forEach(function(hasPerm){
							if(hasPerm.permId == perm.permId){
								checked = "checked=checked";
							}
						})
					}
					$("#roleModal .form-check .checks").append('<div class="checkbox">\
        <label>\
          <input type="checkbox" '+checked+' name="permIds" value="'+perm.permId+'">'+ perm.perms+'\
        </label>\
      </div>');
				});
				 
			}
		};
		$.ajax(config);
}

//---------------------------------sysGood------------------------------------
//function showAddGoodModal(url){
//	 var param = {}
//	 param.goodTitle = "oppo",
//	 param.goodPrice = 2999,
//	 param.sellPoint = "ssss"
//	 config = {
//		    type:"post",
//		    url:url,
//		    data:param,
//		    dataType:"json",
//		    success:function(data){
//		    	$("#goodModal #goodId").val(data.goodId);
//				$("#goodModal #goodTitle").val(data.goodTitle);
//				$("#goodModal #sellPoint").val(data.sellPoint);
//				$("#goodModal #goodPrice").val(data.goodPrice);
//				$("#goodModal #num").val(data.num);
//				$("#goodModal #cid").val(data.cid);
//				$("#goodModal #status").val(data.status);
//				$("#goodModal #created").val(data.created);
//				$("#goodModal #updated").val(data.updated);
//				$("#goodModal .form-input").show();
//				$("#goodModal #updateBtn").click(function(){
//					updateData("#goodForm",url);
//					$("#userModal").modal('hide');
//					$(".modal-backdrop").remove();
//				});
//				$("#goodModal #cancelBtn").click(function(){
//					$("#goodModal").modal('hide');
//				});
//				$("#goodModal").modal();
//		    }
//	 };
//	 
//	 
//	 $.ajax(config);
//}

function showAddGoodModal(url){
	$("#goodModal #myModalLabel").text("添加");
	$("#goodModal #updateBtn").html("添加");
	$("#goodModal #goodId").val("");
	$("#goodModal #goodId").attr("readOnly",false);
	$("#goodModal #goodTitle").val("");
	$("#goodModal #sellPoint").val("");
	$("#goodModal #goodPrice").val("");
	$("#goodModal #num").val("");
	$("#goodModal #cid").val("");
	$("#goodModal #status").val("");
	$("#goodModal #created").val("");
	$("#goodModal #updated").val("");
	
	$("#goodModal .form-input").show();
	$("#goodModal #updateBtn").click(function(){
		updateData("#goodForm",url);
		$("#goodModal").modal('hide');
		$(".modal-backdrop").remove();
	});
	$("#goodModal #cancelBtn").click(function(){
		$("#goodModal").modal('hide');
	});
	$("#goodModal").modal();
}
//搜索商品
//function searchGood(url){
//	 config = {
//		    type:"post",
//		    url:url,
//		    data:$("#myForm").serialize(),
//		    dataType:"json",
//		    success:function(data){
//		    	$("#goodModal #goodId").val(data.goodId);
//				$("#goodModal #goodTitle").val(data.goodTitle);
//				$("#goodModal #sellPoint").val(data.sellPoint);
//				$("#goodModal #goodPrice").val(data.goodPrice);
//				$("#goodModal #num").val(data.num);
//				$("#goodModal #cid").val(data.cid);
//				$("#goodModal #status").val(data.status);
//				$("#goodModal #created").val(data.created);
//				$("#goodModal #updated").val(data.updated);
//				$("#goodModal .form-input").show();
//				$("#goodModal #updateBtn").click(function(){
//					updateData("#goodForm",url);
//					$("#userModal").modal('hide');
//					$(".modal-backdrop").remove();
//				});
//				$("#goodModal #cancelBtn").click(function(){
//					$("#goodModal").modal('hide');
//				});
//				$("#goodModal").modal();
//		    }
//	 };
//	 
//	 
//	 $.ajax(config);
//}



function showUpdateGoodData(surl,uurl,id){
	//查询数据id
	config = {
		type:"get",
		url:surl,
		data:{"id":id},
		dataType:"json",
		success:function(data){
			//将查询的数据展现在页面
			$("#goodModal #myModalLabel").text("修改");
			$("#goodModal #updateBtn").html("修改");
			$("#goodModal #goodId").attr("readOnly",true);
			$("#goodModal #goodId").val(data.goodId);
			$("#goodModal #goodTitle").val(data.goodTitle);
			$("#goodModal #sellPoint").val(data.sellPoint);
			$("#goodModal #goodPrice").val(data.goodPrice);
			$("#goodModal #num").val(data.num);
			$("#goodModal #cid").val(data.cid);
			$("#goodModal #status").val(data.status);
			$("#goodModal #created").val(data.created);
			$("#goodModal #updated").val(data.updated);
			
			$("#goodModal .form-input").show();
			
			$("#goodModal #updateBtn").click(function(){
				updateData("#goodForm",uurl);
				$("#goodModal").modal('hide');
				$(".modal-backdrop").remove();
			});
			$("#goodModal #cancelBtn").click(function(){
				$("#goodModal").modal('hide');
			});
			$("#goodModal").modal();
		}
	};
	$.ajax(config);
	//将页面更改的数据进行更新
}

//function (url,id){
//	config = {
//			type="get",
//			url:url,
//			data:{"id":id},
//			dataType:"json",
//			success:function(data){
//				//ajax 提交success方法中添加页面跳转
//				$("#content").html(data);
//			}
//			
//	};
//	
//	$.ajax(config);
//}

function showGoodById(url,id){
	console.log(url + "," + id)
	config = {
			type:"get",
			url:url,
			data:{"id":id},
			dataType:"json",
		success:function(data){
//			win.location.href= XMLHttpRequest.getResponseHeader("/index");
//			console.log("111")
//			console.log(data)
//			$("#goodInfo").html(data);
		}
		
	};
	$.ajax(config);
}


//----------------------sysOrder-------------------------------------------------------

 function showAddOrderModal(url){
	 console.log(url);
	    $("#orderModal #myModalLabel").text("添加");
		$("#orderModal #updateBtn").html("添加");
		$("#orderModal #oid").val("");
		$("#orderModal #gid").val("");
		$("#orderModal #uid").val("");
		$("#orderModal #num").val("");
		$("#orderModal #status").val("");
		
		$("#orderModal .form-input").show();
		$("#orderModal #updateBtn").click(function(){
			updateData("#orderForm",url);
			$("#orderModal").modal('hide');
			$(".modal-backdrop").remove();
		});
		$("#orderModal #cancelBtn").click(function(){
			$("#orderModal").modal('hide');
		});
		$("#orderModal").modal();
	 
 }


function showOrderData(url,id){
	 console.log("111");
	 config = {
				type:"get",
				url:url,
				data:{"id":id},
				dataType:"json",
				success:function(data){
					//将查询的数据展现在页面
					 $("#orderModal #myModalLabel").text("查看添加订单数据");
						$("#orderModal #updateBtn").html("查看添加订单数据");
						$("#orderModal #oid").val(data.oid);
						$("#orderModal #gid").val(data.gid);
						$("#orderModal #uid").val(data.uid);
						$("#orderModal #num").val(data.num);
						$("#orderModal #status").val(data.status);
						
						$("#orderModal .form-input").show();
						$("#orderModal #updateBtn").hide();
						$("#orderModal #cancelBtn").hide();
						$("#orderModal").modal();
				}
			};
			$.ajax(config);
			//将页面更改的数据进行更新
}

//查询
function searchOrder(url){
	alert("test1");
	var unamevalue = $("#uname").val();
	alert("test");
	alert(unamevalue);
	config = {
			type:"get",
			url:url,
			//data:document.getElementById('uname').value,
			data:$("#myForm").serialize(),
			dataType:"json",
			success:function(data){
				console.log(data);
				$(".detail").remove;
				var results = JSON.parse(data);
				for(var i = 0;i<results.length;i++){
					var oid = results[i].id;
					var uname = results[i].uname;
					var gname = results[i].gname;
					var price = results[i].price;
					var num = results[i].num;
					var totalPrice = results[i].totalPrice;
					var status = results[i].status;
					appendData(oid,uname,gname,price,num,totalPrice,status);
				}
				
			}
	};
}

function appendData(oid,uname,gname,price,num,totalPrice,status){
	var text = '<tr class="detail"><td>'+oid+'</td> <td>'+uname+'</td> <td>'+gname+'</td> <td>'+price+'</td> <td>'+num+'</td> <td>'+totalPrice+'</td> <td>'+status+'</td> '
	console.log(text);
	$('#mytable').append(text);

}






