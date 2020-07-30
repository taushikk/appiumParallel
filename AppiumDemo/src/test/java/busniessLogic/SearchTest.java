package busniessLogic;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.BaseTest;

public class SearchTest extends BaseTest implements SearchUserPageRepository, ITestListener {
	int i = 1;

	@Parameters({ "deviceName" })
	@Test()
	public void samplePassTestCase(String deviceName) throws InterruptedException {
		myTest = myExtent.createTest("samplePassTestCase");
		myTest.assignCategory(deviceName);
		myTest.assignAuthor("QA Automation Team");
		myTest.log(Status.INFO, "Hi am Info of a Test Cases");
		myTest.log(Status.INFO, "Hi am Step 1 of a Test Case");
		myTest.log(Status.INFO, "Hi am Step 2 of a Test Case");
		myTest.log(Status.PASS, "Passing Test Case");
		System.out.println("Test Method 1 Executed");

	}

	@Parameters({ "deviceName" })
	@Test()
	public void sampleFailTestCase(String deviceName) throws InterruptedException, IOException {
		myTest = myExtent.createTest("sampleFailTestCase");
		myTest.assignCategory(deviceName);
		myTest.assignAuthor("QA Automation Team");
		myTest.log(Status.INFO, "Hi am Info of a Test Cases");
		myTest.log(Status.INFO, "Hi am Step 1 of a Test Case");
		myTest.log(Status.INFO, "Hi am Step 2 of a Test Case");
		myTest.log(Status.INFO, "This will get fail");
		myTest.log(Status.FAIL, "Test Case is Failing");

	}

}
