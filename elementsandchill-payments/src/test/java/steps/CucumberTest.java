package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.elementsandchill.payments.java.steps",
        plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class CucumberTest {
}