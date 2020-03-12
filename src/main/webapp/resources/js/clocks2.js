window.onload = function () {
    showTime();
};

function showTime(){
    let date = new Date();
    let timeString = [date.getHours(), date.getMinutes(), date.getSeconds()].join(':');
    let dateString = [date.getDate(), date.getMonth() + 1, date.getFullYear()].join('.');
    document.getElementById('clock').innerHTML = [dateString, timeString].join(' | ');
    setTimeout(showTime, 13000);
}