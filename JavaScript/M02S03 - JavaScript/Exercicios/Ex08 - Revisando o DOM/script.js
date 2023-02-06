function saveMessage() {
    const message = document.getElementById("message").value
    if (message.lenght == 0 || message === null || message ==="" || message.trim() === "") {
        alert("Mensagem vazia!\nDigite alguma coisa para salvar...")
    } else {
        localStorage.setItem("savedMessage", JSON.stringify(message.trim()))
        showSavedMessage()
    }
}

function showSavedMessage() {
    const message = JSON.parse(localStorage.getItem("savedMessage"))

    const messageplaceholder = document.getElementById("message-placeholder")

    messageplaceholder.innerHTML = `Mensagem salva: `

    if (message === null || message ==="") {
        messageplaceholder.innerHTML += `<em>não há mensagem salva!</em>`
        messageplaceholder.style.textDecoration = "line-through"
        alert("Não há mensagem salva!")
    } else {
        messageplaceholder.style.textDecoration = "none"
        messageplaceholder.innerHTML += `${message}`
    }
}

window.onload = (element) => {
    showSavedMessage()
}