function changeDivColor() {
    const chosenColor = document.getElementById("color-picker")
    const coloredDiv = document.getElementById("colored-div")
    coloredDiv.style.background = chosenColor.value
}