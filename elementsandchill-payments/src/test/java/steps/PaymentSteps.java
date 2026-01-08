package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PaymentSteps {

    private Response response;
    private String requestBody;

    @Given("a valid payment request with source {string} and merchantId {string}")
    public void validPaymentRequest(String source, String merchantId) {
        requestBody = "{ \"source\": \"" + source + "\", \"merchantId\": \"" + merchantId + "\", \"paymentId\": \"PAY123\" }";
    }

    @Given("a payment request missing {string}")
    public void invalidPaymentRequest(String missingField) {
        // Example: omit source
        requestBody = "{ \"merchantId\": \"MERCHANT123\" }";
    }

    @When("I POST to {string}")
    public void postToEndpoint(String endpoint) {
        response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("http://localhost:8080" + endpoint);
    }

    @When("I GET {string}")
    public void getEndpoint(String endpoint) {
        response = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:8080" + endpoint);
    }

    @Then("the response status should be {int}")
    public void checkStatus(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain {string}")
    public void checkBodyContains(String expected) {
        response.then().body(containsString(expected));
    }
}