Retailer rewards for Customer

Exposed EndPoint:- http://localhost:8080/customers/{customerId}/reward-points (get call)
This endpoint will give reward-points of customer monthly as well as total reward points.
screenshot:- ![image](https://github.com/sailesh2155/customer-retail-rewards/assets/76978528/0810f1ad-aa33-438f-a40a-3410bf9ffd4d)

Sample response:-
{
    "FEBRUARY": 60,
    "MARCH": 540,
    "JANUARY": 70,
    "total": 670
}

NFR:-

java - 17

Springboot - 3.0.6

h2 database - 1.4.2

actuator

LOCAL SETUP:-

setup Java and maven

setup intellij

clone this project

to explore the database use application.yml details and url :) http://localhost:8080/h2-console

testdata.sql has test data which we need to run in our H2 DB and we will have different data sets and then once we hit the endpoint with appropriate customer-id we will get required reward-points.
