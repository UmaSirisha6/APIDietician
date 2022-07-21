@UserPUT
Feature: Update User Details in UserAPI

  Background: Authorization is set to "Basic Auth"

  @UserPUTApi
  Scenario: check User Put request
    Given User creates PUT Method EndPoint
    When User calls "PUTUser" Https Request with "PUT" from Sheet "PUTUser"
    Then User receive HTTP "Status code" and response body
