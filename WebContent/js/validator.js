$(function () {	
       $('#loginForm').bootstrapValidator({
　　　　　　	message: '输入值不合法',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName : {
                	message : '用户名不能为空',
                	validators : {
                		notEmpty : {
                			message : '用户名不能为空'
                		},
                		stringLength: {
					       min: 4,
					       max: 12,
					       message: '用户名由4-12位字符组成'
      					}
                	} 	
                },
				passwd: {
					message : '密码项不能为空',
					validators : {
						notEmpty : {
							message : '密码项不能为空'
						}
					}
				},
				ad:{
					message:'必选项',
					validators :{
						notEmpty:{
							message:'必选项'
						}
					}
				}
            }
        })
        $('#registForm').bootstrapValidator({
		　　　　　message: '输入值不合法',
		            feedbackIcons: {
		                valid: 'glyphicon glyphicon-ok',
		                invalid: 'glyphicon glyphicon-remove',
		                validating: 'glyphicon glyphicon-refresh'
		            },
		            fields: {
		                new_username : {
		                	message : '用户名不能为空',
		                	validators : {
		                		notEmpty : {
		                			message : '用户名不能为空'
		                		},
		                		 stringLength: {
							       min: 4,
							       max: 12,
							       message: '用户名由4-12位字符组成'
      							}
		                	}
		                },
						new_passwd: {
							message : '密码项不能为空',
							validators : {
								notEmpty : {
									message : '密码项不能为空'
								}	
							}
						},
						passwd_a: {
							message : '确认密码项不能为空',
							validators : {
								notEmpty : {
									message : '确认密码项不能为空'
								},
								identical: {
						            field: 'new_passwd',
						            message: '两次输入的密码不相符'
        						}
							}		
						},
						Name: {
							message : '姓名不能为空',
							validators : {
								notEmpty : {
									message : '姓名项不能为空'
								}
							}
						},
						address: {
							message : '家庭住址不能为空',
							validators : {
								notEmpty : {
									message : '家庭住址项不能为空'
								}
							}
						}
		            }
		        })
			$('#releaseForm').bootstrapValidator({
				　　　　　　	message: '输入值不合法',
				            feedbackIcons: {
				                valid: 'glyphicon glyphicon-ok',
				                invalid: 'glyphicon glyphicon-remove',
				                validating: 'glyphicon glyphicon-refresh'
				            },
				            fields: {
				                GoodsName : {
				                	message : '商品名不能为空',
				                	validators : {
				                		notEmpty : {
				                			message : '商品名不能为空'
				                		}
				                	} 	
				                },
								GoodsDescript: {
									message : '商品描述不能为空',
									validators : {
										notEmpty : {
											message : '商品描述不能为空'
										}
									}
								},
								GoodsPrice:{
									message:'商品价格不能为空',
									validators:{
										notEmpty:{
											message:'商品价格不能为空'
										}
									}
								}
				            }
				        })
})
		function Login() {
		   	var mymodal = $('#login');
		    var bootstrapValidator = $("#loginForm").data("bootstrapValidator");
		   	bootstrapValidator.validate();
		   	if (bootstrapValidator.isValid()) { // 模态框是否通过验证
		   		
		   		var $form = $('#loginForm');
		   		// 使用Ajax提交form表单数据
		   		$.post($form.attr('action'), $form.serialize(), function(result) {
		   		if(result.result=='1'){
		   			var check_radio = $("input[name='ad']:checked").val();
		   			if(check_radio == 'root')
		   				location.href='admin';
		   			else if(check_radio == 'lease')
		   				location.href='showGoods';
		   			else
		   				location.href='showRent';
		   		}
		   		else{
		   			alert('登陆失败！');
		   		}
		   		}, 'json');

		    }
		}
		
		function Resiter() {
			var mymodal = $('#register');
			var bootstrapValidator = $("#registForm").data("bootstrapValidator");
			bootstrapValidator.validate();
			if (bootstrapValidator.isValid()) { // 模态框是否通过验证
				var $form = $('#registForm');
		   		// 使用Ajax提交form表单数据
		   		$.post($form.attr('action'), $form.serialize(), function(data) {
			   		if(data.result=='1'){
			   			alert('注册成功！');
			   			mymodal.modal('hide'); 
			   		}
			   		else{
			   			alert('注册失败！');
			   		}
		   		}, 'json');
			}
		}
		function Release(){
			var mymodal = $('#release');
			var bootstrapValidator = $("#releaseForm").data("bootstrapValidator");
			bootstrapValidator.validate();
			if (bootstrapValidator.isValid()) { // 模态框是否通过验证
				var $form = $('#releaseForm');
				var formData = new FormData($('#releaseForm')[0]);  
		   		// 使用Ajax提交form表单数据
//		   		$.post($form.attr('action'), formData, function(data) {
//			   		if(data.result=='1'){
//			   			alert('发布成功！');
//			   			mymodal.modal('hide'); 
//			   			location.href='showRent';
//			   		}
//			   		else{
//			   			alert('发布失败！');
//			   		}
//		   		}, 'json');
		   	
		   		
		   	 $.ajax({  
		          url: $form.attr('action'),  
		          type: 'POST',  
		          data: formData,  
		          async: false,  
		          cache: false,  
		          contentType: false,  
		          processData: false,  
		          success: function (returndata) {  	        	  
				   			alert('发布成功！');
				   			mymodal.modal('hide'); 
				   			location.href='showRent';			   		
		          },  
		          error: function (returndata) {  
		        	  alert('发布失败!！');  
		          }  
		     },'json');  
			}
		}