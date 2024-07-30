# Step 1: Clone the repository
git clone https://github.com/Shahidayatar/Apitera.git

# Step 2: Navigate to the project directory
cd Atipera

# Step 3: Build the project
mvn clean install

# Step 4: Run the project
mvn spring-boot:run

Assuming that we will test this application using github user "Shahidayatar" 
and running on port 808

1.Test the Endpoint to Get Non-Fork Repositories

curl -X GET "http://localhost:8080/github/user/Shahidayatar/repos" -H "Accept: application/json"

this will list all the non fork repositories. Basically repositories which are not copied 
from other projects. you can paste the link in the browser after the server is started to 
get a better look of the repositories

2. Test the Endpoint to Get Repository Branches

curl -X GET "http://localhost:8080/github/repos/Shahidayatar/six_project/branches" -H "Accept: application/json"

3. Test the Endpoint for a Non-Existent User
curl -X GET "http://localhost:8080/github/user/shahidayata/repos" -H "Accept: application/json" 
// we provided the wrong username, so we should get 404 :-)