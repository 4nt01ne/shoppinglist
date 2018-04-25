var greeter = require('./greeter');

var greeting = greeter.greet();

if (typeof document !== 'undefined') {
    var el = document.createElement('h1');
    el.innerHTML = greeting;
    document.body.appendChild(el);
} else {
    console.log(greeting);
}


var greeter = require('./greeter');

var greeting = greeter.greet();

if (typeof document !== 'undefined') {
    var apiEndpoint = 'http://localhost:8090/proposedItems';
    var table = document.createElement('table');

    fetch(apiEndpoint).then(function(response) {
        return response.json();
    }).then(function(obj) {
        let html = "";
        obj.forEach((item) => html +=`
            <tr>
                <td>${item.category}</td>
                <td>${item.type}</td>
                <td>${item.brand}</td>
                <td>${item.product}</td>
            </tr>`);
        table.innerHTML = html;
        document.body.appendChild(table);
    }).catch(function(err) {
        table.innerHTML = '<tr><td>oh no…</td></tr>';
        document.body.appendChild(table);
    });
} else {
    console.log(greeting);
}