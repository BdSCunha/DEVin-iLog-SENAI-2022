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

localStorage.setItem('playlistOnLocalStorage', JSON.stringify(playlist))

playlistFromLocalStorage = JSON.parse(localStorage.getItem('playlistOnLocalStorage'))
const table = document.getElementById("playlistTable")

playlistFromLocalStorage.forEach(element => {
    const row = table.insertRow()
    const nomeCell = row.insertCell()
    const cantorCell = row.insertCell()
    nomeCell.innerHTML = element.nome
    cantorCell.innerHTML = element.cantor
})

localStorage.clear()
