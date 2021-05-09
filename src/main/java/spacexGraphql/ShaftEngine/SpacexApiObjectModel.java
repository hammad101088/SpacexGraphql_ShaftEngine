package spacexGraphql.ShaftEngine;
import com.shaft.api.RestActions;
import io.restassured.response.Response;
import utilities.shaftEngine.UtilityClass;

public class SpacexApiObjectModel {

	// ******* variables *******//
	RestActions apiObject;

	// ******* constructor *******//
	public SpacexApiObjectModel(RestActions apiObject) {
		this.apiObject = apiObject;
	}

	// graphql sample request using query only without variables
	/**
	 * get past launches
	 * 
	 * @return past launches response
	 */
	public Response getPastLaunches() {

		return UtilityClass.sendGraphqlRequest(SpacexResolvers.LAUNCHPAST_QUERY);
	}

	// graphql sample request using mutation with variables
	/**
	 * create user
	 * 	
	 * @param name
	 * @param rocket
	 * @return insert user response
	 */
	public Response insertUser(String name, String rocket) {

		String variables = "{\"name\": \"" + name + "\",\"rocket\": \"" + rocket + "\"}";
		return UtilityClass.sendGraphqlRequest(SpacexResolvers.INSERTUSER_MUTATION, variables);

	}

}
