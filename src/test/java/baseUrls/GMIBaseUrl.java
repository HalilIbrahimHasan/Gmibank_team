package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class GMIBaseUrl {
    protected static RequestSpecification spec;

    public static void setup(){

        spec = new RequestSpecBuilder().setBaseUri("https://gmibank.com/").build();

    }
}
