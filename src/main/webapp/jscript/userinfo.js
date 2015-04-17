function del(name,user_data){
	$.ajax({
		    type : "POST",  
		    url : name + "/userinfo.do?delete",  
		    data:"userid="+user_data,
		    dataType: "json",  
		    success : function(data){  
		        if(data.del == "true"){  
		            alert("删除成功!");  
		            deleteRow(user_data);
		        }  
		        else{  
		            alert("删除失败!");  
		        }  
		    },  
		    error :function(){  
		        alert("网络连接出错!");  
		    }  
	});
}

//删除行
function deleteRow(rownum){    
	var tr = document.getElementById(rownum);
	if(tr != null)
	{    
		tr.parentNode.removeChild(tr);  
	}
	else{    
		throw new Error("the given object is not contained by the table");  
	}
}













