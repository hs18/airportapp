(function($){
	
	$.support.fullscreen = supportFullScreen();
	
	$.fn.fullScreen = function(props){
		
		if(!$.support.fullscreen || this.length != 1){
			return this;
		}
		
		if(fullScreenStatus()){
			// if we are already in fullscreen, exit
			cancelFullScreen();
			return this;
		}
		
		var options = $.extend({
			'background' : '#111',
			'callback'	 : function(){}
		}, props);
		
		var fs = $('<div>',{
			'css' : {
				'overflow-y' : 'auto',
				'background' : options.background,
				'width'		 : '100%',
				'height'	 : '100%'
			}
		});

		var elem = this;

		elem.addClass('fullScreen');
		fs.insertBefore(elem);
		fs.append(elem);
		requestFullScreen(fs.get(0));
		
		fs.click(function(e){
			if(e.target == this){
				// Clicking the black bar will close the full screen
				cancelFullScreen();
			}
		});
		
		elem.cancel = function(){
			cancelFullScreen();
			return elem;
		};
		
		onFullScreenEvent(function(fullScreen){
			if(!fullScreen){
				// Exiting full screen
				elem.removeClass('fullScreen').insertBefore(fs);
				fs.remove();
			}
			
			// Calling the user supplied callback
			options.callback(fullScreen);
		});
		
		return elem;
	};
	
	

	function supportFullScreen(){
		var doc = document.documentElement;
		
		return	('requestFullscreen' in doc) ||
				('mozRequestFullScreen' in doc) ||
				('webkitRequestFullScreen' in doc);
	}

	function requestFullScreen(elem){

		if (elem.requestFullscreen) {
		    elem.requestFullscreen();
		}
		else if (elem.mozRequestFullScreen) {
		    elem.mozRequestFullScreen();
		}
		else if (elem.webkitRequestFullScreen) {
		    elem.webkitRequestFullScreen();
		}
	}

	function fullScreenStatus(){
		return	document.fullscreen ||
				document.mozFullScreen ||
				document.webkitIsFullScreen;
	}
	
	function cancelFullScreen(){
		if (document.exitFullscreen) {
		    document.exitFullscreen();
		}
		else if (document.mozCancelFullScreen) {
		    document.mozCancelFullScreen();
		}
		else if (document.webkitCancelFullScreen) {
		    document.webkitCancelFullScreen();
		}
	}

	function onFullScreenEvent(callback){
		$(document).on("fullscreenchange mozfullscreenchange webkitfullscreenchange", function(){
			callback(fullScreenStatus());
		});
	}

})(jQuery);