bold=$(tput bold)
normal=$(tput sgr0)
echo "${bold}*** Script Local ***${normal}"

###

echo -e "\n${bold}* Copiar parâmetros de simulação *${normal}"
<<<<<<< HEAD
cp Constants/Constants_local.java Manager/src/MainPackage/Constants.java
cp Constants/Constants_local.java Customer/src/MainPackage/Constants.java
cp Constants/Constants_local.java Mechanics/src/MainPackage/Constants.java
cp Constants/Constants_local.java Lounge/src/MainPackage/Constants.java
cp Constants/Constants_local.java RepairArea/src/MainPackage/Constants.java
cp Constants/Constants_local.java OutsideWorld/src/MainPackage/Constants.java
cp Constants/Constants_local.java Park/src/MainPackage/Constants.java
cp Constants/Constants_local.java SupplierSite/src/MainPackage/Constants.java
###

echo -e "\n${bold}* Compilação do código em cada nó *${normal}\n"

echo -e "${bold}->${normal} A compilar o Manager"
cd Manager/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o Customer"
cd Customer/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o Mechanics"
cd Mechanics/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o Lounge"
cd Lounge/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o RepairArea"
cd RepairArea/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o OutsideWorld"
cd OutsideWorld/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o Park"
cd Park/
javac $(find . -name '*.java')
cd ..

echo -e "${bold}->${normal} A compilar o SupplierSite"
cd SupplierSite/
javac $(find . -name '*.java')
cd ..
###

echo -e "\n${bold}* Execução do código em cada nó *${normal}\n"
=======
cp Constants_local.java Manager/src/MainPackage/Constants.java


###

echo -e "\n${bold}* Compilação do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A compilar o Manager"
cd Manager/
javac $(find . -name '*.java')
cd ..


###

echo -e "\n${bold}* Execução do código em cada nó *${normal}"
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
# Wait for the shared regions to be launched before lanching the intervening enities

sleep 1

<<<<<<< HEAD
echo -e "${bold}->${normal} A executar Manager"
cd Manager/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar Customer"
cd Customer/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar Mechanics"
cd Mechanics/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar Lounge"
cd Lounge/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar RepairArea"
cd RepairArea/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar OutsideWorld"
cd OutsideWorld/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar Park"
cd Park/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../

echo -e "${bold}->${normal} A executar SupplierSite"
cd SupplierSite/src
java -cp $(pwd) MainPackage/MainProgram &
cd ../../


wait


=======
echo -e "\n${bold}->${normal} A executar Logger"
cd Manager/src/
java -cp $(pwd) MainPackage/MainProgram &
cd ../../../..

wait

>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
echo -e "\n${bold}->${normal} A execução terminou"

