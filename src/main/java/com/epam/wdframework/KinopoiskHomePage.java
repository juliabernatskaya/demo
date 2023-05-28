package com.epam.wdframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KinopoiskHomePage extends PageObject {

	@FindBy(xpath = "//input[@name='kp_query']")
	private WebElement searchInput;
	@FindBy(xpath = "//div[@data-index='0']")
	private WebElement firstSearchResult;


	protected KinopoiskHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public KinopoiskFilmPage searchFirst(String searchQuery) {
		search(searchQuery);
		return clickFirstResult();
	}

	private KinopoiskHomePage search(String searchQuery) {
		fillForm(searchInput, searchQuery);
		return this;
	}

	private KinopoiskFilmPage clickFirstResult() {
		clickElement(firstSearchResult);
		return new KinopoiskFilmPage(webDriver);
	}
}
