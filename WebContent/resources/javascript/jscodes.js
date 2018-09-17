function closeDialogIfSucess(xhr, status, args, dialogWidget, dialogId) {
	if (args.validationFailed || args.KEEP_DIALOG_OPENED) {
		jQuery('#'+dialogId).effect("bounce", {times : 4, distance : 20}, 100);
	} else {
		dialogWidget.hide();
	}
}

function handleLoginResult(xhr, status, args, dialogWidget, dialogId) {
	if(args.validationFailed || args.KEEP_DIALOG_OPENED) {
		console.log('failed');
		console.log(jQuery('#'+dialogId).effect("shake", {times:5}, 100));
	}else{
		window.location.href = "/SecJSFApp/pages/protected/index.xhtml";
	}
}