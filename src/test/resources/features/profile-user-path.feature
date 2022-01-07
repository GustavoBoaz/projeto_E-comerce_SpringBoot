Feature: Get profile witch token in path

    Test: Get profile witch token in path

    Rule: Provide a profile for frontend

    Precondition: User is registred and logged in the system
    Expected result: The frontend can get the user profile by providing the token through the request path

    Scenario: Get profile by path of request
        Given I am registred and logged in the system
        When I send a request to the with valid token in path
        Then I should get the user profile