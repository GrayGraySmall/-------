(function() {
	var Sidebar = function(eId) {
		this.state = 'opened';
		this.el = document.getElementById(eId || 'sidebar');
		var self=this;
		this.el.addEventListener('click', function(event) {
			if(event.target !== self.el) {
				self.triggerSwitch();
			}
		});
	};
	Sidebar.prototype.close = function() {
		console.log('关闭sidebar');
		this.state='closed';
	};
	Sidebar.prototype.open = function() {
		console.log('打开sidebar');
		this.state='opened';
	};
	Sidebar.prototype.triggerSwitch = function() {
		if(this.state === 'opened') {
			this.close();
		}else{
			this.open();
		}
	};
	var sidebar=new Sidebar();
})();