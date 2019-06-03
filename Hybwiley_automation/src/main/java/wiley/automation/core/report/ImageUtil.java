package wiley.automation.core.report;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.VariableController;

public class ImageUtil {
	
	//Logger
	//static Logger log = Logger.getLogger(ImageUtil.class);
	static String screenshotFlag= EnvUtil.getProperty("ScreenshotFlag");
	
	
	public static String CaptureScreen(WebDriver driver,String status){
		
		if(screenshotFlag.contains("All")){
			
			String Path;
			DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
			Date screenshotDate = new Date();
			String picName = screenshotName1.format(screenshotDate);
			//String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
			String folderPath =  System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(scrFile, new File(folderPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Path =  System.getProperty("user.dir")+"/output/"+VariableController.getTestCaseName()+"/screenshots/"+picName+".png";
			
			return Path;
			
		}
		
		else if(screenshotFlag.contains("FailOnly")){
			
			if(status.equalsIgnoreCase("fail")){
				
				String Path;
				DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
				Date screenshotDate = new Date();
				String picName = screenshotName1.format(screenshotDate);
				//String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
				String folderPath =  System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				try {
					FileUtils.copyFile(scrFile, new File(folderPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Path = "../"+VariableController.getTestCaseName()+"/screenshots/"+picName+".png";
				
				return Path;
			}
			
		}
		
		
		
		
		return null;
	}
	
	
	
	/*public static String CaptureScreen(WebDriver driver){
		
		
		String Path;
		DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
		Date screenshotDate = new Date();
		String picName = screenshotName1.format(screenshotDate);
		//String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
		String folderPath =  System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(folderPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path = "../"+VariableController.getTestCaseName()+"/screenshots/"+picName+".png";
		
		return Path;
	}*/
/*
public static String CaptureScreenSikuli(){
	String Path;
	DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
	Date screenshotDate = new Date();
	String picName = screenshotName1.format(screenshotDate);
	//String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
	String folderPath =  System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
	Screen s = new Screen();
	//File srcfile;
	BufferedImage imgScreen = s.capture().getImage();
	
	//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	try {
		ImageIO.write(imgScreen, "png", new File(folderPath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Path = "../"+VariableController.getTestCaseName()+"/screenshots/"+picName+".png";
	
	return Path;
}*/
}