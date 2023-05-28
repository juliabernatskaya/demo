package com.epam.wdframework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

	protected final WebDriver webDriver;
	protected final WebDriverWait wait;

	protected PageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		init();
	}

	protected void clickElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	protected void fillForm(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	protected String getElementText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	protected void init() {
		PageFactory.initElements(webDriver, this);
	}
}
