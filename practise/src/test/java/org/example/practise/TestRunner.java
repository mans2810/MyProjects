package org.example.practise;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/APIPostFeature.feature",
        glue = "org.example.practise"
)
public class TestRunner {
}
