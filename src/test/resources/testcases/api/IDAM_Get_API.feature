#Author: sivaramakrishna.gullapalli@botnotch.com
#Summary : Sample Feature File to test services

Feature: This feature is to test All GET API Endpoints of IDAM Application

  Background: User generates authorisation token
    Given Generate the Auth Token with following request "src\test\resources\testdata\AuthToken.json"
      | endPoint   | /api/authorize |
      | httpMethod | Post           |

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch GetEvents data
    Then Trigger the API with authToken and request-body ""
      | endPoint         | /api/events |
      | httpMethod       | Get         |
      | restrictedAccess | False       |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch GetEvents data
    Then Trigger the API with authToken and request-body ""
      | endPoint         | /api/events |
      | httpMethod       | Get         |
      | restrictedAccess | False       |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get All Users data
    Then Trigger the API with authToken and request-body ""
      | endPoint         | /api/users |
      | httpMethod       | Get        |
      | restrictedAccess | False      |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Single Valid User Data
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/users/              |
      | httpMethod | Get                      |
      | resourceID | 6213337374cf62fb4ceb9b4e |
    Then Verify API Response for the following service
      | service | GetSingleUser |

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch event info for a particular event
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/events/             |
      | httpMethod | Get                      |
      | resourceID | 62132e0974cf62fb4ceb9b4b |
    Then Verify API Response for the following service
      | service | GetSingleEvent |

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get All Tickets data
    Then Trigger the API with authToken and request-body ""
      | endPoint         | /api/ticket_events |
      | httpMethod       | Get                |
      | restrictedAccess | False              |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch GetServices data
    Then Trigger the API with authToken and request-body ""
      | endPoint         | /api/sns_service_types |
      | httpMethod       | Get                    |
      | restrictedAccess | False                  |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch GetAllStadiums Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/stadiums |
      | httpMethod | Get           |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get WebHooks Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/register_webhooks |
      | httpMethod | Get                    |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get GlobalSettings Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/global_settings |
      | httpMethod | Get                  |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Audit Logs Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/audit_logs |
      | httpMethod | Get             |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Activity Logs Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/activity_logs |
      | httpMethod | Get                |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Job Logs Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/job_logs |
      | httpMethod | Get           |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Errors Logs Info
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/notification_events |
      | httpMethod | Get                      |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Notifications
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/error_logs |
      | httpMethod | Get             |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Integrations
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/app_settings |
      | httpMethod | Get               |
    Then Verify response data for the get request

  @IDAMAPI
  Scenario: To verify Authorized user is able to fetch Get Roles
    Then Trigger the API with authToken and request-body ""
      | endPoint   | /api/roles |
      | httpMethod | Get        |
    Then Verify response data for the get request

