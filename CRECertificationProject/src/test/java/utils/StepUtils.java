package utils;

import org.openqa.selenium.WebElement;

public class StepUtils {
	
	public static void slowSendKeys(String text, WebElement inputTextElement) {
		inputTextElement.clear();
		for (String c : text.split("")) {
			inputTextElement.sendKeys(c);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
		
	}

}
