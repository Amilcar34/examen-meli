var morseTransalatorConnector = (function () {
    function sendMessage(message, standardMessage) {
        var message = {};
        message.message = message;
        message.standardMessage = standardMessage;
        console.log("Envie el mensaje");
        // return $.ajax({
        //     contentType: 'application/json; charset=UTF-8',
        //     url: url,
        //     type: 'POST',
        //     data: JSON.stringify(message)
        // });
    }

    return {
        send: sendMessage
    }
})();