@UserDELETE
Feature: Delete User record in User Api

  Background: Authorization is set to "Basic Auth"

  @UserDELETEApi
  Scenario: check if user able to delete User record in UserAPI
    Given User creates DELETE Method EndPoint
    When User calls "UserDeleteAPI" http Request with "Delete" from Sheet "DeleteUserData"
    Then User receive HTTP "Status code" and response body
