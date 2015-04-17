$(function(){
	var userInfo = new UserInfo();
	userInfo.init();
});


var UserInfo = function(){
	
};
UserInfo.prototype = {
	init:function(){
		var _this = this;
		$("#regist").click(function(){
			_this.registUser();
		});
		this.show_or_hide();
		
	},
	
	show_or_hide:function(){
		$("#upload article").click(function(){
			
			if($("#new_user_section").attr("class") == "show_user_section"){
				$("#new_user_section").removeClass("show_user_section").addClass("hide_user_section");
			}
			else if($("#new_user_section").attr("class") == "hide_user_section"){
				$("#new_user_section").removeClass("hide_user_section").addClass("show_user_section");
			}
		});
		
		return false;
	},
	
	registUser:function(){
		var _this = this;
		var  jsonObj = this.getUserINfo();
		
		//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName=window.document.location.pathname;
	    //获取带"/"的项目名，如：/uimcardprj
//	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	    
		$.ajax({
		    type : "POST",  
		    url : pathName + "?save",  
		    data:"jsonstr="+JSON.stringify(jsonObj),
		    dataType: "json", 
		    success : function(data){  
		        if(data.save == "true"){  
		            alert("添加成功!");  
		            _this.addTableRow(data);
		        }  
		        else if(data.save = "false"){  
		            alert("添加失败!");  
		        }
		        else if(data.save = "flag"){  
		            alert("添加用户成功,添加用户信息失败!");  
		        } 
		    },  
		    error :function(){
		        alert("网络连接出错!");
		    }  
		});
		
		return false;
	},
	
	getUserINfo:function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var address = $("#address").val();
		var phone = $("#phone").val();
		
		var jsonString = {
				"address":address,
				"phone":phone,
				"user":
					{
					"username":username,
					"password":password
					}
		};
		return jsonString;
	},
	
	addTableRow:function(data){
		var project = "'"+"/demo"+"'";
		var content = '<tr id='+data.userid+'>'+
			              "<td>"+data.userid+"</td>"+
			              "<td>"+data.user.username+"</td>"+
			              "<td>"+data.address+"</td>"+
			              "<td>"+data.phone+"</td>"+
			              "<td><form method = 'post' action='/demo/userinfo.do?edit&id="+data.user.id+"&username="+data.user.username+"' ><input type='submit' id='edit_"+data.user.id+"' value='编辑' /></form></td>"+
			              "<td><input type='button' id="+data.userid+" onclick='del("+project+","+data.userid+")'"+ " value='删除' /></td></tr>";
			              
		$("#userInfoTable").last().append(content);
		
		$("#username").val("");
		$("#password").val("");
		$("#address").val("");
		$("#phone").val("");
	},
};











