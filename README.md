# Bank System

Application Installation - Docker.

Run docker-compose up -d under bank-system/docker directory.

Testing.
1. Run mvn clean install. Please make sure database is running!
2. Please import postman bank.json.postman_collection in order to access additional tests and test integrity with the system.

Application has the following methods:
1. Create a new client
2. List all clients
3. Get client details by ID
4. Create a new client account
5. Effect a transfer between 2 accounts
6. List client accounts
7. List account transactions