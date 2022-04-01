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

    WebUI.scrollToPosition(0, 250)

    if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Payment/address/div_ZIPPostalCode'), 1)) {
        WebUI.clearText(findTestObject('Object Repository/ATO/Payment/address/input__.Address1'))

        Thread.sleep(500)

        WebUI.clearText(findTestObject('Object Repository/ATO/Payment/address/input__City'))

        Thread.sleep(500)

        WebUI.clearText(findTestObject('Object Repository/ATO/Payment/address/div_ZIPPostalCode'))
    } else {
    }
    
    'Click on Save and Continue button'
    WebUI.click(findTestObject('Object Repository/ATO/Payment/button_Validate Address'))

    String validationMessage = WebUI.getText(findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/li_Please fill out this field'))

    print(validationMessage)

    if (validationMessage.contains('Please')) {
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