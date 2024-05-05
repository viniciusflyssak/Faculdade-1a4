const form = document.querySelector("#my-form");
// console.log(form);

const inputs = document.querySelectorAll("input");
// console.log(inputs);

const spanError = document.querySelectorAll(".error-message");
// console.log(spanError);

const messages = {
  emptyfield: "Preencha o campo {field}!",
  shortName: "O campo nome deve ter no mínimo 2 caracteres!",
  invalidEmail: "Informe um endereço de email válido!",
  invalidNumber: "O telefone informado está incorreto, verifique!",
};

function validateInput(input, spanError) {
  let error = false;
  let message;
  if (input.value === "") {
    error = true;
    message = messages.emptyfield.replace("{field}", input.name);
  } else if (input.name === "nome" && input.value < 2) {
    error = true;
    message = messages.shortName;
  } else if (input.name === "email" && !/\S+@\S+\.\S+/.test(input.value)) {
    error = true;
    message = messages.invalidEmail;
  } else if (
    input.name === "telefone" &&
    !/^\(\d{2}\)s?\d{4,5}-\d{4}$/.test(input.value)
  ) {
    error = true;
    message = messages.invalidNumber;
  }

  if (error) {
    spanError.textContent = message;
    spanError.style.display = "block";
    spanError.classList.add("errofont");
    input.classList.add("erroinput");
  } else {
    spanError.textContent = "";
    input.classList.remove("erroinput");
    spanError.style.display = "none";
  }
}

form.addEventListener("submit", function (e) {
  e.preventDefault();
  // console.log('Cliquei');
  inputs.forEach(function (input, index) {
    const errorMessage = spanError[index];
    validateInput(input, errorMessage);
    // console.log(index + ' - ' + input.name);
    // if (input.value === "") {
    //   errorMessage.textContent = `Preencha o campo ${input.name}!`;
    //   errorMessage.classList.add("errofont");
    //   input.classList.add("erroinput");
    //   // input.style.border = 'solid 1px #f00';
    // } else {
    //   errorMessage.textContent = "";
    //   input.classList.remove("erroinput");
    //   errorMessage.style.display = "none";
    // }
  });
});

inputs.forEach(function (input){
    input.addEventListener('blur', function(){
        const errorMessage = input.nextElementSibling;
        validateInput(input, errorMessage);
    })
})
