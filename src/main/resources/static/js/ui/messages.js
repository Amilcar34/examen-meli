var messagesUi = (function () {

    function eventListener() {
        $(".contacto").click(showMessages);
    }

    function showMessages() {
        var idContacto = $(this).attr("data-id-contacto");
        $(".mensajes").removeClass("active");
        $("#" + idContacto).removeClass("fade").addClass("active");
    }

    return {
        eventListener: eventListener
    };
})();

$(document).ready(function () {
    messagesUi.eventListener();
});