package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/utilidades",
        glue = {"stepDefinition"},
        tags = "@1"
)
public class TC_TraerUsuarios {
}
