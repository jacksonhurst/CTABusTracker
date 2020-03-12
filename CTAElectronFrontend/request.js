var interval

function repeatRequest(requestStpid) {
    makeRequest(requestStpid);
    interval = setInterval(makeRequest, 10000, requestStpid);
}

function clearBusInterval() {
    clearInterval(interval);
}

function makeRequest(rqStpid) {

    var xmlHttp = new XMLHttpRequest();

    url = 'http://localhost:8080/track-bus?stpid=' + rqStpid;

    xmlHttp.open("GET", url, true); // false for synchronous request
    xmlHttp.onload = function () {
        var jsonResponse = JSON.parse(xmlHttp.responseText);

        // Create the list element:
        var list = document.getElementById('list');

        while (list.firstChild) {
            list.removeChild(list.firstChild);
        }

        jsonResponse.forEach(element => {
            var bus = document.createElement('div');
            bus.setAttribute("id", "bus");

            var left = document.createElement('div');
            left.setAttribute("id", "left");

            var right = document.createElement('div');
            right.setAttribute("id", "right");

            //Create bus name div
            var vehicleId = document.createElement('div');
            vehicleId.setAttribute("id", "vehicleId");

            vehicleId.appendChild(document.createTextNode("Bus #" + element.vehicleId + " to"));

            //Create predicted time div
            var predictedTime = document.createElement('div');
            predictedTime.setAttribute("id", "predictedTime");

            if (element.predictedTime == "DUE") {
                predictedTime.appendChild(document.createTextNode(element.predictedTime))
            } else {
                predictedTime.appendChild(document.createTextNode(element.predictedTime + " min"))
            }

            //Create destination div
            var destination = document.createElement('div');
            destination.setAttribute("id", "destination");

            destination.appendChild(document.createTextNode(element.destination));

            // Add all of these divs to the bus div
            console.log("Adding to left: " + element.vehicleId + " and " + element.destination);
            console.log("Adding to right: " + element.predictedTime);

            left.appendChild(vehicleId);
            right.appendChild(predictedTime);
            left.appendChild(destination);

            bus.append(left);
            bus.append(right);

            // Add it to the list:
            var breaker = document.createElement('div');
            breaker.setAttribute("id", "breaker");
            list.appendChild(bus);
            list.append(breaker);
        });

    };
    xmlHttp.send(null);
}
