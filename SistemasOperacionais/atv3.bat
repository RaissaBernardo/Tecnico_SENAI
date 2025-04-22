@Echo off

:inicio
set /p escolha=Digite 1 para realizar a soma e 2 para subtracao (digite 3 caso queira finalizar as contas): 
if %escolha% == 3 (goto :fim)

set /p selecione1=Selecione um numero: 
set /p selecione2=Selecione o proximo numero: 

if %escolha% == 1 (goto :escolha1)
if %escolha% == 2 (goto :escolha2)

::soma
:escolha1
    set /a resultado1=%selecione1% + %selecione2%
        Echo A soma e igual a %resultado1%
goto :inicio

::subtração
:escolha2
    set /a resultado2=%selecione1% - %selecione2%
        Echo A subtracao e igual a %resultado2%
goto :inicio
pause