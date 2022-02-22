Feature: Dry Run
  Description: Smoke Test

  @Smoke
  Scenario: scenario1
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Logout of the Application
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | vasanth12@yopmail.com |
      | Password | Admin@1234            |
    Then Logout of the Application

   
  Scenario: scenario2
    Given Launch Application with URL
      | launchMode | Normal |
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Logout of the Application
    Given Launch Application with URL
      | launchMode | Incognito |
    Then User is in LoginPage and performs login with below fields
      | UserName | vasanth12@yopmail.com |
      | Password | Admin@1234            |
    Then Logout of the Application


