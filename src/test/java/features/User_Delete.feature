@UserDELETE
Feature: Delete User record in User Api

  Background: Authorization is set to "Basic Auth"

  @UserApiDELETE
  Scenario Outline: check if user able to delete User record in UserAPI
    Given User creates DELETE Method EndPoint
    When User calls "UserApi" http Request with "DELETE" from "<sheetName>" and <RowNumber>
    Then User receive HTTP "Status code" and response body for UserDelete

    Examples: 
      | sheetName     | RowNumber |
      | UserApiDELETE |         0 |

  #Invalid Endpoint
  @UserApiDELETEWithInvalidEndPoint
  Scenario Outline: check if user able to delete User record in UserAPI
    Given User creates DELETE Method EndPoint
    When User calls "UserApiWrong" http Request with "DELETE" from "<sheetName>" and <RowNumber>
    Then User receive HTTP "Status code" and response body for UserDelete

    Examples: 
      | sheetName     | RowNumber |
      | UserApiDELETE |         0 |

  @UserApiDELETEWithInvalidParams
  Scenario Outline: check if user able to delete User record in UserAPI
    Given User creates DELETE Method EndPoint
    When User calls "UserApi" http Request with "DELETE" from "<sheetName>" and <RowNumber>
    Then User receive HTTP "Status code" and response body for UserDelete

    Examples: 
      | sheetName     | RowNumber |
      | UserApiDELETE |         1 |
      | UserApiDELETE |         2 |
      | UserApiDELETE |         3 |
