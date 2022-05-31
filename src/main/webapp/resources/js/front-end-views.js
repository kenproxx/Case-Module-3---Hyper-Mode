function showTotal() {
    let price = document.getElementById("productPrice").value;
    console.log(price);
    let quantity = document.getElementById("quantity").value;
    console.log(quantity);
    let total = price * quantity;
    console.log(total);
    document.getElementById("total").innerHTML = total.toString();
}

function searching() {

}

function like() {

}
function sendMsg() {
    let msg = document.getElementById("msg").value;
    if (msg) {

        let mySpan = document.getElementById("chat");
        mySpan.innerHTML += msg+ "<br/>";

    }
    document.getElementById("msg").value = "";
}

function autoChat() {
    let str = "<li class=\"left clearfix\">\n" +
        "                     <span class=\"chat-img1 pull-left\">\n" +
        "                     <img src=\"https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg\" alt=\"User Avatar\" class=\"img-circle\">\n" +
        "                     </span>\n" +
        "                                <div class=\"chat-body1 clearfix\">\n" +
        "                                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</p>\n" +
        "                                    <div class=\"chat_time pull-right\">09:40PM</div>\n" +
        "                                </div>\n" +
        "                            </li>"
    let chat = document.getElementById("chat");
    chat.innerHTML += str;
}
setTimeout(autoChat,500)