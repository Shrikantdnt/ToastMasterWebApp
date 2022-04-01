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

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    'Click on Add Member button'
    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Club'))

    Thread.sleep(1000)

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Club Number'))

    WebUI.setText(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Enter Club Number_ClubNo'), 
        GlobalVariable.TestData['InvalidClubNumber'])

    Thread.sleep(1000)

    Thread.sleep(1000)

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_ClosePopUp'))

    ///////////////////////////////////////////////////////////////////////////////////
    'Click on Add Member button'
    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Club'))

    Thread.sleep(1000)

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Club Name'))

    WebUI.setText(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Enter Club Name_ClubName'), 
        GlobalVariable.TestData['InvalidClubName'])

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Search'))

    Thread.sleep(1000)

    WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/a_ValidationMessageForSponerandMentorInformation'), 
        10)

    String validationMessage = WebUI.getText(findTestObject('Object Repository/ATO/a_ValidationMessageForSponerandMentorInformation'))

    Thread.sleep(1000)

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_ValidationCloseButton'))

    WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_ClosePopUp'))

    if (validationMessage.contains('No Results Found!')) {
        GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'On Screen successfully display validation messasge'
    } else {
        GlobalVariable.vartestresult = 'Fail'

        GlobalVariable.varfailremarks = 'On screen not display any validation message'
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