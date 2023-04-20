Feature: Geography service tests

  @automated @smoke @geo
  Scenario: Should receive response from Geo service ping endpoint
    Given the client calls 'GEO_SERVICE_PING' endpoint
    Then the client should receive an HTTP 200 response code
    Then the client should see response containing 'SUCCESS' message
