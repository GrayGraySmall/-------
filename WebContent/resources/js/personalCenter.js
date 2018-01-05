window.onload = function() {
	var myIframe = document.getElementById("information_iframe");
	var btn_myPro = document.getElementById("btn_myPro");
	var btn_myPet = document.getElementById("btn_myPet");
	var btn_myPurchase = document.getElementById("btn_myPurchase");

	btn_myPro.onclick = function() {
		myIframe.src = "myPro_iframe.html";
		$("#btn_myPro").removeClass("active");
		$("#btn_myPet").removeClass("active");
		$("#btn_myPurchase").removeClass("active");
		$("#btn_myPro").addClass("active");
		changeHeight();
	}

	btn_myPet.onclick = function() {
		myIframe.src = "myPet_iframe.html";
		$("#btn_myPro").removeClass("active");
		$("#btn_myPet").removeClass("active");
		$("#btn_myPurchase").removeClass("active");
		$("#btn_myPet").addClass("active");
		changeHeight();
	}

	btn_myPurchase.onclick = function() {
		myIframe.src = "myPurchase.html";
		$("#btn_myPro").removeClass("active");
		$("#btn_myPet").removeClass("active");
		$("#btn_myPurchase").removeClass("active");
		$("#btn_myPurchase").addClass("active");
		changeHeight();
	}
	
	function changeHeight(){
		myIframe.height=myIframe.contentWindow.document.body.offsetHeight;
	}
}

