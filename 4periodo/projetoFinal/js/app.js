import { headerComponent } from "./components/header.js";
import { footerComponent } from "./components/footer.js";

window.onload = function () {
  const header = document.getElementById("header");
  header.innerHTML = headerComponent;

  const footer = document.getElementById("footer");
  footer.innerHTML = footerComponent;

  const btnEntrar = document.getElementById("entrarBtn");
  const btnCadastrar = document.getElementById("cadastroBtn");  
  if (JSON.parse(localStorage.getItem("cadastro"))){
    btnEntrar.style.display = 'none';
    btnCadastrar.textContent = 'Meu cadastro';
  }
};
