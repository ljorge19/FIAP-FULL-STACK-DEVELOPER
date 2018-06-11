$(document).ready(function(){
    var lista = ["Javascript", "JQuery", "Java", "JPA"];

    //estrutura de repetição
    $.each(lista, function(indice, elemento){
        $("#cursos").append($("<option>",{
            text: elemento,
            value: indice
        }));
    });
});



function exibir(){
    //ler os valores dos campos de texto
    var nome = document.getElementById("nome").value;
    var idade = document.getElementById("idade").value;
    var resposta;

    /*
    if(idade < "18") {}

    ou 

    if(idade < 18) {}

    funcionan da mesma forma
    */

    if(idade == "18"){
        resposta = "O aluno tem 18 anos";
    }

    idade = parseInt(idade); //forçamos a variável idade a ser um inteiro
    if(idade === "18") { //resultará false: operador "estritamente" igual
        resposta = "Não podemos fazer esta comparação"
    }
    if(idade === 18){ //resultará true, se este for o valor informado
        resposta = "Idade (inteiro) igual a 18";
    }

    resposta += "Nome: " + nome + "\nIdade: " + idade + "\n" + resposta;
    alert(resposta);
}

var botao = document.getElementById("btnEnviar");
//adicionamos o evento click ao botão

//botao.addEventListener("click",exibir);    
botao.addEventListener("click", () => { //arrow function
    alert("Função anonima");
});
