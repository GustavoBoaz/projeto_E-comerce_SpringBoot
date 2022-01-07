Feature: Get profile user

    Test for getting profile from the user

    Rule: Provide a profile for frontend

    Pre-condition: User is registred and logged in the system
    Expected result: The frontend can get the user profile by providing the token by the request header

    Scenario Outline: Get profile user

        Given a name "Gustavo Boaz" and email "gustavo2@email.com" and password "134652", which exists in the database for the access
        When I send a "<method>" request to "<url>" with the Authorization "<token>" in the header
        Then I get a <status_code> status code

        Examples:
            | method | url          | token                                      | status_code |
            # Valid token in request
            | GET    | /api/v1/user | Basic Z3VzdGF2bzJAZW1haWwuY29tOjEzNDY1Mg== | 200         |
            # Invalid token in request
            | GET    | /api/v1/user | Basic Z3VzdGF2bzJAZW1haWwuY29tOjEzNDY1M    | 401         |