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

const table = document.getElementById("playlistTable")

for (const song of playlist) {
    const row = table.insertRow()
    const nomeCell = row.insertCell()
    const cantorCell = row.insertCell()
    nomeCell.innerHTML = song.nome
    cantorCell.innerHTML = song.cantor
}

// let result = `<table><tr><th>Nome</th><th>Cantor</th></tr>`
// for (const song of playlist) result += `<tr><td>${song.nome}</td><td>${song.cantor}</td></tr>`
// result += "</table>"
// document.getElementById("playlistTable").innerHTML = result
