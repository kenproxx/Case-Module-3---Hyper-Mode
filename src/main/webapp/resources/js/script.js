function sendMsg() {
    let msg = document.getElementById("msg").value;
    let date = new Date();
    let day = "AM"
    let minutes = date.getMinutes()
    if (date.getHours() >= 12) {
        day = "PM"
    }
    if (minutes < 10) {
        minutes = "0" + date.getMinutes();
    }
    let curTime = date.getHours() + ":" + minutes + " " + day

    if (msg) {

        let mySpan = document.getElementById("chat");

        let str = " <li class=\"left clearfix\">\n" +
            "                     <span class=\"chat-img1 pull-right\">\n" +
            "                     <img src=\"https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg\" alt=\"User Avatar\" class=\"img-circle\">\n" +
            "                     </span>\n" +
            "                     <div class=\"chat-body1 clearfix\">\n" +
            "                        <p>" + msg + "</p>\n" +
            "\t\t\t\t\t\t<div class=\"chat_time pull-right\">" + curTime + "</div>\n" +
            "                     </div>\n" +
            "                  </li>";
        mySpan.innerHTML += str + "<br/>";

    }
    document.getElementById("msg").value = "";
}


function test() {
    let msg = "hihi"
    let date = new Date();
    let day = "AM"
    let minutes = date.getMinutes()
    if (date.getHours() >= 12) {
        day = "PM"
    }
    if (minutes < 10) {
        minutes = "0" + date.getMinutes();
    }
    let curTime = date.getHours() + ":" + minutes + " " + day

    if (msg) {

        let mySpan = document.getElementById("chat");

        let str = " <li class=\"left clearfix\">\n" +
            "                     <span class=\"chat-img1 pull-left\">\n" +
            "                     <img src=\"https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg\" alt=\"User Avatar\" class=\"img-circle\">\n" +
            "                     </span>\n" +
            "                     <div class=\"chat-body1 clearfix\">\n" +
            "                        <p>" + msg + "</p>\n" +
            "\t\t\t\t\t\t<div class=\"chat_time pull-right\">" + curTime + "</div>\n" +
            "                     </div>\n" +
            "                  </li>";
        mySpan.innerHTML += str + "<br/>";

    }
}

setInterval(test, 3000)


const messages = document.getElementById('chat');

function appendMessage() {
    const message = document.getElementsByClassName('chat')[0];
    const newMessage = message.cloneNode(true);
    messages.appendChild(newMessage);
}

function getMessages() {

    appendMessage();
    if (!shouldScroll) {
        scrollToBottom();
    }
}

function scrollToBottom() {
    messages.scrollTop = messages.scrollHeight;
}

