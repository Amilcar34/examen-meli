var indexUi = (function () {

	var startTime;
	var message = new Message();
	var pause;
	var messageAsMiliSeconds = [];
	var writingButtonTemplate = "<span class='spinner-grow spinner - grow - sm' role='status' aria-hidden='true'></span> Escribiendo"
	var isTheFirstMessage = true;

	function eventListener() {
		$(".write-button").on("mousedown touchstart", start);
		$(".write-button").on("mouseup touchend", stop);
		$(".start-button").click(startMessage);
		$(".send-button").click(send);
		$(".send-button").on(send);
	}

	function startMessage() {
		pause = new Date();
		changeStartButtonByLoader();
		$(".write-button").prop("disabled", false);
		$(".message-text-area").text("");
	}

	function changeStartButtonByLoader() {
		$(".start-button").empty().prop("disabled", true).append(writingButtonTemplate);
	}

	function start() {
		var now = new Date();
		messageAsMiliSeconds.push(now - pause);
		startTime = new Date();
	}

	function stop() {
		var now = new Date();
		messageAsMiliSeconds.push(now - startTime);
		pause = new Date();
	}

	function send() {
		stop();
		var messageConverted = miliSecondsToBitParser.convertToBit(messageAsMiliSeconds);

		if (isTheFirstMessage) {
			message.bitMessage.standardMessage = messageConverted;
			isTheFirstMessage = false;
			$(".first-message-info").text("Ya puedes enviar tu mensaje!");
		} else {
			message.bitMessage.message = messageConverted;
			$(".message-text-area").text(messageConverted);
			message.from = $(".sender-name").text();
			message.recipient = $(".recipient-name").val();
			morseTransalatorConnector.send(message)
				.done(successMessage);
		}

		messageAsMiliSeconds = [];
		changeToOriginalStartButton();
		$(".write-button").prop("disabled", true);
	}

	function successMessage(response) {
		if (isMobile()) {
			alert("El mensaje enviado fue: " + response);
		} else {
			$('.toast-body').text("El mensaje enviado fue: " + response);
			$('.toast').toast('show');
		}
	}

	function isMobile() {
		if (navigator.userAgent.match(/Android/i) ||
			navigator.userAgent.match(/webOS/i) ||
			navigator.userAgent.match(/iPhone/i) ||
			navigator.userAgent.match(/iPad/i) ||
			navigator.userAgent.match(/iPod/i) ||
			navigator.userAgent.match(/BlackBerry/i) ||
			navigator.userAgent.match(/Windows Phone/i)
		) {
			return true;
		} else {
			return false;
		}
	}

	function changeToOriginalStartButton() {
		$(".start-button").prop("disabled", false).text("Comenzar");
	}

	return {
		eventListener: eventListener
	};
})();

$(document).ready(function () {
	indexUi.eventListener();
});