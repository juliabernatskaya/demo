package com.epam.wdframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KinopoiskFilmPage extends PageObject {

	@FindBy(xpath = "//span[@class='film-rating-value']")
	private WebElement filmRating;

	protected KinopoiskFilmPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getFilmRating() {
		return getElementText(filmRating);
	}
}
