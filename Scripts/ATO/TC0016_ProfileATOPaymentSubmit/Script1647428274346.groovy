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

    'Click on Profile link'
    WebUI.click(findTestObject('Object Repository/Profile/a_Welcome') )

    Thread.sleep(1000)

	CustomKeywords.'com.application.DPOSCustomKeyword.privacyAndConsentCloseButton'()
	CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()
    WebUI.click(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/a_profileATO'))

   // WebUI.click(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/button_ATOSubmitPayment'))
	String ClubID = WebUI.getText( findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/div_Your Club Number CB-07965620') )
	GlobalVariable.ClubIDs = ClubID
println(ClubID)
	println("GClubid"+GlobalVariable.ClubIDs )
	
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/button_ATOSubmitPayment'), 120)) {
		GlobalVariable.vartestresult = 'PASS'

		GlobalVariable.varpassremarks = 'Pay later functionality working scussfully  '+ (GlobalVariable.ClubIDs)
	} else {
		GlobalVariable.vartestresult = 'Fail'

		GlobalVariable.varfailremarks = 'Paylatter functionality is not working'
	}
 
    /* 
    if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/a_orderSummary'), 120)) {
        GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'User successfully redirect to payment page'
    } else {
        GlobalVariable.vartestresult = 'Fail'

        GlobalVariable.varfailremarks = 'User not redirect to payment page'
    }**/
    
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