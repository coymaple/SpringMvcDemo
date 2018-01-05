(function(ajax){
	function rowSelectOperation(event){
		if(event.target.tagName.toLowerCase()=="td"){
			let input=event.target.parentNode.firstElementChild.firstElementChild;
			input.checked=input.checked?false:true;
		}
	}
	
	
	
	function init(){
		
		var totalPage = Number.parseInt(document.getElementById("spanTotalPage").innerText);
		var currentPage = Number.parseInt(document.getElementById("spanCurrentPage").innerText);
		
		
		// nextPage
		document.getElementById("btn_nextPage").addEventListener("click",(event)=>{
			if(currentPage>=1 && currentPage<totalPage){
				currentPage = currentPage + 1;
				window.location.href = "userInit.mvc?currentPage=" + currentPage;
			}
		},false);
		
		// previousPage
		document.getElementById("btn_previousPage").addEventListener("click",(event)=>{
			if(currentPage>1 && currentPage<=totalPage){
				currentPage = currentPage - 1;
				window.location.href = "userInit.mvc?currentPage=" + currentPage;
			}
		},false);
		
		/*
		 * 带有模糊查询的分页，我需要参数传到后台，并且需要重设一切页面上的参数，可能重新加载此页是一个方法
		 * 
		 */
		document.getElementById("btn_search").addEventListener("click",(event)=>{
			var keyword = document.getElementById("keyword").value;
			//console.log(keyword);
			window.location.href = "userInit.mvc?currentPage=" + currentPage + "&keyword=" + keyword;
		},false);
		
		//首页
		document.getElementById("btn_firstPage").addEventListener("click",(event)=>{
			window.location.href = "userInit.mvc?currentPage=" + 1;
		},false);
		
		//末页
		document.getElementById("btn_lastPage").addEventListener("click",(event)=>{
			window.location.href = "userInit.mvc?currentPage=" + totalPage;
		},false);
		
		// row select
		document.getElementById("userInfoTbody").addEventListener("click",rowSelectOperation,false);
		// all select
		document.getElementById("allCheck").addEventListener("change",(event)=>{
			let allCheck=event.target;
			let arrays=document.getElementsByName("checks");
			arrays.forEach((item)=>{
				item.checked=allCheck.checked;
			});
		},false);
	}
	window.addEventListener("load",init,false);
})(window.ajaxUtils)
