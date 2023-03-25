import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.FileReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderSteps {

    private List<String> lastFiveLines;

    @When("I read the file {}")
    public void iReadTheFileName(String fileName) {
        String[] pathToFile = {System.getProperty("user.dir") + "/src/test/resources/test-files/" + fileName};
        lastFiveLines = FileReader.main(pathToFile);
    }

    @Then("I should see the last 5 lines")
    public void iShouldSeeTheLastLines(DocString expectedResult) {
        String result = expectedResult.getContent();
        List<String> listResult = Arrays.asList(result.split(" "));
        assertEquals(listResult, lastFiveLines);
    }

    @Then("I should see the {} massage")
    public void iShouldSeeTheErrorMessage(String expectedErrorMessage, DocString expectedMessage) {
        String actualMessage = expectedMessage.getContent();
        assertEquals(expectedErrorMessage, actualMessage);
    }
}
