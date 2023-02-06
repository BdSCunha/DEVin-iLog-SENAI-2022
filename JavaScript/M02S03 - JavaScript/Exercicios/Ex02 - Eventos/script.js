function sumNumbers() {
    let num1 = parseFloat(document.getElementById("num1").value.replace(",", "."))
    if (isNaN(num1)) num1 = 0

    let num2 = parseFloat(document.getElementById("num2").value.replace(",", "."))
    if (isNaN(num2)) num2 = 0

    const sum = num1 + num2

    const result = document.getElementById("result")
    result.innerHTML = "Resultado: " + sum.toLocaleString("pt-br") // same as `sum.toString().replace(".", ",")`
}

function subtractNumbers() {
    let num1 = parseFloat(document.getElementById("num1").value.replace(",", "."))
    if (isNaN(num1)) num1 = 0

    let num2 = parseFloat(document.getElementById("num2").value.replace(",", "."))
    if (isNaN(num2)) num2 = 0

    const sub = num1 - num2

    const result = document.getElementById("result")
    result.innerHTML = "Resultado: " + sub.toLocaleString("pt-br") // same as `sum.toString().replace(".", ",")`
}
