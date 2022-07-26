@UserPUT
Feature: Update User Details in UserAPI

  Background: Authorization is set to "Basic Auth"

  @UserPUTApi
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body
    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |         0 |

  #Wrong Endpoint
  @UserPutApiWithInvlidEndPoint
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "userApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |         0 |

  #Invalid  Firstname
  @UserPutApiWithInvlidFirstname
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |         1 |
      | UserApiPUT |         2 |
      | UserApiPUT |         3 |
      | UserApiPUT |         4 |

  #Invalid  Lastname
  @UserPutAPIWithInvalidLastname
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |         5 |
      | UserApiPUT |         6 |
      | UserApiPUT |         7 |
      | UserApiPUT |         8 |

  #Invalid Contact
  @UserPutAPIWithInvalidContact
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |         9 |
      | UserApiPUT |        10 |
      | UserApiPUT |        11 |
      | UserApiPUT |        12 |

  #Invalid City
  @UserPutAPIWithInvalidCity
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        13 |
      | UserApiPUT |        14 |
      | UserApiPUT |        15 |

  #Invalid State
  @UserPutAPIWithInvalidState
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        16 |
      | UserApiPUT |        17 |
      | UserApiPUT |        18 |

  #Invalid Country
  @UserPutAPIWithInvalidCountry
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        19 |
      | UserApiPUT |        20 |
      | UserApiPUT |        21 |

  #Invalid EmailID
  @UserPutAPIWithInvalidEmailID
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        22 |
      | UserApiPUT |        23 |
      | UserApiPUT |        24 |
      | UserApiPUT |        25 |

  #Invalid FoodCategory
  @UserPutAPIWithInvalidFoodCategory
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT" 
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        26 |
      | UserApiPUT |        27 |
      | UserApiPUT |        28 |
      | UserApiPUT |        29 |

  #Invalid Allergy
  @UserPutAPIWithInvalidAllergy
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        30 |
      | UserApiPUT |        31 |
      | UserApiPUT |        32 |
      | UserApiPUT |        33 |

  #Invalid Input Parameters
  @UserPutAPIWithInvalidParams
  Scenario Outline: check User Put request
    Given User creates PUT Method EndPoint from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Http Request with "PUT"
    Then User receive http "Status code" and response body

    Examples: 
      | sheetName  | RowNumber |
      | UserApiPUT |        34 |
      | UserApiPUT |        35 |
      | UserApiPUT |        36 |
