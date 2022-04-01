import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.application.DPOSCustomKeyword as DPOSCustomKeyword
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

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

    'Click on Application to Organize button'
    WebUI.click(findTestObject('Object Repository/ATO/button_Application to Organize'))

    Thread.sleep(1000)
	String headerName = WebUI.getText(findTestObject('Object Repository/ATO/h1_Application to organize a toastmasters club'))
	
 
	 if (headerName == 'APPLICATION TO ORGANIZE A TOASTMASTERS CLUB') {
		 GlobalVariable.vartestresult = 'PASS'
		 GlobalVariable.varpassremarks = ('User open successfully "APPLICATION TO ORGANIZE A TOASTMASTERS CLUB" page.')
	 } else {
		 GlobalVariable.vartestresult = 'FAIL'
		 GlobalVariable.varfailremarks = 'User not open "APPLICATION TO ORGANIZE A TOASTMASTERS CLUB" page.'
		 
	 }
 
//    String headerName = WebUI.getText(findTestObject('Object Repository/ATO/input_button_text_ContinueAsGuest'))
//
//    if (headerName.contains('Log In')) {
//        GlobalVariable.vartestresult = 'PASS'
//
//        GlobalVariable.varpassremarks = 'User open successfully "Log In" pop up box.'
//    } else {
//        GlobalVariable.vartestresult = 'FAIL'
//
//        GlobalVariable.varfailremarks = 'User not open "Log In" pop up box.'
//    }
    
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