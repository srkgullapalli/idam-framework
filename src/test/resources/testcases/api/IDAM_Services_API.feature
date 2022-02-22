#Author: sivaramakrishna.gullapalli@botnotch.com
#Summary : Sample Feature File to test services

Feature: IDAM Application Test Services API Endpoints

  Background: User generates authorisation token
    Given Generate the Auth Token with following request "src\test\resources\testdata\AuthToken.json"
      | endPoint   | /api/authorize |
      | httpMethod | Post           |

  @IDAMAPI
  Scenario: To verify Authorized user is able to Post a service
    Then Trigger the API with authToken and request-body "src\test\resources\testdata\CreateService.json"
      | endPoint   | /api/sns_service_types |
      | httpMethod | Post                   |
    Then Verify API Response for the following service
      | service | PostingService |

