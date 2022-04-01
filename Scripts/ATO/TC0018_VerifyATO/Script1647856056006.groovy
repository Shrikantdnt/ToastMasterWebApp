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
import com.kms.katalon.entity.global.GlobalVariableEntity

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.fusesource.jansi.internal.Kernel32.CONSOLE_SCREEN_BUFFER_INFO
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.net.URL as URL

try {
    CustomKeywords.'com.application.DateTime.startTime'()

    String COORDINATORORPRESIDENTNAME = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_COORDINATOR OR PRESIDENTS NAME') )

    String PHONE = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_PHONE'))

	String EMAIL = WebUI.getText(findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_EMAIL') )
	
    String ORGANIZATIONNAME = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_ORGANIZATIONNAME') )

    String ADDRESS = WebUI.getText(findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_ADDRESS'))
 
    String COUNTRY = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CoordinatorInformation/div_COUNTRY') )
 
	
     String COUNTRYCA = WebUI.getText(  findTestObject('Object Repository/ATO/VerifyClubDetails/CharterAgreement/div_COUNTRY') )
 
     String CITYCA = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CharterAgreement/div_CITY') )
 
     String STATENANDPROVINCECA = WebUI.getText(findTestObject('Object Repository/ATO/VerifyClubDetails/CharterAgreement/div_STATEPROVINCE') )

     String POSTALCODECA = WebUI.getText( findTestObject('Object Repository/ATO/VerifyClubDetails/CharterAgreement/div_POSTALCODE'))
//  
//    String DATE = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_CA_CL_Date') )
//
//    String MEMBERSHIPCATEGORY = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_CA_CD_MembershipCategory'))
//
//    String LANGAUGEFOROFFICERMANUALS = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_CA_CD_Language'))
//
//    String CharterFee = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_Charter Fee'))
//
//    String Tax = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_Tax'))
//
//    String OrderTotal = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_OrderTotal'))
//
//    String PAYMENTDATE = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_Date') )
//
//    String PAYMENTMETHOD = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_Method') )
//
//    String SHIPPINGADDRESS = WebUI.getText(findTestObject('Object Repository/VerifyATO/span_Payment_ShippingAddress'))
//
//    String CARDNAME = WebUI.getText(findTestObject('Object Repository/VerifyATO/font_Payment_Name'))

	 String PaymentDate = WebUI.getText(findTestObject('Object Repository/ATO/Payment/span_2022-03-26'))
	 String PaymentMethod = WebUI.getText(findTestObject('Object Repository/ATO/Payment/span_CC 22032501686964'))
	 
	
	 
	
	 
	print(COORDINATORORPRESIDENTNAME)
	print(PHONE)
	print(EMAIL)
	print(ORGANIZATIONNAME)
	print(ADDRESS)
	print(COUNTRY)
	
	print(COUNTRYCA)
	print(STATENANDPROVINCECA)
	print(CITYCA)
	print(POSTALCODECA)
	print(PaymentDate)
	print(PaymentMethod)
	
	
	//findTestObject('Object Repository/ATO/Payment/span_2022-03-26')
	
//	findTestObject('Object Repository/ATO/Payment/span_CC 22032501686964')
	
	//findTestObject('ATO/Payment/div_PAYMENT_DATE2022-03-26')
	String ClubID = WebUI.getText( findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/div_Your Club Number CB-07965620') )
	GlobalVariable.ClubIDs = ClubID
println(ClubID)
	println("GClubid"+GlobalVariable.ClubIDs )
	
	
	if (PaymentMethod != null ) {
		//if( COUNTRYCA.contains(GlobalVariable.countryCH)
			//&&CITYCA.contains(GlobalVariable.cityCH)&&POSTALCODECA.contains(GlobalVariable.PostalCode)){
	
			print("PASS......................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
			print(PaymentDate)
			print(PaymentMethod)
			  GlobalVariable.vartestresult = 'PASS'
			 // GlobalVariable.varpassremarks = 'Pay later functionality working scussfully  '+ (GlobalVariable.ClubIDs)
			GlobalVariable.varpassremarks = "ATO is Created Successfully with CreditCard & ClubID-"+GlobalVariable.ClubIDs  + " Payment Mathod -"+PaymentMethod
		 
		   }
		   else{
			   print("FAIL...................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
			GlobalVariable.vartestresult = 'FAIL'
	
			GlobalVariable.varfailremarks = 'ATO is not Created Successfully with CreditCard'
		   }
	 
//       if(COORDINATORORPRESIDENTNAME.contains(GlobalVariable.firstName)&&COORDINATORORPRESIDENTNAME.contains( GlobalVariable.lastNames )&&EMAIL.contains(GlobalVariable.memberEmail)&&PHONE.contains(GlobalVariable.PhoneNumber)
//		   &&ORGANIZATIONNAME.contains("Prospective Club")&&ADDRESS.contains(GlobalVariable.Address)&&ADDRESS.contains(GlobalVariable.citySA)&&COUNTRY.contains(GlobalVariable.countrySA)&&COUNTRYCA.contains(GlobalVariable.countryCH)
//		   &&CITYCA.contains(GlobalVariable.cityCH)&&STATENANDPROVINCECA.contains(GlobalVariable.statesCH)&&POSTALCODECA.contains(GlobalVariable.PostalCode)){
//        &&STATENANDPROVINCECA.contains(GlobalVariable.statesCH)
	
	findTestObject('ATO/Payment/div_PAYMENT METHOD_ CC_ 22032501686964')
	
/*	if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Page_Toastmasters International -Chartering Application/h2_Next Steps'), 120)) {
	//if( COUNTRYCA.contains(GlobalVariable.countryCH)
		//&&CITYCA.contains(GlobalVariable.cityCH)&&POSTALCODECA.contains(GlobalVariable.PostalCode)){

		print("PASS......................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")   
		
		  GlobalVariable.vartestresult = 'PASS'

        GlobalVariable.varpassremarks = 'ATO is Created Successfully with CreditCard'
     
       }
	   else{
		   print("FAIL...................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        GlobalVariable.vartestresult = 'FAIL'

        GlobalVariable.varfailremarks = 'ATO is not Created Successfully with CreditCard'
	   } **/
    
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