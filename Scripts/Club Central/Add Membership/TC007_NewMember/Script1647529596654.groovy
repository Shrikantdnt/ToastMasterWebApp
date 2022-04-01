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
import com.kms.katalon.entity.global.GlobalVariableEntity as GlobalVariableEntity
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.github.javafaker.Faker as Faker
import java.net.URL as URL

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

    Faker faker1 = new Faker()

    String name = faker1.name().fullName()

    String firstName = faker1.name().firstName()
	GlobalVariable.firstName = firstName 

    String middleName = faker1.name().nameWithMiddle()
	GlobalVariable.middleName = middleName

    String lastName = faker1.name().lastName()
	GlobalVariable.lastNames = lastName

    String mobileNumber = faker1.phoneNumber().cellPhone()
	GlobalVariable.mobileNumber = mobileNumber

    String emailId = faker1.internet().emailAddress()

    String emailId1 = faker1.internet().safeEmailAddress(firstName)
	GlobalVariable.emailId1 = emailId1

    String streetAddress = faker1.address().country()
    GlobalVariable.streetAddress = streetAddress 

    WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/div_Add Membership'))

    WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input_Yes, New Member_member'))

    
 	
	WebUI.clearText(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input__FirstName'))
    WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input__FirstName'), GlobalVariable.firstName)

    WebUI.clearText(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input__LastName'))
    WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input__LastName'), GlobalVariable.lastNames)

	WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input_Female_Gender'))
	
    WebUI.clearText(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/input__PrimaryEmail'))
	WebUI.sendKeys(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/input__PrimaryEmail'),GlobalVariable.emailId1)

    

    Thread.sleep(1000)


    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

    //WebUI.click( findTestObject('Object Repository/ClubCentral/Add_Membership/Address/input_Please accept Terms and Conditions')  )
    if (WebUI.verifyElementVisible(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input_Yes_IsVisuallyImpairedMember'))) {
        
		WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input_Yes_IsVisuallyImpairedMember'))
		
		GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'User successfully open new member page'
    } else {
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'User can not  new member page.'
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