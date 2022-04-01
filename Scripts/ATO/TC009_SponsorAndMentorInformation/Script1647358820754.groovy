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

	Thread.sleep(2000)
	
	
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Club')  )
	 
	Thread.sleep(1000)
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Enter Club Name_ClubName'),  GlobalVariable.TestData["ClubName"])
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Search'))
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Cancel_ClbRadioGrp')  )
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Confirm')  )
	
	
	
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Club')  )
	 
	Thread.sleep(1000)
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Club Number')  )
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Enter Club Number_ClubNo') ,  GlobalVariable.TestData["ClubNumber"])
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Search'))
	WebUI.click( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Cancel_ClbRadioGrp')  )
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Confirm')  )
	
	
	Thread.sleep(2000)
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Sponsor')  )
	Thread.sleep(1000)
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input__memberSearchLastName') ,GlobalVariable.TestData["LastName"] )
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input__memberSearchText') , GlobalVariable.TestData["EmailORMemberID"])
	WebUI.click(findTestObject('ATO/Sponsor and Mentor Information/button_MemberSearch')  )
	
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_Search_ClbRadioGrp')  )
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_MemberConfirm')  )
	
	Thread.sleep(2000)
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/a_Add a Mentor')  )
	Thread.sleep(1000)
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input__MentorSearchLastName') ,  GlobalVariable.TestData["LastName"] )
	WebUI.setText( findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input__MentorEmailORMemberIDText') ,  GlobalVariable.TestData["EmailORMemberID"] )
	WebUI.click( findTestObject('ATO/Sponsor and Mentor Information/button_MentorSearch')  )
	
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/input_MentorClbRadioGrp')  )
	WebUI.click(findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_MentorConfirm')  )
	
	WebUI.click(  findTestObject('Object Repository/ATO/Sponsor and Mentor Information/button_Save and Continue')  )
	
	
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/ATO/Payment/button_Validate Address'),150)){
		GlobalVariable.vartestresult = 'PASS'
		GlobalVariable.varpassremarks = ('User Successfully save Sponsor and Mentor information details.')
	} else {
		GlobalVariable.vartestresult = 'FAIL'
		GlobalVariable.varfailremarks = 'User unable save Sponsor and Mentor information details.'
		 
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