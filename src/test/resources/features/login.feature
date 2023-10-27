
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page

  @wip @ui
  Scenario: Verify login with different user types
    Given the user logged in as "user"
    #Given the user logged in with username as "user151" and password as "Userpass123"

