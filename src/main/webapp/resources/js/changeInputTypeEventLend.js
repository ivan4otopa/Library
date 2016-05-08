$('input[type=text]').hide();
$('input[type=date]').hide();

$('.radio-btn').click(function () {
	if ($('#bookId').is(':checked') || $('#clientName').is(':checked')) {
		$('input[type=date]').hide();
		$('input[type=date]').removeAttr('name');
		$('input[type=date]').removeAttr('required');
		$('input[type=text]').attr('name', 'value');
		$('input[type=text]').attr('required', true);
		$('input[type=text]').show();
	} else {
		$('input[type=text]').hide();
		$('input[type=text]').removeAttr('name');
		$('input[type=text]').removeAttr('required');
		$('input[type=date]').attr('name', 'value');
		$('input[type=date]').attr('required', true);
		$('input[type=date]').show();
	}
});
		
$('input[type=text]').css('margin-top', '20px');
$('input[type=text]').css('margin-bottom', '0');