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

    Faker faker1 = new Faker()

    String name = faker1.name().fullName( // Miss Samanta Schmidt
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

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()
	
	WebUI.click(  )
	

    WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/select_byLabelCountry'), 
        GlobalVariable.TestData['CountryName'], false)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/select_byLabelStates'), 
        GlobalVariable.TestData['States'], false)

    WebUI.clearText(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input__Address1'))

    WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input__Address1'), GlobalVariable.TestData[
        'Address'])

    WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input__City'), GlobalVariable.TestData[
        'City'])

    WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input__PostalCode'), GlobalVariable.TestData[
        'PostalCode'])
	
	
	WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/input__PrimaryEmail') ,'XS@example.com')
	
	WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input_Please accept Terms and Conditions')  )
	
	WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Address/button_Submit')  )

    if (WebUI.verifyElementVisible( findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/a_Submit Payment'))) {
        GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'User successfully add address.'
    } else {
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'User can not add address.'
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