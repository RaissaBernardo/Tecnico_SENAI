:: script

@ echo off
:inicio
set /p escolha= escolha os numeros 1 para abrir o paint, 2 o word e 3 a calculadora

if %escolha%==1 (goto :escolha1)
if %escolha%==2 (goto :escolha2)
if %escolha%==3 (goto :escolha3)
goto :inicio 

:escolha1
start mspaint
goto :inicio 

:escolha2
start winword
goto :inicio

:escolha3
start calc
goto :inicio 
pause