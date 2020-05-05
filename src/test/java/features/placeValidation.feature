Feature: Validating Place API's 
@AddPlaceAPI 
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI 

	Given Add Place Payload with "<setAddress>" "<setLanguage>" "<setName>" 
	When user calls "AddPlaceAPI" with "Post" http request 
	Then the API call got success with status code 200 
	And "status" in response body is "OK" 
	And verify place_id created maps to "<setName>" using "GetPlaceAPI" 
	
	Examples: 
		| setAddress                | setLanguage | setName        |
		| 29, side layout, cohen 09 | French-IN   | Frontline house|
		| maholi                    | hindi       | Rajat          |
		
		@DeletePlaceApi 
		Scenario: Verfiy the functionality of delete place Api 
		
			Given DeletePlace palyload 
			When user calls "DeletePlaceApi" with "Post" http request 
			Then the API call got success with status code 200 
			And "status" in response body is "OK" 
		