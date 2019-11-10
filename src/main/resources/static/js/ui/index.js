var indexUi = (function () {

	var startTime;
	var pause;
	var standardmessageAsBits;
	var messageAsMiliSeconds = [];
	var writingButtonTemplate = "<span class='spinner-grow spinner - grow - sm' role='status' aria-hidden='true'></span> Escribiendo"
	var isTheFirstMessage = true;

	function eventListener() {
		$(".write-button").mousedown(start);
		$(".write-button").mouseup(stop);
		$(".start-button").click(startMessage);
		$(".send-button").click(send);
	}

	function start() {
		var now = new Date();
		messageAsMiliSeconds.push(now - pause);
		startTime = new Date();

		$(".message-text-area").text("000");
	}

	function stop() {
		var now = new Date();
		messageAsMiliSeconds.push(now - startTime);
		pause = new Date();
	}

	function startMessage() {
		pause = new Date();
		changeStartButtonByLoader();
		$(".write-button").prop("disabled", false);
	}

	function changeStartButtonByLoader() {
		$(".start-button").empty().prop("disabled", true).append(writingButtonTemplate);
	}

	function send() {
		stop();
		alert(messageAsMiliSeconds);
		var message = convertToBit();
		if (isTheFirstMessage) {
			standardmessageAsBits = message;
			isTheFirstMessage = false;
			console.log(standardmessageAsBits);
			$(".first-message-info").text("Ya puedes enviar tu mensaje!");
		} else {
			morseTransalatorConnector.send(message, standardmessageAsBits);
		}

		messageAsMiliSeconds = [];
		changeToOriginalStartButton();
		$(".write-button").prop("disabled", true);
	}

	function changeToOriginalStartButton() {
		$(".start-button").prop("disabled", false).text("Comenzar");
	}

	function convertToBit() {
		var message = "";
		for (let index = 0; index < messageAsMiliSeconds.length; index++) {
			var time = messageAsMiliSeconds[index] / 10;
			var characterToConcat = index % 2 == 0 ? "0" : "1";
			message = add(time, characterToConcat, message);
		}
		return message;
	}

	function add(amount, value, message) {
		var bitToConcat = value.repeat(amount);
		return message.concat(bitToConcat);
	}
	return {
		eventListener: eventListener
	};
})();

$(document).ready(function () {
	indexUi.eventListener();
});