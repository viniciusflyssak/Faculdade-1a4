document.getElementById('concluido').addEventListener('change', function () {
    var dataHoraConcluido = document.getElementById('dataHoraConcluido');
    if (this.value === '1') {
        dataHoraConcluido.style.display = 'block';
    } else {
        dataHoraConcluido.style.display = 'none';
    }
});

document.addEventListener("DOMContentLoaded", function () {
    var dataHoraConcluido = document.getElementById('dataHoraConcluido');
    if (this.value === '1') {
        dataHoraConcluido.style.display = 'block';
    } else {
        dataHoraConcluido.style.display = 'none';
    }
});