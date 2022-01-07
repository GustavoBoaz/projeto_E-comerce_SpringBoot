Feature: Get credentials user

    Test for getting credentials from the user

    Rule: Provide credentials for frontend

    Pre-condition: User is registred in system
    Expected result: Return of credentials to keep user logged in

    Scenario Outline: Get credentials user
        
        Given a name "Gustavo Boaz" and email "gustavo1@email.com" and password "134652", which exists in the database
        When a request with "<existent-email>" and "<existent-password>"
        And I send a "<method>" request to "<url>"
        Then I should receive a response with status code <status_code>

        Examples:
            | existent-email      | existent-password | method | url                      | status_code |
            # Accredited user
            | gustavo1@email.com  | 134652            | PUT    | /api/v1/user/credentials | 200         |
            # Incorrect password
            | gustavo1@email.com  | 1346522           | PUT    | /api/v1/user/credentials | 401         |
            # Incorrect email
            | gustavo1@email.comm | 134652            | PUT    | /api/v1/user/credentials | 401         |
            # Test password smaller than 2 characters
            | gustavo1@email.com  | 1                 | PUT    | /api/v1/user/credentials | 400         |
            # Test without email
            | gustavo1email.com   | 134652            | PUT    | /api/v1/user/credentials | 400         |