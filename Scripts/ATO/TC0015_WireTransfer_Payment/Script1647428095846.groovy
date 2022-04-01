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
import internal.GlobalVariable
import jdk.nashorn.internal.objects.Global

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.net.URL as URL

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    Thread.sleep(1000)

    WebUI.click(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/a_Wire Transfer or Pay Later'))

    WebUI.click(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/a_Download Wire Transfer Instructions'))

    Thread.sleep(2000)

    WebUI.switchToWindowIndex(0)

    WebUI.click(findTestObject('Object Repository/ATO/Wire_Transfer_Payment/a_CountinueWithOutPayment'))
	
	String ClubID = WebUI.getText( findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/div_Your Club Number CB-07965620') )
	GlobalVariable.ClubIDs = ClubID
println(ClubID)
	println("GClubid"+GlobalVariable.ClubIDs )
    if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Payment/button__Print'), 150)) {
        GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'User go to pay receipt page.'
    } else {
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'User not go to pay receipt page.'

        WebUI.back()
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