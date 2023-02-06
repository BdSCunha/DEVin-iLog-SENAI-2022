var timer = 30;

var intervalId = setInterval(
    function() {
        timer--
        n = document.getElementById("progress-bar")
        n.style.width = `${(timer*3.333333333333333)}%`
        n.innerText = timer

        if (timer === 0) clearInterval(intervalId)
    },
    1000
)