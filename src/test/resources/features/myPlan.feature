Feature:Myplan Page

  Scenario:Weekdays are displayed correctly
    Given the user is logged in
    When the user is on the "My plan" page
    Then the weekdays are displayed correctly


  Scenario:Day numbers are displayed correctly
    Given the user is logged in
    When the user is on the "My plan" page
    Then the day number are displayed correctly