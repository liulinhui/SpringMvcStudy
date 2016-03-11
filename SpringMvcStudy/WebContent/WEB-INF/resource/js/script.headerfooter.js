$(function() {

	$("#float-bar .back-top").click(function() {
		$('html,body').animate({
			'scrollTop' : '0'
		})
	})

	$("#float-bar").mouseenter(function() {
		if ($(this).hasClass('opened')) {
			$(this).removeClass('opened');
			$('#float-bar').animate({
				'right' : '-77px'
			});
		} else {
			$(this).addClass('opened');
			$('#float-bar').animate({
				'right' : '0'
			});
		}
	})

	$("#float-bar").mouseleave(function() {
		if ($(this).hasClass('opened')) {
			$(this).removeClass('opened');
			$('#float-bar').stop(true, false).animate({
				'right' : '-77px'
			});
		} else {
			$(this).addClass('opened');
			$('#float-bar').animate({
				'right' : '0'
			});
		}
	})

	$("a.qr-btn").hover(function() {
		var rel = $(this).attr('rel');
		$('#' + rel).stop(true, false).fadeIn();
	}, function() {
		var rel = $(this).attr('rel');
		$('#' + rel).stop(true, false).fadeOut();
	})

	$('#footer-nf .f-select').click(function(e) {
		if ($(this).hasClass('opened')) {
			$(this).find('.links-box').slideUp();
			$(this).removeClass('opened')
		} else {
			$(this).find('.links-box').slideDown();
			$(this).addClass('opened')
		}
		e.stopPropagation();
	});
	$('#footer-nf').click(function() {
		var fSelect = $(this).find('.f-select');
		if (fSelect.hasClass('opened')) {
			fSelect.find('.links-box').slideUp();
			fSelect.removeClass('opened')
		}
	});

	$('.h-search #s-input').keydown(function() {
		$('.h-search #s-result').addClass('opened').fadeIn();
	})
	$('.h-search').mouseleave(function() {
		if ($('.h-search #s-result').hasClass('opened')) {
			$('.h-search #s-result').removeClass('opened').fadeOut();
		}
		;
	})
})