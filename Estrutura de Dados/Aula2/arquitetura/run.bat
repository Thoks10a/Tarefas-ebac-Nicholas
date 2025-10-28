@echo off
echo Compilando o projeto...
javac -cp "src\main\java" src\main\java\com\aula2\*.java
if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)
echo Compilacao concluida com sucesso!
echo.
echo Executando o programa...
java -cp "src\main\java" com.aula2.App
pause
