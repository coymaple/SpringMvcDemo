var ajaxUtils=(function(){
	function jsonGet(url,callback,param){
		let xhr=new XMLHttpRequest();
		xhr.open("get",url,true);
		xhr.addEventListener("readystatechange",()=>{
			if(xhr.readyState==4&&xhr.status==200){
				callback(xhr);
			}
		},false);
		xhr.send(null);
	}
	return {jsonGet:jsonGet}
})();