@echo off
::declarar variável
:inicio
set /p num="Escolha um numero (se digitar 10, acabar)"

::condição para verificar num digitado
if %num%=="10" goto end
goto inicio
:end

echo sair do programa
pause
