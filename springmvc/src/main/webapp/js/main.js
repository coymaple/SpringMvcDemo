function init(){
	let liLevel1s=document.getElementsByClassName("li_level1")
	Array.from(liLevel1s).forEach((item)=>{
		item.addEventListener("click",(event)=>{
			let ul=event.target.nextElementSibling;
			ul.hidden=ul.hidden?false:true;
		},false);
	});
	document.getElementById("footerShowAndHiddenOperation").addEventListener("click",()=>{
		let ctrl=document.getElementById("footerShowAndHiddenOperation");
		let footer=document.getElementsByTagName("footer").item(0);
		if(ctrl.className.indexOf("trans")!=-1){
			footer.style.height="200px";
			ctrl.classList.remove("trans");			
		}else{
			footer.style.height="20px";
			ctrl.classList.add("trans");					
		}

		
	},false);
	document.getElementById("showAndHiddenOperation").addEventListener("click",()=>{
		let nav=document.getElementById("navMainMenu");
		if(nav.style.width=="25px"){
			nav.style.width="150px";
			let arrays=nav.querySelectorAll("nav>h1,nav>ul");
			arrays.forEach((item)=>{
				item.hidden=false;
			});	
			document.getElementById("showAndHiddenOperation").classList.add("trans");
		}else{
			nav.style.width="25px";
			let arrays=nav.querySelectorAll("nav>h1,nav>ul");
			arrays.forEach((item)=>{
				item.hidden=true;
			});	
			document.getElementById("showAndHiddenOperation").classList.remove("trans");
		}

	},false);
}
window.addEventListener("load",init,false);
