$('input[type=text]').hide();
$('.type-radio-btn').hide();
$('.type-label').hide();

$('.radio-btn').click(function () {
	if ($('#username').is(':checked') || $('#name').is(':checked') || $('#status').is(':checked')) {
		$('.type-radio-btn').hide();
		$('.type-radio-btn').removeAttr('name');
		$('.type-radio-btn').removeAttr('required');
		$('.type-label').hide();
		$('input[type=text]').attr('name', 'value');
		$('input[type=text]').attr('required', true);
		$('input[type=text]').show();
	} else {
		$('input[type=text]').hide();
		$('input[type=text]').removeAttr('name');
		$('input[type=text]').removeAttr('required');
		$('.type-radio-btn').attr('name', 'value');
		$('.type-radio-btn').attr('required', true);
		$('.type-radio-btn').show();
		$('.type-label').show();
	}
});
		
$('input[type=text]').css('margin-top', '20px');
$('input[type=text]').css('margin-bottom', '0');