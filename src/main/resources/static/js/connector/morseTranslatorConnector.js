var morseTransalatorConnector = (function () {
    var url = window.location.origin + "/api";

    function sendMessage(message, standardMessage) {
        var bodyMessage = {};
        bodyMessage.message = message;
        bodyMessage.standardMessage = standardMessage;
        console.log("Envie el mensaje");

        return $.ajax({
            contentType: 'application/json; charset=UTF-8',
            url: url + "/transalte2HumaFromBits",
            type: 'POST',
            data: JSON.stringify(bodyMessage)
        });
    }

    return {
        send: sendMessage
    }
})();