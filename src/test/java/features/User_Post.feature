@UserPost
Feature: Creating User Details

  Background: Authorization set to "Basic Auth"
    

  #Valid Data
  @UserPost
  @SmokeTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |         0 |

  #Wrong EndPoint
  @UserPost
  @SanityTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApiWrong" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |         0 |

  #InvalidFirstname
  @UserPostAPIwithInvalidFirstName
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |         1 |
      | UserApiPOST |         2 |
      | UserApiPOST |         3 |
      | UserApiPOST |         4 |
      | UserApiPOST |         5 |
      | UserApiPOST |         6 |

  #InvalidLastname
  @UserPostAPIwithInvalidLastName
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |         7 |
      | UserApiPOST |         8 |
      | UserApiPOST |         9 |
      | UserApiPOST |        10 |
      | UserApiPOST |        11 |
      | UserApiPOST |        12 |

  #InvalidCity
  @UserPostAPIwithInvalidCity
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        12 |
      | UserApiPOST |        13 |
      | UserApiPOST |        14 |
      | UserApiPOST |        15 |
      | UserApiPOST |        16 |
      | UserApiPOST |        17 |

  #InvalidState
  @UserPostAPIwithInvalidState
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        18 |
      | UserApiPOST |        19 |
      | UserApiPOST |        19 |
      | UserApiPOST |        20 |

  #InvalidCountry
  @UserPostAPIwithInvalidCountry
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        21 |
      | UserApiPOST |        22 |
      | UserApiPOST |        23 |
      | UserApiPOST |        24 |

  #InvalidContact
  @UserPostAPIwithInvalidContact
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        25 |
      | UserApiPOST |        26 |
      | UserApiPOST |        27 |
      | UserApiPOST |        28 |

  #InvalidEmail
  @UserPostAPIwithInvalidEmail
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        29 |
      | UserApiPOST |        30 |
      | UserApiPOST |        31 |
      | UserApiPOST |        32 |

  #InvalidFoodcatogery
  @UserPostAPIwithInvalidCountry
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        33 |
      | UserApiPOST |        34 |
      | UserApiPOST |        35 |
      | UserApiPOST |        36 |
      | UserApiPOST |        37 |
      | UserApiPOST |        38 |
      | UserApiPOST |        39 |

  #Invalid Allergy
  @UserPostAPIwithInvalidAllergy
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        40 |
      | UserApiPOST |        41 |
      | UserApiPOST |        42 |

  #Invalid UserType
  @UserPostAPIwithInvalidUserType
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        43 |
      | UserApiPOST |        44 |
      | UserApiPOST |        45 |
      | UserApiPOST |        46 |
      | UserApiPOST |        47 |
      | UserApiPOST |        48 |

  #Invalid DieticianId
  @UserPostAPIInvalidDieticianId
  @Regressiontest
  Scenario Outline: check User Post request
    GivenUser creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>

    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        49 |
      | UserApiPOST |        50 |
      | UserApiPOST |        51 |
      | UserApiPOST |        52 |
      | UserApiPOST |        53 |
      | UserApiPOST |        54 |
      | UserApiPOST |        55 |

  #Invalid SameEmailId
  @UserPostAPIInvalidSameEmailId
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        56 |

  #Invalid SameContact
  @UserPostAPIWithInvalidSameContact
  @RegressionTest
  Scenario Outline: check User Post request
    Given User creates POST Method EndPoint  with data from "<sheetName>" and <RowNumber>
    When User calls "UserApi" Https Request with "POST"
    Then User receive HTTP "Status code" and response body

    Examples: 
      | sheetName   | RowNumber |
      | UserApiPOST |        57 |
