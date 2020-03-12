var r;

window.onload = function () {
    drawGraph(getR());
};

document.getElementById("canvas").addEventListener('click', async function (evt) {
    let canvas = document.getElementById("canvas");
    let position = getMousePosition(canvas, evt);
    let xCoordinate = ((position.x - 150) / 100 * r).toFixed(5);
    let yCoordinate = ((150 - position.y) / 100 * r).toFixed(5);
    console.log("X position:" + position.x);
    console.log("Y position:" + position.y);
    console.log("X coordinate:" + xCoordinate);
    console.log("Y coordinate:" + yCoordinate);
    document.getElementById("graph:xCanvas").value = xCoordinate;
    document.getElementById("graph:yCanvas").value = yCoordinate;
    addFromGraph();
});

function changeR(newR) {
    r = newR;
    console.log("Choosen radius: " + newR);
    drawGraph(newR);
    loadTable();
}

function getR() {
    r = document.getElementById("rValue").value;
    return r;
}

function getMousePosition(canvas, evt) {
    let rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

function drawPoint(r, x, y, hit) {
    let canvas = document.getElementById("canvas");
    let ctx = canvas.getContext("2d");
    let xCoordinate = 150 + ((x * (300 / 3)) / r);
    let yCoordinate = 150 - ((y * (300 / 3)) / r);
    if (hit) {
        ctx.fillStyle = "#77FFFF";
    } else {
        ctx.fillStyle = "#773DA6";
    }
    ctx.beginPath();
    ctx.arc(xCoordinate, yCoordinate, 3, 0, 2 * Math.PI);
    ctx.fill();
    ctx.closePath();
}

function checkX(xValue) {
    if (!(xValue === -3 || xValue === -2 || xValue === -1 || xValue === 1 || xValue === 0 || xValue === 2 || xValue === 3 || xValue === 4 || xValue === 5)) {
        return true;
    }
}

function checkR(rValue) {
    if (!(rValue === 1 || rValue === 2 || rValue === 3 || rValue === 4 || rValue === 5)) {
        return true;
    }
}

function drawGraph(r) {
    let width = 300;
    let height = 300;
    let canvas = document.getElementById("canvas");
    let ctx = canvas.getContext("2d");
    ctx.font = "13px Ravi Prakash";
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    console.log("Drawing graph for r = " + r);
    //Clear
    ctx.clearRect(0, 0, width, height);

    //Drawing rectangle
    ctx.fillStyle = "#FC88DA";
    ctx.fillRect(width / 6, height / 6, width / 3, height / 3);

    //Drawing triangle
    ctx.beginPath();
    ctx.moveTo(width / 2, height / 2);
    ctx.lineTo((width / 2) - (width / 6), height / 2);
    ctx.lineTo(width / 2, height - (height / 6));
    ctx.lineTo(width / 2, height / 2);
    ctx.fill();
    ctx.closePath();

    //drawing 1/4 of circle
    ctx.beginPath();
    ctx.moveTo(width - (width / 6), height / 2);
    ctx.lineTo(width / 2, height / 2);
    ctx.lineTo(width / 2, (height / 6));
    ctx.arc(width / 2, height / 2, 2 * (width / 6), 0, 3 * Math.PI / 2, true);
    ctx.fill();
    ctx.closePath();

    ctx.fillStyle = "#000000";
    //Drawing arrows
    ctx.beginPath();
    ctx.moveTo(width / 2, 0);
    ctx.lineTo(width / 2, height);
    ctx.moveTo(width / 2, 0);
    ctx.lineTo(width / 2 + 7, 7);
    ctx.moveTo(width / 2, 0);
    ctx.lineTo(width / 2 - 7, 7);
    ctx.moveTo(0, height / 2);
    ctx.lineTo(width, height / 2);
    ctx.moveTo(width, height / 2);
    ctx.lineTo(width - 7, height / 2 - 7);
    ctx.moveTo(width, height / 2);
    ctx.lineTo(width - 7, height / 2 + 7);
    ctx.font = "16px Ravi Prakash";
    ctx.fillText("X", width - 10, height / 2 - 13);
    ctx.fillText("Y", width / 2 + 15, 10);
    ctx.font = "13px Ravi Prakash";
    ctx.closePath();
    ctx.stroke();

    //Drawing lines
    ctx.beginPath();
    ctx.moveTo(width / 2 - 4, height - (height / 6));
    ctx.lineTo(width / 2 + 4, height - (height / 6));
    ctx.fillText("-" + (r).toString(), width / 2 + 7, height - (height / 6) + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width / 2 - 4, height - 2 * (height / 6));
    ctx.lineTo(width / 2 + 4, height - 2 * (height / 6));
    ctx.fillText("-" + (r / 2).toString(), width / 2 + 7, height - 2 * (height / 6) + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width / 2 - 4, height - 4 * (height / 6));
    ctx.lineTo(width / 2 + 4, height - 4 * (height / 6));
    ctx.fillText((r / 2).toString(), width / 2 + 7, height - 4 * (height / 6) + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width / 2 - 4, height - 5 * (height / 6));
    ctx.lineTo(width / 2 + 4, height - 5 * (height / 6));
    ctx.fillText((r).toString(), width / 2 + 7, height - 5 * (height / 6) + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width - (width / 6), height / 2 - 4);
    ctx.lineTo(width - (width / 6), height / 2 + 4);
    ctx.fillText((r).toString(), width - (width / 6) - 4, height / 2 + 14);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width - 2 * (width / 6), height / 2 - 4);
    ctx.lineTo(width - 2 * (width / 6), height / 2 + 4);
    ctx.fillText((r / 2).toString(), width - 2 * (width / 6) - 3, height / 2 + 14);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width - 4 * (width / 6), height / 2 - 4);
    ctx.lineTo(width - 4 * (width / 6), height / 2 + 4);
    ctx.fillText("-" + (r / 2).toString(), width - 4 * (width / 6) - 7, height / 2 + 14);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width - 5 * (width / 6), height / 2 - 4);
    ctx.lineTo(width - 5 * (width / 6), height / 2 + 4);
    ctx.fillText("-" + (r).toString(), width - 5 * (width / 6) - 6, height / 2 + 14);
    ctx.closePath();
    ctx.stroke();
}

