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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    CustomKeywords.'com.application.DPOSCustomKeyword.needSomeHelpCloseButton'()

    /*if (WebUI.verifyElementPresent(findTestObject('Object Repository/ClubCentral/Submit Payment/div_Member has a pending membership'),2 )) {
		WebUI.click( findTestObject('Object Repository/ClubCentral/Submit Payment/a_Submit Payment')  )
	
	}
	 
	else if (WebUI.verifyElementPresent(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/a_Submit Payment'),2 )) {
		WebUI.click( findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/a_Submit Payment')  )
	
	}**/
    //WebUI.click(findTestObject('Object Repository/ClubCentral/Add_Membership/No, Dual_Reinstated Member/a_Submit Payment')  )
    String a = WebUI.getText(findTestObject('Object Repository/ClubCentral/Submit Payment/td_TypeReinstating Member'))

    println('get the value of Type ' + a)

    if (a == 'Reinstating Member') {
        WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date'), 'Apr 01, 2022', 
            false)

        //WebUI.selectOptionByLabel( findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date') ,GlobalVariable.TestData['selectStartDate'] , false)
        //WebUI.selectOptionByLabel( findTestObject('Object Repository/ClubCentral/Submit Payment/select_End Date') , GlobalVariable.TestData['selectEndDate'] , false)
        WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date'), 'Sep 30, 2022', 
            false)

        WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/button_Add to Cart'))
    } else if(a == 'New Member') { 
            WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date'), 
                'Apr 01, 2022', false)

            WebUI.selectOptionByLabel(findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date'), 
                'Sep 30, 2022', false)

            WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/button_Add to Cart'))
         //WebUI.selectOptionByLabel( findTestObject('Object Repository/ClubCentral/Submit Payment/select_Start Date') ,GlobalVariable.TestData['selectStartDate'] , false)
        //WebUI.selectOptionByLabel( findTestObject('Object Repository/ClubCentral/Submit Payment/select_End Date') , GlobalVariable.TestData['selectEndDate'] , false)
	} else {
     WebUI.click( findTestObject('Object Repository/ClubCentral/Submit Payment/button_Add to Cart')  )
    }
    WebUI.click(findTestObject('Object Repository/ClubCentral/Submit Payment/input_Contiunue to payment information'))

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/ClubCentral/Submit Payment/input__place-order-button'), 
        2)) {
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

    WebUI.acceptAlert()
} 

