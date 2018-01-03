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
			//定义按钮不能被按下
//			if(currentPage == totalPage){
//				document.getElementById("btn_nextPage").disable = "disabled";
//				console.log("currentPage = totalPage");
//			}
		}
	},false);
	
	// previousPage
	document.getElementById("btn_previousPage").addEventListener("click",(event)=>{
		if(currentPage>1 && currentPage<=totalPage){
			currentPage = currentPage - 1;
			window.location.href = "userInit.mvc?currentPage=" + currentPage;
		}
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
