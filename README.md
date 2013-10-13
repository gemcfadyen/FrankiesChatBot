FrankiesChatBot
===============

Repository for group project which will simulate a simple chat system


Environment setup
=================
Gradle:
-------
Install Gradle using http://gvmtool.net
In Cygwin run 'curl -s get.gvmtool.net | bash'
In a new console run 'gvm instal gradle'
Check that the install has been successful by typing gradle -version


If you need to install cywin to use gvm then select ssh, curl and unzip when running the cywing setup.exe


ActiveMQ:
---------
Instal ActiveMQ From http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation
To start your local activeMQ server go to: <install dir>\apache-activemq-5.8.0\bin  run: actibemq.bad
To view your local server enter http://localhost:8161/admin/ in your browser logging in with admin/admin


Building and Running Tests
--------------------------
* To compile the code type gradle build
* To run the tests type gradle test
* To view test results go to the build/reports/test and view the generated index.html file.




