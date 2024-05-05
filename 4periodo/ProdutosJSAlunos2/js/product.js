document.querySelector("#btSave").addEventListener("click", function (event) {
  event.preventDefault();
  let name = document.getElementById("name").value;
  let price = document.querySelector("#price").value;
  const quantity = 1;

  const imageInput = document.querySelector('#imageFile').value;
//   console.log(name);
//   console.log(price);
  addProductTable(name, price, quantity, imageInput);
  addItem(name, price);
});

function addProductTable(name, price, quantity, imageUrl) {
  const newRow = `
    <tr>
        <td>${name}</td>
        <td>${price}</td>
        <td><input class="quantity" type="number" value="${quantity}"/></td>
        <td class="total">${(price * quantity).toFixed(2)}</td>
        <td> <img src="${imageUrl}" width="50" height="50"></td>
        <td><i class="fa fa-trash" id="btn-remove-${name}"></i></td>
    </tr>
    `;

    const tableBody = document.querySelector("#tbProducts tbody");
    tableBody.insertAdjacentHTML('afterend', newRow);
    const deleteButton = document.getElementById(`btn-remove-${name}`);
    deleteButton.addEventListener('click', deleteItem(name))

    const quantityInput = row.querySelector('.quantity');
    quantity.addEventListener('change', function(){
        const quantity = parseInt(quantityInput.value)
        const totalPrice = price * quantity;
        const total = row.querySelector('.total');
        total.textContent = totalPrice.toFixed(2);
        saveProductStorage(name, price, quantity);
    })
}

function isProductAlreadyInTable(name){
    const rows = document.querySelectorAll("#tbProducts tbody tr");
    let exist = null;
    rows.forEach(function(row){
        if(row.querySelector('td:first-child').textContent === name){
            exist = row;
        }
    })
    return exist;
}

function addItem(name, price, quantity=1, imageUrl){
    let existingRow = isProductAlreadyInTable(name);
    if (existingRow){
        alert('Produto já existe na tabela!');
    }else{
        addProductTable(name, price, quantity, imageUrl);
        saveProductStorage(name, price, quantity, imageUrl);
        clearInputs();
    }
}

function clearInputs(){
    document.getElementById('name').value = '';
    document.getElementById('price').value = '';
}

let products = [];
function saveProductStorage(name, price, quantity, imageUrl){
    const products = JSON.parse(localStorage.getItem('produtos')) || []
    const existingIndex = products.findIndex(product => product.name === name);
    if (existingIndex !== -1){
        products[existingIndex].quantity = quantity;
    }


    products.push({name, price, quantity});
    localStorage.setItem('produtos', JSON.stringify(products));
}

function loadTableFromStorage(){
    products = JSON.parse(localStorage.getItem('produtos')) || [];
    products.forEach(product => {
        addProductTable(product.name, product.price, product.quantity, product.imageUrl);
    })
}

document.addEventListener('DOMContentLoaded', function(){
    loadTableFromStorage();
})

function deleteItem(name){
    const row = isProductAlreadyInTable(name);
    row.remove();

    const products = JSON.parse(localStorage.getItem('produtos')) || []
    const updateStorage = products.filter(function(product){
        return product.name !==  name;
    })

    localStorage.setItem('produtos', JSON.stringify(updateStorage));
}