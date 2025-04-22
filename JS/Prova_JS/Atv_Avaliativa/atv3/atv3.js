let contador = 0;
let acumulador = 0;

while(contador <= 7){
    contador += 1;
    console.log(contador);
    acumulador += contador;
    console.log(acumulador);
}

const resultadoAc = acumulador > 45 ? 'Acumulador é alto: ${acumulador}' : 'Acumulador é baixo: ${acumulador}';
console.log(resultadoAc);
const resultadoCon = contador > 7 ? 'Contador passou de 7: ${contador}' : 'Contador dentro do limite: ${contador}';
console.log(resultadoCon);