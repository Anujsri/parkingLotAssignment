## Instruction to run this Project.

# Prerequisite
	1. Java 8
	2. Spring Boot

## Installation instructions for Spring Boot
	1. Maven installation (I used maven)
		```sh
		$ sudo apt-get install maven
		```

	2. Installing the Spring Boot CLI (OSX)
		```
		sh 
		$ brew tap pivotal/tap
        $ brew install springboot 
        ```

    or visit this for more information 
    	https://docs.spring.io/autorepo/docs/spring-boot/1.0.0.RC5/reference/html/getting-started-installing-spring-boot.html

### This application can be run by three methods
	## See all availabe command for this project run ```run.sh``` then type help in spring shell
	1. interactive command prompt using run.sh
		A. ```sh
			$ chmod +x run.sh
			$ cp run.sh /usr/local/bin
			$ chmod u+x /usr/local/bin/run.sh
			```

		B. Then type `run.sh` from project directory.

	2. Using script command of spring shell
		file command.sh conatims command like ```create_parking_lot 6```,```park KA-01-HH-1234 White``` etc..
		```sh
			$ chmod +x command.sh
			$ cp command.sh /usr/local/bin
			$ chmod u+x /usr/local/bin/command.sh
			```

		B. firt run ``` run.sh```
		B. Then in spring shell type ```script command.sh``` from project directory.

	3. run with Unit test framework
		type command ```./mvnw clean install``` from project directory.
