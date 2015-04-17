$(function(){
	var userSalaryJS = new UserSalaryJS();
	userSalaryJS.init();
});

var UserSalaryJS = function(){
	this.oldSalary = 0;
	this.salaryflag = false;
};

UserSalaryJS.prototype={
		init:function(){
			var _this = this;
			
			$("#salaryvalue").focus();
			_this.oldSalary = $("#salaryvalue").val();
			
			this.salarytextchick();
			
			$("#salaryvalue").blur(function(){
				_this.changfocus();
			});
			
			$("#savebutton").click(function(){
				_this.judgesaveornot();
			});
			
		},

		salarytextchick:function(){
			var _this = this;
			$("#salaryvalue").click(function(){
				_this.changeElement();
			});
		},
		
		changeElement:function(){
			var _this = this;
			var oldvalue = $("#salaryvalue").val();
			$("#salaryvalue").removeClass("old_li_input");
			$("#salaryvalue").addClass("new_li_input");
			if(oldvalue == '0.0' || oldvalue == '0'){
				$("#salaryvalue").val("");
			}else{
				$("#salaryvalue").val(oldvalue);
			}
		},
		
		changfocus:function(){
			var _this = this;
			var salaryValue = $("#salaryvalue").val();
			
			if(salaryValue == ""){
				alert("please enter salary!");
				$("#salaryvalue").val("");
				$("#salaryvalue").focus();
				_this.salaryflag = false;
				
			}else if (!/^[0-9]+(.[0-9]{1})$/.test(salaryValue)){
				alert("please enter right salary!");
				$("#salaryvalue").val("");
				$("#salaryvalue").focus();
				_this.salaryflag = false;
				
			}else{
				$("#salaryvalue").removeClass("new_li_input");
				$("#salaryvalue").addClass("old_li_input");
				_this.salaryflag = true;
			}
			
			$("#salaryvalue").focus(function(){
				_this.oldSalary = $("#salaryvalue").val();
			});
		},
		
		judgesaveornot:function(){
			var _this = this;
			var newSalary = $("#salaryvalue").val();
			if((_this.oldSalary != newSalary || _this.oldSalary == 0) && _this.salaryflag){
				_this.oldSalary = newSalary;
				_this.save();
//				_this.salaryflag = false;
			}else{
				alert("pelase chagne the salary!");
			}
		},
		
		save:function(){
			var userid = $("#userid").text();
			var salary = $("#salaryvalue").val();
			var id = $("#username label").attr("id");
			
			$.ajax({
				type:"POST",
				url:"usersalary.do?save",
				data:"userSalary.user.id="+userid+"&userSalary.salary="+salary+"&userSalary.id="+id,
				dataType:"json",
				success:function(data){
					if(data.save == "true"){
						if(data.id != "-1"){
							$("#username label").attr("id",data.id);
						}
						alert("success!");
					}else if(data.save == "false"){
						alert("error!")
					}
					
				},
				error:function(){
					alert("网络连接出错");
				}
			});
		}
}

