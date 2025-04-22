@ echo off
:inicio
set /p escolha= escolha um numero entre 1 e 100: 

if %escolha%==43 (goto :escolha1)
if %escolha% GTR 43 (goto :escolha2)
if %escolha% LSS 43 (goto :escolha3)

:escolha1
echo VOCE ACERTOU. PARABENS
goto fim:

:escolha2
echo O numero correto e menor
goto :inicio

:escolha3
echo O numero correto e maior
goto :inicio

:fim
pause