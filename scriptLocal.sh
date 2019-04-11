bold=$(tput bold)
normal=$(tput sgr0)
echo "${bold}*** Script Local ***${normal}"

###

echo -e "\n${bold}* Copiar parâmetros de simulação *${normal}"
cp Constants_local.java Manager/src/MainPackage/Constants.java


###

echo -e "\n${bold}* Compilação do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A compilar o Manager"
cd Manager/
javac $(find . -name '*.java')
cd ..


###

echo -e "\n${bold}* Execução do código em cada nó *${normal}"
# Wait for the shared regions to be launched before lanching the intervening enities

sleep 1

echo -e "\n${bold}->${normal} A executar Logger"
cd Manager/src/
java -cp $(pwd) MainPackage/MainProgram &
cd ../../../..

wait

echo -e "\n${bold}->${normal} A execução terminou"

