Feature: Validating Place ApI's
@AddPlace
Scenario Outline: Verify if Place is beging Succefully added using AddPlaceAPI

Given Add Place Playload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" http request
Then the API call got sucess with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
|name    | language | address			 |
|Ahouse  | English  | world cross center |
#|88house | Spanish  | Sea cross center   |


@DeletePlace
Scenario: Verify if Delete Place functionality is working
Given DeletePlace Payload
When user calls "deletePlaceAPI" with "Post" http request 
Then the API call got sucess with status code 200
And "status" in response body is "OK"
