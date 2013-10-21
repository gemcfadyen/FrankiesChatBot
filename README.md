FrankiesChatBot
===============

Repository for group project which will simulate a simple chat system

The repo is running against a continuous build server at www.drone.io. The current status can be seen at:

https://drone.io/github.com/gemcfadyen/FrankiesChatBot/status.png

[![Build Status](https://drone.io/github.com/gemcfadyen/FrankiesChatBot/status.png)](https://drone.io/github.com/gemcfadyen/FrankiesChatBot/latest)

Environment setup
=================
Gradle Wrapper
--------------
To use the gradle wrapper a task named 'wrapper' has been introduced.
So that the wrapper could be used, a pre-requisite step had to take place to generate the wrapper bundle. This was achieved by running:
* gradle -q wrapper - This generates wrapper files, which are committed to the git repository. This is to allows gradle 1.8 to be used without the developer having to download the install.


To build the project using the gradle wrapper the following command should be used:
* gradlew build  (or ./gradlew build if you are using Windows).
All valid gradle commands can be used so long as you replace the 'gradle' keyword with 'gradlew', eg:
* gradlew test (or ./gradlew test)

Gradle:
-------
Install Gradle using http://gvmtool.net
In Cygwin run 'curl -s get.gvmtool.net | bash'
In a new console run 'gvm instal gradle'
Check that the install has been successful by typing gradle -version


If you need to install cywin to use gvm then select ssh, curl and unzip when running the cywing setup.exe




Building and Running Tests
--------------------------
* To compile the code type gradle build
* To run the tests type gradle test
* To view test results go to the build/reports/test and view the generated index.html file.




ActiveMQ:
---------
Instal ActiveMQ From http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation
To start your local activeMQ server go to: <install dir>\apache-activemq-5.8.0\bin  run: actibemq.bad
To view your local server enter http://localhost:8161/admin/ in your browser logging in with admin/admin
