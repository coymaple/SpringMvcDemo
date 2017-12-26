function rowSelectOperation(event){
	if(event.target.tagName.toLowerCase()=="td"){
		let input=event.target.parentNode.firstElementChild.firstElementChild;
		input.checked=input.checked?false:true;
	}
}
function init(){
	//nextPage
	document.getElementById("btn_nextPage").addEventListener("click",(event)=>{
		window.location.href = "userInit.mvc?currentPage=" +(Number.parseInt(document.getElementById("spanCurrentPage").innerHTML)+1);
	},false);
	
	//previousPage
	document.getElementById("btn_previousPage").addEventListener("click",(event)=>{
		window.location.href = "userInit.mvc?currentPage=" +(Number.parseInt(document.getElementById("spanCurrentPage").innerHTML)-1);
	},false);
	
	//row select
	document.getElementById("userInfoTbody").addEventListener("click",rowSelectOperation,false);
	//all select
	document.getElementById("allCheck").addEventListener("change",(event)=>{
		let allCheck=event.target;
		let arrays=document.getElementsByName("checks");
		arrays.forEach((item)=>{
			item.checked=allCheck.checked;
		});
	},false);
}
window.addEventListener("load",init,false);
