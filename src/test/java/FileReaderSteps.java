import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileReaderSteps {

    private List<String> lastFiveLines;

    @When("I read a txt file with 6 lines")
    public void iReadTxtFile6() {
        String[] sixLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file6-lines.txt"};
        lastFiveLines = FileReader.main(sixLinesFile);
    }

    @When("I read a text file with 5 lines")
    public void iReadTxtFile5() {
        String[] fiveLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file5-lines.txt"};
        lastFiveLines = FileReader.main(fiveLinesFile);
    }

    @When("I read a text file with less than 5 lines")
    public void iReadTxtFile4() {
        String[] fourLinesFile = {System.getProperty("user.dir") + "/src/test/resources/file4-lines.txt"};
        lastFiveLines = FileReader.main(fourLinesFile);
    }

    @When("I read a text empty file")
    public void iReadATextEmptyFile() {
        String[] emptyFile = {System.getProperty("user.dir") + "/src/test/resources/empty-file.txt"};
        lastFiveLines = FileReader.main(emptyFile);
    }

    @When("I read an img file")
    public void iReadAImgFile() {
        String[] imgFile = {System.getProperty("user.dir") + "/src/test/resources/file-picSmile.img"};
        lastFiveLines = FileReader.main(imgFile);
    }

    @When("I read a txt file with special characters")
    public void iReadATextSpecialCharactersFile() {
        String[] specialCharactersFile = {System.getProperty("user.dir") + "/src/test/resources/file-specialCharacters.txt"};
        lastFiveLines = FileReader.main(specialCharactersFile);
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

    @Then("I see error message")
    public void iSeeErrorMsg() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("1LINE");
        expectedLines.add("2LINE");
        expectedLines.add("3LINE");
        expectedLines.add("4LINE");
        assertEquals(expectedLines, lastFiveLines);
    }

    @Then("I see error empty file message")
    public void iSeeErrorEmptyMsg() {
        assertNull(lastFiveLines);
    }

    @Then("I see error img file message")
    public void iSeeErrorImgMsg() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("![](iCloud Drive/desktop/smile.jpeg)");
        assertEquals(expectedLines, lastFiveLines);
    }

    @Then("I see error special characters file message")
    public void iSeeErrorSpecialCharacters() {
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("^[a-zA-Z0-9\\s]+$");
        assertEquals(expectedLines, lastFiveLines);
    }

    @When("I read the file {}")
    public void iReadTheFileName(String fileName) {
        String[] pathToFile = {System.getProperty("user.dir") + "/src/test/resources/" + fileName};
        lastFiveLines = FileReader.main(pathToFile);
    }

    @Then("I should see the last 5 lines")
    public void iShouldSeeTheLastLines(DocString expectedResult) {
        String result = expectedResult.getContent();
        List<String> listResult = Arrays.asList(result.split(" "));
        assertEquals(listResult, lastFiveLines);
    }

    @Then("I should see the {} massage")
    public void iShouldSeeTheErrorMessage(String errorMessage, DocString expectedMessage) {
        String message = expectedMessage.getContent();
        List<String> expectedMessageList = Arrays.asList(errorMessage.split(" "));
        List<String> actualMessageList = Arrays.asList(message.split(" "));
        assertEquals(expectedMessageList, actualMessageList);
    }
}
