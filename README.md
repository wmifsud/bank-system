# Bank System

Requirements.
Apache Tomcat 7.0.65.
JDK 1.7.0_79.
Postgresql 9.4 database.
PG Admin.

Database Installation.
-System was developed on Postgresql 9.4.
-Please create a new database on your postgresql server and name it bank.
-Import database by using restore bank.backup file.

Application Installation.
1. Run mvn clean install on bank-system directory in command line.
2. Copy the created bank-ws.war file under the target directory to Tomcat's webapps folder.
3. Create a setenv.bat file under the tomcat bin directory with the following (please correct your paths accordingly):
	set JAVA_HOME=C:\Devtools\jdk1.7.0_79
	set JAVA_OPTS=%JAVA_OPTS% -Dpath=C:\DevTools\Code\other\bank-system\config\application.properties
4. Make sure the path above points to the correct location of the application.properties file.
5. Run the startup.bat and application should start without issues.

Testing.
1. When you install the application using Intellij, 16 unit tests are automatically executed.
2. Please import postman bank.json.postman_collection in order to access additional tests and test integrity with the system.

Application has the following methods:
1. Create a new client
2. List all clients
3. Get client details by ID
4. Create a new client account
5. Effect a transfer between 2 accounts
6. List client accounts
7. List account transactions