Feature: Customer Page
  @parallelTest@NewCustomer
  Scenario: Validate Add new Customer
    Given I navigate to admin demo website
    And I enter user credentials
    And I click on login button
    And I am navigated to dashboard page
    When I click on "Customers" link on MainNavTreeMenu
    And I am navigate to "Customers" page
    And I click on Add New Button
    And I enter Email id of New Customer
    And I enter Password of New Customer
    And I enter First Name
    And I enter Last Name
    And I select Gender
    And I enter Date of Birth
    And I enter Company Name
    Then I select Save Button



  @parallelTest@SearchCustomer
  Scenario: Validate Search new Customer
    Given I navigate to admin demo website
    And I enter user credentials
    And I click on login button
    And I am navigated to dashboard page
    When I click on "Customers" link on MainNavTreeMenu
    Then I am navigate to "Customers" page
    And I enter Customer Email id
    And I enter Customer First Name
    And I enter Customer Last Name
    And I enter Customer Birth Month
    And I enter Customer Birth Date
    And I enter Customer Registration Date From
    And I enter Customer Registration Date To
    And I enter Customer Last Activity Date From
    And I enter Customer Last Activity To
    And I enter Customer Company Name
    And I enter Customer IP Address
    And I enter Customer Role




