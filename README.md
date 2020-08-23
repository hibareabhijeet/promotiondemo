# Author - Abhijit Hibare
# Contact No - 09518756307

# promotiondemo
Promotion Demo assignement

#Git repository
https://github.com/hibareabhijeet/promotiondemo.git

#Git checkout command
git clone "https://github.com/hibareabhijeet/promotiondemo.git"

# ***********************  IDE
# Open application in IDE
# Deploy 
# Execute JUnit test cases written in PromotionServiceTest.java file

# ***********************  CLI
# To test application via command line
# Go to root folder of project - promotiondemo

# Execute following command for building and running application
mvn clean spring-boot:run

# After application is deployed then open new terminal and execute following REST commands for creating data and executing flow
curl --header "Content-Type: application/json" localhost:8084/cart?sdu=A,A,A
# Expected output --> 130

curl --header "Content-Type: application/json" localhost:8084/cart?sdu=C,D
# Expected output --> 30

curl --header "Content-Type: application/json" localhost:8084/cart?sdu=A,B,C
# Expected output --> 100

curl --header "Content-Type: application/json" localhost:8084/cart?sdu=A,A,A,B,B,B,B,B,C,D
# Expected output --> 280