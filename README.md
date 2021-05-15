## Description
Simple REST service that controls robot's movement on a 5x5 grid

## How to
1. Run tests and build the project with `mvn clean package`
1. Run `docker-compose up` (Requires Docker to be installed) or start the application with IDE.
2. Execute `curl -H "Content-Type: text/plain" --data-binary @commands.txt http://localhost:8080/robot/move`
3. Run `docker-compose down` or stop the application from the IDE 
4. To remove previously created image run `docker rmi robot_image`

## What to improve
1. Implement the front end part of the task. This part is ignored since I do not have the necessary knowledge and the implementation would require more time.
2. Get the clearer picture about the requirements. Current implementation assumes that each POST call means a new game. It is not possible to continue from the latest position of the robot. 
   Also, I added two new possible commands BACKWARD and LEFT due to the fact that the robot can move FORWARD and RIGHT.
   Make the grid extendable, currently the size of the grid is hardcoded
3. Add Swagger in order to better document the API and describe the possible commands
