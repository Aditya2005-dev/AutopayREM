document.getElementById("reminderForm").addEventListener("submit", function(event){

    event.preventDefault();

    const reminder = {

        serviceId: document.getElementById("uid").value,

        serviceName: document.getElementById("ser").value,

        amount: document.getElementById("amt").value,

        dueDateTime: document.getElementById("dd").value

    };

    fetch("http://localhost:8080/set", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(reminder)

    })

    .then(response => response.json())

    .then(data => {

        alert("Reminder Saved Successfully!");

        startTimer(data.dueDateTime);

    })

    .catch(error => {

        console.log(error);

    });

});


function startTimer(dueDateTime){

    const due = new Date(dueDateTime);

    const timer = setInterval(function(){

        const now = new Date();

        const diff = due - now;

        if(diff <= 0){

            document.getElementById("timer").innerHTML = "Expired";

            clearInterval(timer);

            return;
        }

        const days = Math.floor(diff / (1000 * 60 * 60 * 24));

        const hours = Math.floor((diff / (1000 * 60 * 60)) % 24);

        const minutes = Math.floor((diff / (1000 * 60)) % 60);

        const seconds = Math.floor((diff / 1000) % 60);

        document.getElementById("timer").innerHTML =
        days + " Days " +
        hours + " Hours " +
        minutes + " Minutes " +
        seconds + " Seconds";

    },1000);

}