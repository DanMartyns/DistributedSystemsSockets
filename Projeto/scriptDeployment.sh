# You need to install sshpass to run the script correctly

bold=$(tput bold)
normal=$(tput sgr0)
echo "${bold}*** Script de Deployment ***${normal}"

export SSHPASS='enterro2019'


###

echo -e "\n${bold}* Copiar parâmetros de simulação *${normal}"
cp Constants/Constants.java Manager/src/MainPackage/Constants.java
cp Constants/Constants.java Customer/src/MainPackage/Constants.java
cp Constants/Constants.java Mechanics/src/MainPackage/Constants.java
cp Constants/Constants.java Lounge/src/MainPackage/Constants.java
cp Constants/Constants.java RepairArea/src/MainPackage/Constants.java
cp Constants/Constants.java OutsideWorld/src/MainPackage/Constants.java
cp Constants/Constants.java Park/src/MainPackage/Constants.java
cp Constants/Constants.java SupplierSite/src/MainPackage/Constants.java
cp Constants/Constants.java GeneralInformationRepo/src/MainPackage/Constants.java

###

echo -e "\n${bold}* Cópia do código a executar em cada nó *${normal}"

echo -e "\n${bold}->${normal} A mover General Information Repository para a máquina ${bold}1${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws01.ua.pt << !
	put -r GeneralInformationRepo/
	bye
!

echo -e "\n${bold}->${normal} A mover Lounge para a máquina ${bold}2${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws02.ua.pt << !
	put -r Lounge/
	bye
!

echo -e "\n${bold}->${normal} A mover OutsideWorld para a máquina ${bold}3${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws03.ua.pt << !
	put -r OutsideWorld/
	bye
!

echo -e "\n${bold}->${normal} A mover RepairArea para a máquina ${bold}4${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws04.ua.pt << !
	put -r RepairArea/
	bye
!

echo -e "\n${bold}->${normal} A mover Park para a máquina ${bold}5${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws05.ua.pt << !
	put -r Park/
	bye
!

echo -e "\n${bold}->${normal} A mover SupplierSite para a máquina ${bold}6${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws06.ua.pt << !
	put -r SupplierSite/
	bye
!

echo -e "\n${bold}->${normal} A mover Manager para a máquina ${bold}7${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws07.ua.pt << !
	put -r Manager/
	bye
!

echo -e "\n${bold}->${normal} A mover Mechanics para a máquina ${bold}8${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws08.ua.pt << !
	put -r Mechanics/
	bye
!

echo -e "\n${bold}->${normal} A mover Customer para a máquina ${bold}9${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd0401@l040101-ws09.ua.pt << !
	put -r Customer/
	bye
!


###

echo -e "\n${bold}* Compilação do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A compilar General Information Repository na máquina ${bold}1${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws01.ua.pt << !
	cd GeneralInformationRepo/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar Lounge na máquina ${bold}2${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws02.ua.pt << !
	cd Lounge/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar OutsideWorld na máquina ${bold}3${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws03.ua.pt << !
	cd OutsideWorld/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit	
!

echo -e "\n${bold}->${normal} A compilar RepairArea na máquina ${bold}4${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws04.ua.pt << !
	cd RepairArea/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar Park na máquina ${bold}5${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws05.ua.pt << !
	cd Park/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar SupplierSite na máquina ${bold}6${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws06.ua.pt << !
	cd SupplierSite/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar Manager na máquina ${bold}7${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws07.ua.pt << !
	cd Manager/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar Mechanics na máquina ${bold}8${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws08.ua.pt << !
	cd Mechanics/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

echo -e "\n${bold}->${normal} A compilar Customer na máquina ${bold}9${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws09.ua.pt << !
	cd Customer/
	find . -name "*.java" > files.txt
	javac @files.txt
	rm files.txt
	exit
!

###

echo -e "\n${bold}* Execução do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A executar General Information Repository na máquina ${bold}1${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws01.ua.pt << !
	cd GeneralInformationRepo/src/MainPackage/
	nohup java -cp /home/sd0401/GeneralInformationRepo/src/ MainPackage.MainProgram > /dev/null 2>&1 &
	exit
!

echo -e "\n${bold}->${normal} A executar Lounge na máquina ${bold}2${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws02.ua.pt << !
	cd Lounge/src/MainPackage/
	nohup java -cp /home/sd0401/Lounge/src/ MainPackage.MainProgram > /dev/null 2>&1 & > log.txt
	exit
!

echo -e "\n${bold}->${normal} A executar OutsideWorld na máquina ${bold}3${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws03.ua.pt << !
	cd OutsideWorld/src/MainPackage/
	nohup java -cp /home/sd0401/OutsideWorld/src/ MainPackage.MainProgram > /dev/null 2>&1 & > log.txt
	exit
!

echo -e "\n${bold}->${normal} A executar RepairArea na máquina ${bold}4${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws04.ua.pt << !
	cd RepairArea/src/MainPackage/
	nohup java -cp /home/sd0401/RepairArea/src/ MainPackage.MainProgram > /dev/null 2>&1 & > log.txt
	exit
!

echo -e "\n${bold}->${normal} A executar Park na máquina ${bold}5${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws05.ua.pt << !
	cd Park/src/MainPackage/
	nohup java -cp /home/sd0401/Park/src/ MainPackage.MainProgram > /dev/null 2>&1 & > log.txt
	exit
!

echo -e "\n${bold}->${normal} A executar SupplierSite na máquina ${bold}6${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws06.ua.pt << !
	cd SupplierSite/src/MainPackage/
	nohup java -cp /home/sd0401/SupplierSite/src/ MainPackage.MainProgram > /dev/null 2>&1 & > log.txt
	exit 
!

# Wait for the shared regions to be launched before lanching the intervening enities

sleep 1

echo -e "\n${bold}->${normal} A executar Manager na máquina ${bold}7${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws07.ua.pt << !
	cd Manager/src/MainPackage/
	nohup java -cp /home/sd0401/Manager/src/ MainPackage.MainProgram > /dev/null 2>&1 & 
	exit
!

echo -e "\n${bold}->${normal} A executar Mechanics na máquina ${bold}8${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws08.ua.pt << !
	cd Mechanics/src/MainPackage/
	nohup java -cp /home/sd0401/Mechanics/src/ MainPackage.MainProgram > /dev/null 2>&1 &
	exit
!

echo -e "\n${bold}->${normal} A executar Customer na máquina ${bold}9${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws09.ua.pt << !
	cd Customer/src/MainPackage/
	nohup java -cp /home/sd0401/Customer/src/ MainPackage.MainProgram > /dev/null 2>&1 &
	exit
!
