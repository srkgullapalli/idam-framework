Feature: Import User Feature
  Description: The purpose of this feature is to test Import functionality

  @IDAMWebsite
  Scenario: Create User with file Import
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | IDAM |
    Then Select sub service for main service selection
      | subService | User Imports |
    Then Perform User import using the file "\src\test\resources\testdata\User_Automation.xlsx"
    Then Logout of the Application