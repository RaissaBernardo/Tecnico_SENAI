@Echo off
::set /a numero=50
set /a numero=%RANDOM% %%101
Echo Tente adivinhar meu numero
Echo.

:A 
set /p user=

if %user% LSS %numero% (Echo Maior!)
if %user% GTR %numero% (Echo Menor!)
if %user% == %numero% (goto :B)
if %user% == %numero% (goto :C)

goto :A 

:B
Echo Parabens voce acertou
goto :fim

:C
Echo o numero que voce acertou era %numero%
goto :fim

:fim
pause