@echo off
set /p escolha= escolha num 1 para criar uma pasta ou 2 para abrir a calculadora

if %escolha%==1 ( ::entao faca
    mkdir "%userprofile%/desktop/NovaPasta"
    echo pasta criada

)else if %escolha2%=="2"(
    start calc.exe
    echo calculadora aberta
)else(
    opcao invalida!
)

pause

