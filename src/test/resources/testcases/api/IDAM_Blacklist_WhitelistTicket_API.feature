#Author: sivaramakrishna.gullapalli@botnotch.com
#Summary : Sample Feature File to test services

Feature: IDAM Application Test Blacklist and Whitelist User

  Background: User generates authorisation token
    Given Generate the Auth Token with following request "src\test\resources\testdata\AuthToken.json"
      | endPoint   | /api/authorize |
      | httpMethod | Post           |


 
  Scenario: To verify Authorized user is able to Post an event
    Then Trigger the API with authToken and request-body "src\test\resources\testdata\BlacklistTicket.json"
      | endPoint   | /api/consumer_users/disable_ticket |
      | httpMethod | Post                               |
    Then Verify API Response for the following service
      | service | PostingEvent |

 
  Scenario: To verify Authorized user is able to Post an event
    Then Trigger the API with authToken and request-body "src\test\resources\testdata\WhitelistTicket.json"
      | endPoint   | /api/consumer_users/enable_ticket |
      | httpMethod | Post                              |
    Then Verify API Response for the following service
      | service | PostingEvent |

