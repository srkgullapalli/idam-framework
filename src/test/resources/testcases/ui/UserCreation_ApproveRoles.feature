Feature: User creation and role approval
  Description: The purpose of this feature is to test User Creation

  @IDAMWebsite
  Scenario: Create user approve role and verify status
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | IDAM |
    Then Select sub service for main service selection
      | subService | Users |
    Then Create new user with the below fields
      | firstName      | AutoUser             |
      | lastName       | Regression           |
      | userType       | Staff                |
      | gender         | Male                 |
      | documentID     | 27612405934          |
      | jobTitle       | QA Tester            |
      | justification  | RegressionAutomation |
      | employer       | Botnotch             |
      | supervisorName | AutoSupervisor       |
      | projectName    | Automation           |
      | tag            | Auto                 |
      | ticketID       | 20229873             |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | approvalStatus | User Approval Pending |
      | IDAMID         | ####                  |
      | userStatus     | Valid                 |
    Then Logout of the Application
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | vasanth12@yopmail.com |
      | Password | Admin@1234            |
    Then Select the service from the below menu options
      | service | IDAM |
    Then Select sub service for main service selection
      | subService | Pending Approvals |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then navigate to view details screen for the user
    Then Approve or Reject RequestAccess for the user
      | setRoleStatus | approved |
    Then Select sub service for main service selection
      | subService | Users |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | approvalStatus | Roles Approved |
    Then Logout of the Application
    
  @IDAMWebsite
  Scenario: Create user reject role and approve status
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | admin@botnotch.com |
      | Password | Botnotch#560040    |
    Then Select the service from the below menu options
      | service | IDAM |
    Then Select sub service for main service selection
      | subService | Users |
    Then Create new user with the below fields
      | firstName      | AutoUser             |
      | lastName       | Regression           |
      | userType       | Staff                |
      | gender         | Male                 |
      | documentID     | 27612405934          |
      | jobTitle       | QA Tester            |
      | justification  | RegressionAutomation |
      | employer       | Botnotch             |
      | supervisorName | AutoSupervisor       |
      | projectName    | Automation           |
      | tag            | Auto                 |
      | ticketID       | 20229873             |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | approvalStatus | User Approval Pending |
      | IDAMID         | ####                  |
      | userStatus     | Valid                 |
    Then Logout of the Application
    Given Launch Application with URL
    Then User is in LoginPage and performs login with below fields
      | UserName | vasanth12@yopmail.com |
      | Password | Admin@1234            |
    Then Select the service from the below menu options
      | service | IDAM |
    Then Select sub service for main service selection
      | subService | Pending Approvals |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then navigate to view details screen for the user
    Then Approve or Reject RequestAccess for the user
      | setRoleStatus | reject |
    Then Select sub service for main service selection
      | subService | Users |
    Then Perform search using below criteria
      | searchCriteria | phoneNo |
    Then Verify Status in Search Screen
      | approvalStatus | Roles Rejected |
    Then Logout of the Application