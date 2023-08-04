Feature: Verfy Patient API

  Scenario: Patient Service
    When the client calls /patients
    Then the client receives status code of 200