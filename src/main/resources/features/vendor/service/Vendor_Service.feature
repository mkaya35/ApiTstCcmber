Feature:  Vendor Service tests

  @automated @smoke @vendor
  Scenario: Should receive response from vendor service ping endpoint
    Given the client calls 'VENDOR_SERVICE_PING' endpoint
    Then the client should receive an HTTP 200 response code
    Then the client should see response containing 'SUCCESS' message

  @automated @vendor @single
  Scenario Outline: Should receive valid response body for the post call
    Given the client uses the following vendor body details: fulfillmentMethod of "<fulfillmentMethod>", vendorId of "<vendorId>", shopKey of "<shopKey>",serviceLevel of "<serviceLevel>",itemQty of <itemQty>,itemId of "<itemId>"
    When the client calls vendor service 'VENDOR_SERVICE_POST' endpoint
    Then the client should receive an HTTP 200 response code
    And the client should see carrierCode of "<carrierCode>",carrierService of "<carrierService>",calcShiptWeight of <calcShiptWeight> in response
    Examples:
      | fulfillmentMethod  | vendorId    | shopKey     | serviceLevel | itemQty    |itemId | carrierCode|carrierService|calcShiptWeight|
      | DROP_SHIP          | 102888      | LTLB2C      | LTLB2C_BASIC | 99          |49999 |   EXLA     |   ROC        |      43.0     |
      | DROP_SHIP          | 199999      | LTLB2C      | LTLB2C_BASIC | 22          |12345 |   PAAF     |   ROC        |      11.0     |
