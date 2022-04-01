import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.net.URL as URL
import com.application.DPOSCustomKeyword as DPOSCustomKeyword
import com.github.javafaker.Faker as Faker
import groovy.time.TimeCategory as TimeCategory
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

try {
	CustomKeywords.'com.application.DateTime.startTime'()

	Faker faker = new Faker()

	String name = faker.name().fullName( // Miss Samanta Schmidt
		)

	String firstName = faker.name().firstName( // Emory
		)

	GlobalVariable.firstName = firstName

	String lastName = faker.name().lastName( // Barton
		)

	GlobalVariable.lastNames = lastName

	String emailid = faker.internet().safeEmailAddress(firstName)

	GlobalVariable.memberEmail = emailid

	String mobileNumber = faker.phoneNumber().cellPhone()

	GlobalVariable.PhoneNumber = mobileNumber

	String streetAddress = faker.address().streetAddress()

	GlobalVariable.streetAddress1 = streetAddress

	String city = faker.address().cityName()

	GlobalVariable.city1 = city

	//print(GlobalVariable.city1,GlobalVariable.streetAddress1)
	WebUI.sendKeys(findTestObject('Object Repository/ATO/input_FirstName'), firstName)

	WebUI.sendKeys(findTestObject('Object Repository/ATO/input_LastName'), lastName)

	WebUI.click(findTestObject('Object Repository/ATO/input_Female_Gender'))

	WebUI.click(findTestObject('Object Repository/ATO/flag_dropdown_mobile_phone'))

	WebUI.click(findTestObject('Object Repository/ATO/span_United States'))

	WebUI.sendKeys(findTestObject('Object Repository/ATO/input_MobilePhone'), mobileNumber)

	WebUI.sendKeys(findTestObject('Object Repository/ATO/input_PrimaryEmail'), emailid)

	WebUI.setText(findTestObject('Object Repository/ATO/input_Password'), GlobalVariable.TestData['Password'])

	WebUI.setText(findTestObject('Object Repository/ATO/input_Confirm_Password'), GlobalVariable.TestData['Password'])

	CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()
	
	'Click on Save and Continue button'
	WebUI.click(findTestObject('Object Repository/ATO/button_Save and Continue'))

	if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/select_SelectCountry'),
		150)) {
		GlobalVariable.vartestresult = 'PASS'

		GlobalVariable.varpassremarks = 'User successfully save new user details and go to Charter Agreement page.'
	} else {
		GlobalVariable.vartestresult = 'Fail'

		GlobalVariable.varfailremarks = 'User not go to Charter Agreement page because user get any error message or used previous data.'
	}
	
	CustomKeywords.'com.application.DPOSCustomKeyword.settestresult'(GlobalVariable.vartestresult, GlobalVariable.varpassremarks,
		GlobalVariable.varfailremarks)

	CustomKeywords.'com.application.DateTime.endTime'()

	CustomKeywords.'com.application.DateTime.totalTime'()
}
catch (Exception e) {
	println(e)

	GlobalVariable.vartestresult = 'FAIL'

	GlobalVariable.varfailremarks = ('Exception: ' + e.getStackTrace().toString())

	CustomKeywords.'com.application.DPOSCustomKeyword.settestresult'(GlobalVariable.vartestresult, GlobalVariable.varpassremarks,
		GlobalVariable.varfailremarks)

	CustomKeywords.'com.application.DateTime.endTime'()

	CustomKeywords.'com.application.DateTime.totalTime'()
}