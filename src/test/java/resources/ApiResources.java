package resources;

//basically enum is a collection of constant and methods:
public enum ApiResources {
	AddPlaceAPI("/maps/api/place/add/json"), DeletePlaceApi("/maps/api/place/delete/json"), GetPlaceAPI(
			"/maps/api/place/get/json");
	// after this we can also define the constructor for it
	private String resources;

	ApiResources(String resources) {
		this.resources = resources;
	}

	public String getResorces() {
		return resources;
	}

}
