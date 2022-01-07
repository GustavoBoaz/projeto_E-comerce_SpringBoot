Feature: Create new user

    Test of creation a new user in de system

    Rule: User can create a new user in the system

    Scenario Outline: Create new user
        Given a request with name "<name>" the email "<email>" the password "<password>"
        When send a method "<method>" to endpoint "<url>"
        Then the response status code is <status>

        Examples:
            | name         | email              | password | method | url          | status |
            # Test Created
            | Gustavo Boaz | gustavo0@email.com | 134652   | POST   | /api/v1/user | 201    |
            # Test user Duplicated
            | Gustavo Boaz | gustavo0@email.com | 134652   | POST   | /api/v1/user | 422    |
            # Test name smaller than 2 characters
            | G            | gustavo1@email.com | 134652   | POST   | /api/v1/user | 400    |
            # Test password smaller than 2 characters
            | Gustavo Boaz | gustavo2@email.com | 1        | POST   | /api/v1/user | 400    |
            # Test email invalid
            | Gustavo Boaz | gustavo3email.com  | 134652   | POST   | /api/v1/user | 400    |