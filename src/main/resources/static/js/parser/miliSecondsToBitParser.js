var miliSecondsToBitParser = (function () {

	function convertToBit(messageAsMiliSeconds) {
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
		convertToBit: convertToBit
	};
})();