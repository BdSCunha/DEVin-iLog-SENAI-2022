const playlist = [
    {
        nome: "Listen to your heart",
        cantor: "Roxette"
    },
    {
        nome: "Bloody Mary",
        cantor: "Lady Gaga"
    },
    {
        nome: "Bones",
        cantor: "Imagine Dragons"
    },
    {
        nome: "Sugar honey ice and tea",
        cantor: "Bring me the horizon"
    },
    {
        nome: "Rock you like a hurricane",
        cantor: "Scorpions"
    },
    {
        nome: "Pure/Honey",
        cantor: "Beyoncé"
    },
]

function localStorageToTable() {
    // Creates a new table and sets the table ID to "playlistTable"
    const table = document.createElement("table")
    table.id = "playlistTable"

    // Creates the table header with the labels "Nome", "Cantor" and "Ação" and append it to the "table-placeholder" div
    const header = table.createTHead()
    const row = header.insertRow()
    row.insertCell().outerHTML = "<th>Nome</th>"
    row.insertCell().outerHTML = "<th>Cantor</th>"
    row.insertCell().outerHTML = "<th>Ação</th>"
    document.getElementById("table-placeholder").appendChild(table)

    // Creates the body of the table for inserting the data
    const body = table.createTBody()

    // Fetches playlist data from local storage
    const playlistFromLocalStorage = JSON.parse(localStorage.getItem("playlistOnLocalStorage")) || []

    // Populates the body of the table with the playlist data and with the buttons
    playlistFromLocalStorage.forEach(element => {
        const row = body.insertRow()
        row.insertCell().innerHTML = element.nome
        row.insertCell().innerHTML = element.cantor

        const buttonCell = row.insertCell()
        const btn = document.createElement("button")
        btn.type = "submit"
        btn.innerHTML = "Excluir"
        btn.onclick = function() {
            excluir(element)
        }
        buttonCell.appendChild(btn)
    })
}

function excluir(element) {
    if (confirm(`Deseja realmente excluir a música "${element.nome}" de ${element.cantor}?`)) {
        playlistFromLocalStorage = JSON.parse(localStorage.getItem("playlistOnLocalStorage")) || []

        playlistFromLocalStorage = playlistFromLocalStorage.filter(item => JSON.stringify(item) !== JSON.stringify({nome: element.nome, cantor: element.cantor}))

        localStorage.setItem("playlistOnLocalStorage", JSON.stringify(playlistFromLocalStorage))

        var removeTab = document.getElementById("playlistTable")

        var parentEl = removeTab.parentElement

        parentEl.removeChild(removeTab)

        localStorageToTable()
    }
}

// https://developer.mozilla.org/en-US/docs/Web/API/Window/load_event
// The load event is fired when the whole page has loaded, including all dependent resources such as stylesheets, scripts, iframes, and images.
window.onload = () => {
    localStorage.setItem("playlistOnLocalStorage", JSON.stringify(playlist))
    localStorageToTable()
}
