Feature: Parabank Account Registration and Login

  Scenario: Successfully register and login with newly created account

    Given User launches Parabank application

    When User clicks on Register link
    And User enters valid registration details
    And User submits registration form

    Then Account should be created successfully

    When User logs out from application
    And User logs in with newly created credentials

    Then User should login successfully
    And User prints the account balance