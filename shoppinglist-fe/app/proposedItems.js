var greeter = require('./greeter');

var greeting = greeter.greet();

if (typeof document !== 'undefined') {
    let apiEndpoint = 'http://localhost:8090/proposedItems';
    //let list = document.getElementsByClassName('css-treeview');
    let list = document.createElement('div');
    list.classList.add("css-treeview");

    fetch(apiEndpoint).then(function(response) {
        return response.json();
    }).then(function(obj) {
        let items = new Map();
        obj.forEach((item) => {
            items.set(item.category, items.get(item.category) || []);
            items.get(item.category).push(item);
        });
        let html = '    <ul>';
        let i = 0;
        items.forEach((value,key) => {
            //category
            html +=`
        <li><input type="checkbox" id="item-${i}" /><label for="item-${i}">${key}</label>
            <ul>`;
            //category items
            items.get(key).forEach((item) => {
                html += `
                <li>${item.type}, ${item.brand}, ${item.product}</li>`;
            });
            html +=`
            </ul>
        </li>`;
            i++;
        });
        html += `
    </ul>`;
        list.innerHTML = html;
        document.body.appendChild(list);
    }).catch(function(err) {
        list.innerHTML = '<p>oh no…</p>';
    });
} else {
    console.log(greeting);
}