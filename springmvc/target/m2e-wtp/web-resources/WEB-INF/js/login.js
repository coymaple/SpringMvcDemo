function $(node){
	return document.getElementById(node);
}
function init(){
	$("btn_register").addEventListener("click",()=>{
		window.location.href="register.jsp";
	},false);
}
window.addEventListener("load",init,false);