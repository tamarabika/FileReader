import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.FileReader;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class FileReaderSteps {

    private List<String> lastFiveLines;

    @When("I read txt file")
    public void iReadTxtFile() {
        String[] sixLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file6-lines.txt"};
        lastFiveLines=FileReader.main(sixLinesFile);
    }

    @Then("I see 5 last lines")
    public void iSeeLastLines() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("2LINE");
        expectedLines.add("3LINE");
        expectedLines.add("4LINE");
        expectedLines.add("5LINE");
        expectedLines.add("6LINE");
        assertEquals(expectedLines, lastFiveLines);
    }
}
