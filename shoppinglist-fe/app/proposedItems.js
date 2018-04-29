let colorHelp = require('./color');
let apiEndpoint = 'http://localhost:8090/proposedItems';
let list = document.createElement('div');
list.classList.add("css-treeview");

fetch(apiEndpoint).then(function (response) {
    return response.json();
}).then(function (obj) {
    let items = new Map();
    obj.forEach((item) => {
        items.set(item.category, items.get(item.category) || []);
        items.get(item.category).push(item);
    });
    if (typeof document !== 'undefined') {
        let html = '    <ul>';
        let i = 0;
        let gradientScaleItems = 1/ items.size;
        items.forEach((value, key) => {
            //category
            html += `
        <li><input type="checkbox" id="item-${i}" /><label for="item-${i}" style="background-color: ${colorHelp.colorLuminance("#7d6608",gradientScaleItems)};">${key}</label>
            <ul>`;
            let gradientScaleSubItems = 1/ items.get(key).length;
            //category items
            items.get(key).forEach((item) => {
                html += `
                <li class="item" style="background-color: ${colorHelp.colorLuminance("#154360",gradientScaleSubItems)};">${item.type}, ${item.brand}, ${item.product}</li>`;
                gradientScaleSubItems += gradientScaleSubItems;
            });
            html += `

            </ul>
        </li>`;
            i++;
            gradientScaleItems += gradientScaleItems;
        });
        html += `
    </ul>`;
        list.innerHTML = html;
        document.body.appendChild(list);
    } else {
        let message = '';
        items.forEach((value, key) => {
            //category
            message += `
        ${key}`;
            //category items
            items.get(key).forEach((item) => {
                message += `
                ${item.type}, ${item.brand}, ${item.product}`;
            });
            i++;
        });
        console.log(message);
    }
}).catch(function (err) {
    if (typeof document !== 'undefined') {
        list.innerHTML =  `<p>oh no… ${err}</p>`;
        document.body.appendChild(list);
    } else {
        console.log('oh no... ' + err);
    }
});