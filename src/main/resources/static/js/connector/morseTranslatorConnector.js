var morseTransalatorConnector = (function () {
    var url = window.location.origin + "/api";

    function sendMessage(message) {

        return $.ajax({
            contentType: 'application/json; charset=UTF-8',
            url: url + "/send",
            type: 'POST',
            data: JSON.stringify(message)
        });
    }

    return {
        send: sendMessage
    }
})();