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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.net.URL as URL

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

    WebUI.selectOptionByLabel(findTestObject('Object Repository/Common/Payment_CreditCard/select_Month'), GlobalVariable.TestData[
        'ExpireMonth'], false)

    // "09 - Sep", false)
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Common/Payment_CreditCard/select_Year'), GlobalVariable.TestData[
        'ExpireYear'], false)

    //   , "2024", false )
    WebUI.sendKeys(findTestObject('Object Repository/Common/Payment_CreditCard/input__NameOnCard'), GlobalVariable.TestData[
        'cardNumber'])

    // "4032033468248120")
    WebUI.sendKeys(findTestObject('Object Repository/Common/Payment_CreditCard/input__NameOnCard'), Keys.chord(Keys.CONTROL, 
            'a'))

    WebUI.sendKeys(findTestObject('Object Repository/Common/Payment_CreditCard/input__NameOnCard'), Keys.chord(Keys.CONTROL, 
            'x'))

    WebUI.sendKeys(findTestObject('Object Repository/Common/Payment_CreditCard/input__CreditCardNumber'), Keys.chord(Keys.CONTROL, 
            'v'))

    WebUI.setText(findTestObject('Object Repository/ATO/Payment/input__NameOnCard'), GlobalVariable.TestData['CardName'])

    // "John carry")
    WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/button_country'))

    WebUI.click(findTestObject('Object Repository/Common/Payment_CreditCard/a_United States'))

    WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/button_States'))

    WebUI.click(findTestObject('Object Repository/Common/Payment_CreditCard/a_California'))

    WebUI.setText(findTestObject('Object Repository/Common/Payment_CreditCard/input__Address1'), GlobalVariable.TestData[
        'Address'])

    //"31441 Santa Margarita Pkwy Suite N")
    WebUI.setText(findTestObject('Object Repository/Common/Payment_CreditCard/input__City'), GlobalVariable.TestData['City'])

    // "Ranhco Santa Margarita ")
    WebUI.setText(findTestObject('Object Repository/Common/Payment_CreditCard/input__PostalCode'), GlobalVariable.TestData[
        'PostalCode'])

    WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/input__place-order-button'))

    if (WebUI.verifyElementVisible(findTestObject('Object Repository/ClubCentral/Submit Payment/div_Text_Submit another Payment'))) {
        WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/div_Text_Submit another Payment'))

        GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'User successfully do payment for member  .'
    } else {
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'User can not payment for member .'
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