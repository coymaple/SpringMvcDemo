(function(ajax){

	function messageToggle(prefix,flag,message){
		document.getElementById(prefix+"Image").classList.add("message");
		document.getElementById(prefix+"Message").innerHTML=message;
		if(flag){
			document.getElementById(prefix+"Message").classList.add("successMessage");
			document.getElementById(prefix+"Image").classList.add("successImage");
		}else{
			document.getElementById(prefix+"Message").classList.add("errorMessage");
			document.getElementById(prefix+"Image").classList.add("errorImage");
		}
	}
	function checkUserName(){
		let userNameValue=document.getElementById("userName").value;
		if(userNameValue==""){
			messageToggle("userName",false,"用户名不能为空！");
		}else{
			messageToggle("userName",true,"用户名正确！");
		}
	}
	function checkRePassword(){
		let passwordValue=document.getElementById("password").value;
		let rePasswordValue=document.getElementById("rePassword").value;
		if(passwordValue==rePasswordValue){
			messageToggle("rePassword",true,"两次输入的密码一致！");
		}else{
			messageToggle("rePassword",false,"两次输入的密码不一致！");
		}
	}
	function checkPassword(){
		let passwordValue=document.getElementById("password").value;
		if(passwordValue==""){
			messageToggle("password",false,"密码不能为空！");
			
		}else if(passwordValue.length<6){
			messageToggle("password",false,"密码长度不能小于6位！");
		}else{
			messageToggle("password",true,"密码符合要求！");
		}
	}
	
	function hobbyInitCallbak(xhr){
		let json=JSON.parse(xhr.responseText);
		let insertPoint=document.getElementById("hobbyInsertPoint");
		if(json.result=="success"){
			json.list.forEach((item)=>{
				let input=document.createElement("input");
				input.type="checkbox";
				input.name="hobby";
				input.id="hobby_"+item.code;
				input.value=item.code;		
				insertPoint.appendChild(input);
				let label=document.createElement("label");
				label.for="hobby_"+item.code;
				label.innerHTML=item.name+"&nbsp;";
				insertPoint.appendChild(label);
			});

			
		}else{
			
		}		
	}
	function npInitCallback(xhr){
		let json = JSON.parse(xhr.responseText);
		let province = document.getElementById("province");
		if(json.result=="success"){
			json.list.forEach((item)=>{
				let option = document.createElement("option");
				option.type = "option";
				option.id = item.code;
				option.value = item.code;
				option.innerHTML = item.name;
				province.appendChild(option);
			});
		}
	}
	
	function initCity(){
		ajax.jsonGet("npCity.mvc",npCityCallback);
	}
	
	function npCityCallback(xhr){
		let json = JSON.parse(xhr.responseText);
		let city = document.getElementById("city");
		city.length = 1;
		if(json.result == "success"){
			json.list.forEach((item)=>{
				if(item.code.substr(0,2) == document.getElementById("province").value){
					let option = document.createElement("option");
					option.type = "option";
					option.id = item.code;
					option.value = item.code;
					option.innerHTML = item.name;
					city.appendChild(option);
				}
			});
		}
	}
	
	function init(){
		ajax.jsonGet("hobbyInit.mvc",hobbyInitCallbak);
		ajax.jsonGet("npInit.mvc",npInitCallback);
		
		document.getElementById("province").addEventListener("change",initCity,false);
		
		document.getElementById("userName").addEventListener("blur",checkUserName,false);
		document.getElementById("userName").addEventListener("focus",()=>{
			document.getElementById("userNameMessage").innerHTML="";
			document.getElementById("userNameMessage").className="";
			document.getElementById("userNameImage").className="";
		},false);
		document.getElementById("password").addEventListener("blur",checkPassword,false);
		document.getElementById("password").addEventListener("focus",()=>{
			document.getElementById("passwordMessage").innerHTML="";
			document.getElementById("passwordMessage").className="";
			document.getElementById("passwordImage").className="";
		},false);
		document.getElementById("rePassword").addEventListener("blur",checkRePassword,false);
		document.getElementById("rePassword").addEventListener("focus",()=>{
			document.getElementById("rePasswordMessage").innerHTML="";
			document.getElementById("rePasswordMessage").className="";
			document.getElementById("rePasswordImage").className="";
		},false);

	}
	window.addEventListener("load",init,false);	
	
})(window.ajaxUtils);
