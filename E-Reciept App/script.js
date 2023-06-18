window.onload = () => {

	var clockElement = document.getElementById("current-date");

	function updateClock(clock) {
		let currentDate = new Date();
		clock.innerHTML = currentDate.toDateString() + ", " + currentDate.toLocaleTimeString();
	}

	setInterval(function () {
		updateClock(clockElement);
	}, 1000);

};