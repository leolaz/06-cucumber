Feature: Draft feature
  Customer should be able
  to rewrite or/and send
  closed new message

  Scenario Outline: Send last draft
    Given I login into gmail.com by "<login>" and "<password>"
    When I fill 'New Message' form to "<sendTo>" with "<subject>" and "<message>"
    And I close it
    Then my message saved in drafts as "<subject>" and "<message>"
    And I send it

    Examples:
      | login      | password   | sendTo             | subject  | message |
      | nichogo    | Qq11223344 | leolazzz@gmail.com | Cucumber | Test    |
      | tsthacktst | Hack4444   | leolazzz@gmail.com | Cucumber | Test    |