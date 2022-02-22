#Author: sivaramakrishna.gullapalli@botnotch.com
#Summary : Sample Feature File to test services

Feature: IDAM Application Test Event Related Services Post, Update, Delete and GetAll events

  Background: User generates authorisation token
    Given Generate the Auth Token with following request "src\test\resources\testdata\AuthToken.json"
      | endPoint   | /api/authorize |
      | httpMethod | Post           |


  @IDAMAPI
  Scenario: To verify Authorized user is able to Post an event
    Then Trigger the API with authToken and request-body "src\test\resources\testdata\PostingEvent.json"
      | endPoint   | /api/events |
      | httpMethod | Post        |
    Then Verify API Response for the following service
      | service | PostingEvent |

    #If you pass resourceID it will update else you need to run Post Event it will fetch from that API Call
  @IDAMAPI
  Scenario: To verify Authorized user is able to Update an event
    Then Trigger the API with authToken and request-body "src\test\resources\testdata\updateEvent.json"
      | endPoint         | /api/events |
      | httpMethod       | Put         |
      | restrictedAccess | False       |
      | resourceID       | 20220120    |
    Then Verify API Response for the following service
      | service | PostingEvent |

  #If you pass resourceID it will delete else you need to run Post Event it will fetch from that API Call
  @IDAMAPI
  Scenario: To verify Authorized user is able to Delete an event
    Then Delete The Resource
      | endPoint         | /api/events |
      | httpMethod       | Delete      |
      | resourceID       | 20220120    |
    Then Verify API Response for the following service
      | service | DeleteEvent |
