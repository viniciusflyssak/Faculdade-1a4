function salvarProduto(nome, preco, quantidade, imagem, desconto, fromAdd = false) {
  const produtos = JSON.parse(localStorage.getItem("produtos")) || [];
  const existingIndex = produtos.findIndex((produto) => produto.nome === nome);
  if (existingIndex !== -1) {
    if (!fromAdd) {
      produtos[existingIndex].quantidade = quantidade;
    } else {
      alert("Produto já se encontra no carrinho!");
    }
  } else {
    alert("Produto adicionado!");
    produtos.push({ nome, preco, quantidade, imagem, desconto });
  }
  localStorage.setItem("produtos", JSON.stringify(produtos));
  obterTotal();
}

var botoesAdicionar = document.querySelectorAll(".btnAdd");
botoesAdicionar.forEach(function (botao) {
  if (botao) {
    botao.addEventListener("click", function (event) {
      var card = event.target.closest(".card");
      var titulo = card.querySelector(".card-title").textContent;
      var desc = card.querySelector(".text-success");
      var preco = parseFloat(
        card
          .querySelector(".card-text")
          .textContent.replace("R$", "")
          .replace(",", ".")
      );
      var imagem = card.querySelector(".card-img-top").src;
      var desconto = 0.00
      if(desc){
        desconto = preco - parseFloat(
          card
            .querySelector(".text-success")
            .textContent.replace("R$", "")
            .replace(",", ".")
        );
      }
      salvarProduto(titulo, preco, 1, imagem, desconto, true);
    });
  }
});

document.addEventListener("DOMContentLoaded", function () {
  var form = document.querySelector("form");
  if (form) {
    form.addEventListener("submit", function (e) {
      e.preventDefault();

      var input = document.querySelector("#searchInput");
      var carousel = document.querySelector(".carrossel-inicio");
      var filtro = input.value.toLowerCase();

      var cards = document.querySelectorAll(".card");

      cards.forEach(function (card) {
        var titulo = card
          .querySelector(".card-title")
          .textContent.toLowerCase();
        var preco = card.querySelector(".card-text").textContent.toLowerCase();

        if (titulo.includes(filtro) || preco.includes(filtro)) {
          card.style.display = "block";
          carousel.style.display = "block";
        } else {
          card.style.display = "none";
          carousel.style.display = "none";
        }
      });
    });
  }
});

var btnAdicionarDetalhes = document.querySelector(".btnAdicionarDetalhes");
if (btnAdicionarDetalhes) {
  btnAdicionarDetalhes.addEventListener("click", function () {
    salvarProduto(
      "Pão branco",
      3.99,
      1,
      "http://127.0.0.1:5500/img/paoBranco.png",
      0,
      true
    );
  });
}

var btnFrete = document.querySelector("#btnFrete");
var inputFrete = document.querySelector("#inputFrete");
if (btnFrete) {
  btnFrete.addEventListener("click", function () {
    if (inputFrete.value == "") {
      alert("Informe o CEP!");
    } else {
      alert("O frete custa R$ 35,00");
    }
  });
}
