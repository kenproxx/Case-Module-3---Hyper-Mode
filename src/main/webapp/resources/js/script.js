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
    getMessages();
}


//chat ngẫu nhiên
let str1 = "Xin chào các bạn"
let str2 = "hi"
let str3 = "Có ai ở đây không ạ"
let str4 = "mình buồn quá"
let str5 = "muốn tìm người yêu"
let str6 = "yêu màu hồng, ghét sự giả dối"
let str7 = "tìm người nói chuyện"
let str8 = "mãi mãi 1 tình yêu"
let str9 = "boy nhà nghèo tìm girl nhà giàu"
let str10 = "anh muốn ăn kem, vì anh muốn có em"
let str11 = "ví em là rác, vì anh muốn đổ em"
let str12 = "anh muốn là viên đá, vì trong đá có Ngọc"
let str13 = "anh yêu màu hường, và anh yêu cả Hường"
let str14 = "vì anh Thương em, như thương cây bàng non"
let str15 = "Bích 50k, đình thôn 21h"
let str16 = "muốn nghe hát hay, hãy tìm Vũ Linh"
let str17 = "Học hành chán vler"
let str18 = "khi bắt đầu, đừng nghe thằng nào nói cả"
let str19 = "khi bắt đầu, hãy nghĩ tới thất bại"
let str20 = "khi bắt đầu, đừng nghĩ tới thất bại"



function test() {
    let arr = [str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20];
    let random = Math.floor(Math.random() * 20) + 1;
    let msg = arr[random];

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
    getMessages();
}

setInterval(test, 3000)


const messages = document.getElementById('chat');

function appendMessage() {
    const message = document.getElementsByClassName('chat-sm')[0];
    const newMessage = message.cloneNode(true);
    messages.appendChild(newMessage);
}

function getMessages() {
    shouldScroll = messages.scrollTop + messages.clientHeight === messages.scrollHeight;

    appendMessage();
    if (!shouldScroll) {
        scrollToBottom();
    }
}

function scrollToBottom() {
    messages.scrollTop = messages.scrollHeight;
}



