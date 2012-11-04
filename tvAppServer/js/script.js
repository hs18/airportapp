


jQuery(document).ready(function($) {

			//
			//var e = document.getElementById('fullscreen');
			//e.mozRequestFullScreen();
			
			// Hide/Show
			$('#slide').hide();
			$('#content').hide(); // temporary
			$('#new').hide();
			$('.progress.product-in-update').hide();
			
			// Extract URL
			var rank = 1,align = 0,product_code = false ;
			if(window.location.href.indexOf('?') != -1){
				var parts = window.location.href.split('?')[1].split('&') ;
			
				if(parts && parts.length >0){
					// decide rank and information layout as per passed parameters
					rank = (parts[0] && (parts[0].split('=')[0] == 'rank')) ? parts[0].split('=')[1] : rank ;
					align =   (parts[1] && (parts[1].split('=')[0] == 'align')) ? parts[1].split('=')[1] : align ;
				}
			}
			align = ( align == 1 || align == 'bottom' ) ? 'bottom' : 'top' ;
			
			// Layout adjustments
			if(align == 'bottom'){
				$('#info').removeClass('top').addClass('bottom');
				// Contact should appear on the top of QR image
				var contact_clone = $('.action.contact').clone();
				$('.action.contact').remove();
				contact_clone.prependTo('.meta.right');	
				
			}
			$('.prd-meta').addClass(align);
			
			// Make Product request
			var rank_id = rank ;
			
			var rank_endpoint = 'http://192.168.16.9:8080/hsnAirportAppServer/airportproducts/product/rankid/';
			var oss_endpoint = 'http://192.168.16.9:8080/hsnAirportAppServer/airportproducts/product/osschecker/rankid/';
			/* var rank_endpoint = 'http://localhost/mirror/?method=getdata&product=';
			var oss_endpoint = 'http://localhost/mirror/?method=checkoss&product='; */
			var new_data ;
			
			
			var getRankEndpoint = function(id){
				return rank_endpoint + id + '?callback=?'; // to allow JSONP requests
			}
			var isProductOutOfStock = function(id){
				var oss_req = oss_endpoint + id ;
				$.ajax({
				type: 'GET',
				url: oss_req,
				async: false,
				jsonpCallback: 'getData',
				contentType: "application/json",
				dataType: 'jsonp',
				success: function(json_data) {
					  if(json_data.productOOS == true){
						  new_data = json_data.nextProduct ;
						  if( product_code != new_data.productCode ){
							$('.progress.product-in-update').fadeIn();
							setTimeout(function(){initSlides(new_data);},3600);  
						  }
					  }else{
						  //alert(json_data.productInventoryAvailable + ' items available in stock ');
					  }		
				},
				error: function(e) {
					console.log(e.message);
				}
				});
			}
			
			// Checks OSS periodically
			var periodicCheckOSS = function(){
				setInterval(function(){ 
					isProductOutOfStock(rank_id);
				},36000);
			};
			
			// re-arrange UI components
			var rearrangeUI = function(){
				 // adjust contact component height
                 if($('#info.top').length > 0){
					var top_contact = $('#info.top .action.qr').position().top + $('#info.top .action.qr').height() + 25 ;
					$('#info.top .action.contact').css({
						top: top_contact + "px"
					});
				}else{
					var bottom_contact = $('#info.bottom .action.qr').position().top - $('#info.bottom .action.contact').height() - 25 ;
					//alert(bottom_contact);
					$('#info.bottom .action.contact').css({
						top : bottom_contact + "px"
					});
				}
				
				// adjust QR
				$('.qr-wrapper').css({
						width: $('.qr canvas').width() + 30 + +'px',
						marginLeft : ($('.action.qr').width() - $('.qr-wrapper').width())/2 + 'px'
				 });			  
			};

			
			
			
			//$.getJSON(getRankEndpoint(1),{},function(d){},function(d){});
			$.ajax({
				type: 'GET',
				url: getRankEndpoint(rank_id),
				async: false,
				jsonpCallback: 'getData',
				contentType: "application/json",
				dataType: 'jsonp',
				success: function(json_data) {
					  //data = JSON.stringify(json_data);
					  initSlides(json_data);
					
				},
				error: function(e) {
					console.log(e.message);
				}
			});
			
			
		 // Initialize/Re-initialize product slides
		 function initSlides(data){
		
		     // Set a timer for periodically checking products stock status
			 periodicCheckOSS();
			 
			 
			 product_code = data.productCode ;
				
			 
			 // update slide data
			 $('.prd-detail .name').text(data.productTitle);
			 $('.prd-detail .code').text(data.productCode);
			 if($.trim(data.keyFeature) == '' || data.keyFeature == null){
				 $('.prd-detail .spec').remove();
				 $('.prd-detail h3').addClass('middle');
			 }else{
				 if($('.prd-detail .spec').length == 0){ $('.prd-detail').append('<p class="spec"></p>'); } 
				 if($('.prd-detail h3').hasClass('middle')){ $('.prd-detail h3').removeClass('middle') } 
				 $('.prd-detail .spec').text(data.keyFeature);
			 }
			 
			 if(data.logoUrl){
			 $('img.logo').attr('src',data.logoUrl).on('load',function(){
				 var logo_w_height = $('.logo-wrapper').height();			 
				 var logo_height = $('img.logo').height();
				 $(this).css('marginTop',(logo_w_height - logo_height)/2);
			 });
			 if($('.logo-wrapper').is(':hidden')){$('.logo-wrapper').show();}
			}else{
				$('.logo-wrapper').hide();
			}
			 $('.content .qr').text('');
			 $('.content .qr').qrcode(data.barCodeImage);
			 $('.content .qr').find('canvas').addClass('qr-canvas');
			 //$('img.qr').attr('src',data.barCodeImage);
			 $('.contact .content').text(data.tollFreeNumber);
			 $('.cost.retail').text(data.mrp);
			 $('.cost.hs18').text(data.hs18Price);
			 
			 
			 // 2nd Iteration : Product have gone out of stock
			 if($('ul.bjqs li.bjqs-slide').length >0){ 
				 //$('#prd-slider').hide();
				 $('.progress.product-in-update').fadeOut();
				 $('#new').show().addClass('animated bounceInDown');
				 $('ul.bjqs').text(''); 
			 }
			 // Populate slides with images/ create slides
			 $.each(data.imageUrl,function(i,v){
				 $('ul.bjqs').append('<li><img src="'+v+'"/></li>');
			 });
			 
			 // Hard-coded HTML5 video playback component ( if video is avaialble in fetched data set ) 
			 if(data.videoUrl){
				 $('ul.bjqs').append('<li>'+
					'<video id="video_1" class="video-js vjs-default-skin" controls preload="none" width="'+$(window).width()+'" height="'+$(window).height()+'" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">'+
					'<source src="http://video-js.zencoder.com/oceans-clip.mp4" type="video/mp4" />' +
					'<source src="http://video-js.zencoder.com/oceans-clip.webm" type="video/webm" />' +
					'<source src="http://video-js.zencoder.com/oceans-clip.ogv" type="video/ogg" />' +
					'<track kind="captions" src="./media/captions.vtt" srclang="en" label="English" />' +
					'</video></li>');
			 }
			 // Adjust page elements
			 $('#welcome').fadeOut();
			 $('#slide').show();
			 $('#content').show();
			 $('video').attr("width", $(window).width()).attr("height",$(window).height());
			 // Initialize slides
			 $('#product-list').bjqs({
				height      : $(window).height(),
				width       : $(window).width(),
				showcontrols : false,
				responsive  : true
			 });
			 rearrangeUI();
			 $('body').fullScreen();	 
		 } 

			 
			 // Re-initialize slides on window resize
			 $(window).resize(function(){
				 rearrangeUI();
				 // video resize
				 $('video').attr("width", $(window).width()).attr("height",$(window).height());
				 // Adjust logo
				 var logo_w_height = $('.logo-wrapper').height();			 
				 var logo_height = $('img.logo').height();
				 $('img.logo').css('marginTop',(logo_w_height - logo_height)/2);
				 
				 $('#product-list').bjqs({
					height      : $(window).height(),
					width       : $(window).width(),
					showcontrols : false,
					responsive  : true
				});
				
			 });
		 
		    
        });

