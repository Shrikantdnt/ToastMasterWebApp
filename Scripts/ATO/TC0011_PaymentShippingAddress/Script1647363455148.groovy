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

try {
    CustomKeywords.'com.application.DateTime.startTime'()
	
	
  
	WebUI.selectOptionByLabel( findTestObject('Object Repository/ATO/Payment/address/select_SelectCountry') , GlobalVariable.TestData["CountryName"], false)
	
	GlobalVariable.countrySA = GlobalVariable.TestData["CountryName"]
	
 	WebUI.setText(  findTestObject('Object Repository/ATO/Payment/address/input__.Address1') ,GlobalVariable.TestData["Address"])
	GlobalVariable.addressSA = GlobalVariable.TestData["Address"]
	
 	WebUI.setText( findTestObject('Object Repository/ATO/Payment/address/input__City')  ,GlobalVariable.TestData["City"])
	GlobalVariable.citySA = GlobalVariable.TestData["City"]
	
	WebUI.selectOptionByLabel( findTestObject('Object Repository/ATO/Payment/address/select_SelectStates') , GlobalVariable.TestData["States"], false)
	GlobalVariable.statesSA = GlobalVariable.TestData["States"]
	
	
 	WebUI.setText(  findTestObject('Object Repository/ATO/Payment/address/div_ZIPPostalCode') ,GlobalVariable.TestData["PostalCode"])
	GlobalVariable.postalcodeSA = GlobalVariable.TestData["PostalCode"]
	
	
	
	String CharterFee = WebUI.getText(findTestObject('Object Repository/ATO/Payment/address/Verify_CharterFee') )
	GlobalVariable.charterFee = CharterFee
	String Tax = WebUI.getText( findTestObject('Object Repository/ATO/Payment/address/Verify_Tax'))
	GlobalVariable.Tax = Tax
	String TotalOrder= WebUI.getText( findTestObject('Object Repository/ATO/Payment/address/Verify_TotalOrder'))
	GlobalVariable.TotalOrder = TotalOrder
	
	WebUI.click(findTestObject('Object Repository/ATO/Payment/button_Validate Address'))
	Thread.sleep(1000)
	
	WebUI.click(findTestObject('Object Repository/ATO/Payment/a_ConfirmAddress') )
	
	 
    
	 

    if (WebUI.waitForElementVisible( findTestObject('Object Repository/ATO/Payment/a_Credit Card'),120 )) {
		WebUI.click( findTestObject('Object Repository/ATO/Payment/a_Credit Card'))
		
		 GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = ('User Successfully save shipping address and validate this address.')
    } else {
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'User unable to save shipping address and not validate this address.'

        
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