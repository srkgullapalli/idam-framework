Feature: Import Ticket Blacklist Whitelist Ticket
  Description: The purpose of this feature is to ticket related functionality

  @IDAMWebsite
  Scenario: Create Ticket with file Import
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | TicketEnablement |
    Then Select sub service for main service selection
      | subService | TES Imports |
    Then Perform User import using the file "\src\test\resources\testdata\Tickets_InputTemplate.xlsx"
    Then Logout of the Application

  @IDAMWebsite
  Scenario: Verify Ticket Status in Ticket Enablement System
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | TicketEnablement |
    Then Select sub service for main service selection
      | subService | TES Tickets |
   #Insert a valid ticket into test case to perform validation of Ticket
    Then Inject data into testContext
      | phoneNo | 96760987 |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | Ticket Status | Valid |
      | Ticket ID     | ####  |
    Then Logout of the Application

  @IDAMWebsite
  Scenario: Verify Ticket Status in MAS Access
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | MassAccess |
    Then Select sub service for main service selection
      | subService | Mass Access Tickets |
   #Insert a valid ticket into test case to perform validation of Ticket
    Then Inject data into testContext
      | phoneNo | 96760987 |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | Mass Ticket Status | Valid               |
      | Push Status        | Success             |
      | Pushed At          | ######              |
      | Push Response      | Pushed successfully |
    Then Logout of the Application