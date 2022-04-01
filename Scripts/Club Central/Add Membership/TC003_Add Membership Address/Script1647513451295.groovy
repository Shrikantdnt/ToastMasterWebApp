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
import java.net.URL as URL
import com.github.javafaker.Faker as Faker


try {
    CustomKeywords.'com.application.DateTime.startTime'()

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

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
	
	WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/Yes, New Member/input_Female_Gender')  )

	
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