make:
	$(shell if [[ ! -e bin ]]; then mkdir bin; fi)
	cd src; javac -cp .:../MySpring.jar -d ../bin co/zhanglintc/UTest/*.java

.PHONY:
MySpring:
	@mkdir MySpring > /dev/null 2>&1
	cd src; javac -d ../MySpring co/zhanglintc/MySpring/*.java
	cd MySpring; jar -cf ../MySpring.jar co/zhanglintc/MySpring/*.class
	@rm -rf MySpring

run:
	cd bin; java -cp .:../MySpring.jar co/zhanglintc/UTest/UTest
