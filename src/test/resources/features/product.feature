Feature: Create product

    Test performed to validate a product's processes in the system.

    Rule: Product must be created.

        Scenario: Create and search products
            Given a product of the "BEERS" type called "Becks", "Box with 4 pack of 6 units", with an image "PHOTO", it has a value of "36.55" or "200" points. We have "65" in our inventory
            And a product of the "BEERS" type called "Corona", "Box with 4 pack of 6 units", with an image "PHOTO", it has a value of "32.75" or "175" points. We have "50" in our inventory
            And a product of the "BEERS" type called "Budweiser", "Box with 4 pack of 6 units", with an image "PHOTO", it has a value of "30.25" or "150" points. We have "80" in our inventory
            When customer searches on type "BEERS" of product with name "B"
            Then 2 products should have been found

        Scenario Outline: Search a product
            When customer searches on type "<search1>" of product with name "<search2>"
            Then <result> products should have been found

            Examples:
                | search1 | search2 | result |
                | BEERS   | Be      | 1      |
                | BEERS   | Co      | 1      |
                | BEERS   | Bug     | 0      |