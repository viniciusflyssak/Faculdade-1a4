const formulario = document.querySelector(".form-formulario");

formulario.addEventListener("submit", function (event) {
  event.preventDefault();
  inputs.forEach(function (input, index) {
    const errorMessage = spanErrors[index];
    validateInput(input, errorMessage);
    if (errorMessage.textContent != "") {
      return;
    }
  });

  let validados = true
  spanErrors.forEach(function (spanError){
    if (spanError.textContent != ''){
      validados = false 
    }
  })
  if (!validados){
    alert('Alguns campos apresentam erro, verifique!');
    return;
  }

  const apelido = document.querySelector('input[name="apelido"]').value;
  const nome = document.querySelector('input[name="nome"]').value;
  const dataNascimento = document.querySelector(
    'input[name="data-nascimento"]'
  ).value;
  const genero = document.querySelector('input[name="tipo"]:checked').value;
  const telefone = document.querySelector('input[name="telefone"]').value;
  const email = document.querySelector('input[name="email"]').value;
  const senha = document.querySelector('input[name="senha"]').value;
  const confirmarSenha = document.querySelector(
    'input[name="confirmar-senha"]'
  ).value;
  const rua = document.querySelector('input[name="rua"]').value;
  const numero = document.querySelector('input[name="numero"]').value;
  const bairro = document.querySelector('input[name="bairro"]').value;
  const cidade = document.querySelector('input[name="cidade"]').value;
  const estado = document.querySelector('input[name="estado"]').value;
  const cep = document.querySelector('input[name="cep"]').value;
  const complemento = document.querySelector('input[name="complemento"]').value;

  if (senha !== confirmarSenha) {
    alert("Senhas divergentes!");
    return;
  }

  const dadosFormulario = {
    apelido,
    nome,
    dataNascimento,
    genero,
    telefone,
    email,
    senha,
    endereco: {
      rua,
      numero,
      bairro,
      cidade,
      estado,
      cep,
      complemento,
    },
  };

  const dadosFormularioJSON = JSON.stringify(dadosFormulario);

  localStorage.setItem("cadastro", dadosFormularioJSON);

  window.location.href = "index.html";
});

function carregarDados() {
  const cadastro = JSON.parse(localStorage.getItem("cadastro")) || null;
  if (cadastro) {
    document.querySelector('input[name="apelido"]').value = cadastro.apelido;
    document.querySelector('input[name="nome"]').value = cadastro.nome;
    document.querySelector('input[name="data-nascimento"]').value =
      cadastro.dataNascimento;
    if (cadastro.genero === "masculino") {
      document.getElementById("masculino").checked = true;
    }
    if (cadastro.genero === "feminino") {
      document.getElementById("feminino").checked = true;
    }
    document.querySelector('input[name="telefone"]').value = cadastro.telefone;
    document.querySelector('input[name="email"]').value = cadastro.email;
    document.querySelector('input[name="senha"]').value = cadastro.senha;
    document.querySelector('input[name="confirmar-senha"]').value =
      cadastro.senha;
    document.querySelector('input[name="rua"]').value = cadastro.endereco.rua;
    document.querySelector('input[name="numero"]').value =
      cadastro.endereco.numero;
    document.querySelector('input[name="bairro"]').value =
      cadastro.endereco.bairro;
    document.querySelector('input[name="cidade"]').value =
      cadastro.endereco.cidade;
    document.querySelector('input[name="estado"]').value =
      cadastro.endereco.estado;
    document.querySelector('input[name="cep"]').value = cadastro.endereco.cep;
    document.querySelector('input[name="complemento"]').value =
      cadastro.endereco.complemento;
  }
}

document.addEventListener("DOMContentLoaded", function () {
  carregarDados();
});

const form = document.querySelector("#my-form");
//console.log(form);

const inputs = document.querySelectorAll(".required"); //nodelist
//console.log(inputs);

const spanErrors = document.querySelectorAll(".error-message");

const messages = {
  emptyfield: "Preencha o campo {field}!",
  shortName: "O campo {field} deve ter no mínimo 2 caracteres!",
  invalidEmail: "Informe um endereço de email válido. ",
  invalidPassword: "A senha deve ter no mínimo 8 caracteres!",
};

function validateInput(input, spanErrors) {
  let error = false;
  let message;
  if (input.value.trim() === "") {
    error = true;
    message = messages.emptyfield.replace("{field}", input.name);
  } else if (
    input.name === "nome" &&
    input.name === "apelido" &&
    input.value.length < 2
  ) {
    error = true;
    message = messages.shortName;
  } else if (input.name === "email" && !/\S+@\S+\.\S+/.test(input.value)) {
    error = true;
    message = messages.invalidEmail;
  } else if (input.name === "senha" && input.value.length < 8) {
    error = true;
    message = messages.invalidPassword;
  }

  if (error) {
    if (spanErrors) {
      spanErrors.textContent = message;
      spanErrors.style.display = "block";
      spanErrors.classList.add("errofont");
      input.classList.add("erroinput");
    }
  } else {
    if (spanErrors) {
      spanErrors.textContent = "";
      spanErrors.style.display = "none";
      input.classList.remove("erroinput");
    }
  }
}
