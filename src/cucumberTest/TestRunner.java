package cucumberTest;
 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/JoséAilton/workspace/MercadoLivre/target/Feature"
		,glue={"stepDefinition"}
		)
 
public class TestRunner {
 
}