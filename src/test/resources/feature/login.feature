#Author: Shuhrat
Feature: Login Features Tests
  As user, I should be able to login into the website

  Background: 
    Given user is on OrangeHrm website

  @Shuhrat @smoke @login
  Scenario Outline: verify user can able to login with valid
    When user login with username "<username>" and password "<password>"
    Then verify login successful

    Examples: 
      | username | password |
      | Admin    | admin123 |

  @Shuhrat @smoke @login
  Scenario Outline: verify user cannot able to login with invalid cred
    When user login with username "<username>" and password "<password>"
    Then verify invalid login error message is displayed

    Examples: 
      | username | password |
      | admin    | admin123 |
      | admin123 | admin123 |
      | admin123 | Admin123 |
      |          | Admin123 |
