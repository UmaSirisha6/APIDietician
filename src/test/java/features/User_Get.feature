@UserGet
Feature: Checking Get Https request in User API

  Background: Authorization is set to Basic Auth
    Given User creates GET Method

  #For all users
  @GetAllUser
  Scenario: To get all the Users available with valid 
    When User calls Get Https Request with "GetUserApi" Endpoint
    Then User should receive HTTP Status code and response fields for "Get" 

  #WRONG ENDPOINT
  @GetAllUserENDOINT
  Scenario: To get all the Users available
    When User calls Get Https Request with "UserApiWrong" Endpoint
    Then User should receive HTTP Status code and response fields for "Get"

  #valid FirstName
  @GetUserByValidFIRSTNAME
  Scenario Outline: To get all the Users available with valid FirstName
    When User calls "GetUserByFirstName" Https Request with "GetByFirstName" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByFirstName"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         0 |

  #Invalid FirstName
  @GetUserByInvalidFIRSTNAME
  Scenario Outline: To get all the Users available with invalid FirstName
    When User calls "GetUserByFirstName" Https Request with "GetByFirstName" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByFirstName"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         1 |
      | GetUser   |         2 |
      | GetUser   |         3 |
      | GetUser   |         4 |
      | GetUser   |         5 |

  #Valid Contact
  @GetUserByVALIDCONTACT
  Scenario Outline: To get all the Users available with valid contact info
    When User calls "GetUserByContact" Https Request with "GetByContact" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByContact"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         0 |

  #Invalid Contact Info
  @GetUserByINVALIDCONTACT
  Scenario Outline: To get all the Users available with invalid contact info
    When User calls "GetUserByContact" Https Request with "GetByContact" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByContact"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         1 |
      | GetUser   |         2 |
      | GetUser   |         3 |

  #Valid Email
  @GetUserByValidEMAIL
  Scenario Outline: To get all the Users available with valid Email
    When User calls "GetUserByEmail" Https Request with "GetByEmail" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByEmail"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         0 |

  #Invalid Email
  @GetUserByInvalidEMAIL
  Scenario Outline: To get all the Users available with invalid Email
    When User calls "GetUserByEmail" Https Request with "GetByEmail" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByEmail"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         1 |
      | GetUser   |         2 |

  #Valid UserType
  @GetUserByValidUser
  Scenario Outline: To get all the Users available with valid User Type
    When User calls "GetUserByUserType" Https Request with "GetByUserType" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByUserType"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         0 |
      | GetUser   |         7 |

  #Invalid User Type
  @GetUserByInValidUser
  Scenario Outline: To get all the Users available with invalid User Type
    When User calls "GetUserByUserType" Https Request with "GetByUserType" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByUserType"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         1 |
      | GetUser   |         2 |
      | GetUser   |         3 |
      | GetUser   |         4 |
      | GetUser   |         5 |
      | GetUser   |         6 |

  #Valid Dietician ID
  @GetUserByValidDieticianID
  Scenario Outline: To get all the Users available with valid Dietician Id
    When User calls "GetUserByDieticianID" Https Request with "GetByDieticianID" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByDieticianID"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         0 |

  #Invalid Dietician ID
  @GetUserByInvalidDieticianID
  Scenario Outline: To get all the Users available with invalid Dietician Id
    When User calls "GetUserByDieticianID" Https Request with "GetByDieticianID" from excel sheet "<sheetName>" and <RowNumber>
    Then User should receive HTTP Status code and response fields for "GetByDieticianID"

    Examples: 
      | sheetName | RowNumber |
      | GetUser   |         1 |
      | GetUser   |         2 |
      | GetUser   |         3 |
      | GetUser   |         4 |
     
