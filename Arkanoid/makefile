# 316590512
# shternr2 
compile: bin
	find src -name "*.java" > sources.txt
	javac -cp  biuoop-1.4.jar:. -d bin @sources.txt

run:
	java -cp biuoop-1.4.jar:bin Ass6Game
 
check:
	java -jar checkstyle-5.7-all.jar -c biuoop.xml src/*.java

bin:
	mkdir bin

jar:
	jar cfm Ass6Game.jar Manifest.mf -C bin . -C resources .