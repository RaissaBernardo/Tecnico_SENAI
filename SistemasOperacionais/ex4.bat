:: condiçoes if

@echo off
set /p escolha= escolha num 1 para criar uma pasta ou 2 para abrir a calculadora

if %escolha%==1 (goto :escolha1)
if %escolha%==2 (goto :escolha2)

:escolha1 
mkdir "%userprofile%/desktop/NovaPasta"
echo pasta criada
goto :fim

:escolha2
start calc
echo calculadora aberta
goto :fim

:fim
pause