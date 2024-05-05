function adicionarProdutoCarrinho(nome, preco, quantidade, imagem, desconto) {
  const newRow = `
          <tr>
              <td>${nome}</td>
              <td>${preco}</td>
              <td>${desconto}</td>
              <td><input class="quantidade" type="number" class="inputCarrinho" value="${quantidade}"</td>
              <td class="total">${(preco * quantidade).toFixed(2)}</td>
              <td><img src="${imagem}" width="50" height="50"></td>
              <td><i class="fa fa-trash" id="btn-remove-${nome}"></i></td>
          </tr>
      `;
  const tableBody = document.querySelector("#tbProdutos tbody");
  tableBody.insertAdjacentHTML("beforeend", newRow);
  const botaoDel = document.getElementById(`btn-remove-${nome}`);
  if (botaoDel) {
    botaoDel.addEventListener("click", function () {
      deletarProduto(nome);
    });
  }

  const row = tableBody.lastElementChild;
  const quantidadeInput = row.querySelector(".quantidade");
  if (quantidadeInput) {
    quantidadeInput.addEventListener("change", function () {
      const quantidade = parseInt(quantidadeInput.value);
      const totalpreco = preco * quantidade;
      const total = row.querySelector(".total");
      total.textContent = totalpreco.toFixed(2);
      salvarProduto(nome, preco, quantidade, imagem, 0);
    });
  }
  obterTotal();
}

function deletarProduto(nome) {
  const rows = document.querySelectorAll("#tbProdutos tbody tr");
  let linha = null;
  rows.forEach(function (row) {
    if (row.querySelector("td:first-child").textContent === nome) {
      linha = row;
    }
  });
  linha.remove();

  const produtos = JSON.parse(localStorage.getItem("produtos")) || [];

  const updateStorage = produtos.filter(function (product) {
    return product.nome !== nome;
  });

  localStorage.setItem("produtos", JSON.stringify(updateStorage));
}

function carregarProdutos() {
  const produtos = JSON.parse(localStorage.getItem("produtos")) || [];
  produtos.forEach((produto) => {
    adicionarProdutoCarrinho(
      produto.nome,
      produto.preco,
      produto.quantidade,
      produto.imagem,
      produto.desconto.toFixed(2)
    );
  });
  obterTotal();
}

document.addEventListener("DOMContentLoaded", function () {
  carregarProdutos();
});

function obterTotal() {
  const produtos = JSON.parse(localStorage.getItem("produtos")) || [];
  let total = 0;
  let totalDesc = 0;
  produtos.forEach((produto) => {
    total = total + produto.preco * produto.quantidade;
    totalDesc = totalDesc + produto.desconto * produto.quantidade;
  });
  document.getElementById("subtotal").textContent =
    "Subtotal: R$ " + total.toFixed(2);
  document.getElementById("totalDesc").textContent =
    "Descontos: R$ " + totalDesc.toFixed(2);
  document.getElementById("totalizador").textContent =
    "Total: R$ " + (total - totalDesc).toFixed(2);
  document.getElementById("quantidadeItens").textContent ="Quantidade de itens: " + 
    produtos.length;
}

const continuar = document.getElementById("continuarComprando");
const finalizar = document.getElementById("finalizarCompra");
if (finalizar) {
  const produtos = JSON.parse(localStorage.getItem("produtos")) || [];
  finalizar.addEventListener("click", function () {
    if (produtos.length <= 0) {
      alert("Para finalizar a venda, adicione itens no carrinho!");
      return;
    }

    if (document.getElementById("cadastroBtn").textContent == "Meu cadastro") {
      alert("Compra finalizada!");

      produtos.forEach((produto) => {
        deletarProduto(produto.nome);
      });
      window.location.href = "index.html";
    } else {
      window.location.href = "formulario.html";
    }
  });
}
if (continuar) {
  continuar.addEventListener("click", function () {
    window.location.href = "index.html";
  });
}
