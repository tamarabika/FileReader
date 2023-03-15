import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.FileReader;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class FileReaderSteps {

    private List<String> lastFiveLines;

    @When("I read a txt file with 6 lines")
    public void iReadTxtFile6() {
        String[] sixLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file6-lines.txt"};
        lastFiveLines=FileReader.main(sixLinesFile);
    }
    @When("I read a text file with 5 lines")
    public void iReadTxtFile5() {
        String[] sixLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file5-lines.txt"};
        lastFiveLines=FileReader.main(sixLinesFile);
    }
    @When("I read a text file with less than 5 lines")
    public void iReadTxtFile4() {
        String[] sixLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file4-lines.txt"};
        lastFiveLines=FileReader.main(sixLinesFile);
    }

    @Then("I see 5 last lines")
    public void iSeeLastLines6TXT() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("2LINE");
        expectedLines.add("3LINE");
        expectedLines.add("4LINE");
        expectedLines.add("5LINE");
        expectedLines.add("6LINE");
        assertEquals(expectedLines, lastFiveLines);
    }
    @Then("I see all 5 lines")
    public void iSeeLastLines5TXT() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("1LINE");
        expectedLines.add("2LINE");
        expectedLines.add("3LINE");
        expectedLines.add("4LINE");
        expectedLines.add("5LINE");
        assertEquals(expectedLines, lastFiveLines);
    }
    @Then("I see less than 5 lines")
    public void iSeeLastLines4TXT() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("1LINE");
        expectedLines.add("2LINE");
        expectedLines.add("3LINE");
        expectedLines.add("4LINE");
        assertEquals(expectedLines, lastFiveLines);
    }
}
