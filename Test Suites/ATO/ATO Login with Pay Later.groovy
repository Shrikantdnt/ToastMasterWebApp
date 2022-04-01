import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext

import java.beans.Customizer
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.BorderStyle
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import org.openqa.selenium.WebElement as WebElement
 
/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	// Put your code here.
	'Get execution date and time'
	CustomKeywords.'com.application.DateTime.getExecStartTime'()
	
	GlobalVariable.Phase = "Phase1"
	GlobalVariable.G_AppPath = RunConfiguration.getProjectDir()
	GlobalVariable.TestResultFile =GlobalVariable.G_AppPath+"/Data Files/Test_Cases.xlsx"
	GlobalVariable.TestDataFile = GlobalVariable.G_AppPath+"/Data Files/Test_Data.xlsx"
	GlobalVariable.csvPath= GlobalVariable.G_AppPath+"/Data Files/phase_dump.csv"
	
	'Call Fix Test Data'
	CustomKeywords.'com.application.DPOSCustomKeyword.gettestdatafix'()
	
	'Clean exisitng files'
	CustomKeywords.'com.application.DPOSCustomKeyword.CleanExisitingFiles'()
	
	
	'load testdata'
	CustomKeywords.'com.application.DPOSCustomKeyword.gettestdata'()
	
	GlobalVariable.TC=0
	GlobalVariable.GetKeyword = CustomKeywords.'com.application.DPOSCustomKeyword.getKeywordRowNum'();
	println("GlobalVariable.GetKeyword map:"+GlobalVariable.GetKeyword)
	
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {
		
	CustomKeywords.'com.application.DPOSCustomKeyword.csvToExcel'(GlobalVariable.csvPath)
	//CustomKeywords.'com.application.EmailwithHTML.sendemail'()
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = false) // Please change skipped to be false to activate this method.
def setupTestCase() {
	
	GlobalVariable.TC = GlobalVariable.GetKeyword[GlobalVariable.CurrentTestCaseName]
	println("GlobalVariable.TC:"+GlobalVariable.TC )
	GlobalVariable.TestCaseID = "TC_"+GlobalVariable.TC
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = false) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	
	println(GlobalVariable.CurrentTestCaseName)
	if(GlobalVariable.TC != 0)
	{ //Used 0 if No rows found with specific keyword
		//	Write into CSV file.
		CustomKeywords.'com.application.DPOSCustomKeyword.writeCSV'(GlobalVariable.csvPath)
	}else{
		println("*****************<<<<<<<<<<<<<<<<<<<<< NO ROW FOUND WITH THAT SPECIFIC KEYWORD >>>>>>>>>>>>>>>*******************")
	
	}
}