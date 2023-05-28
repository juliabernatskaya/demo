package com.epam.wdframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class KinopoiskTest {
	WebDriver webDriver = new FirefoxDriver();


	@Test
	void run() throws InterruptedException {
		webDriver.get("https://www.kinopoisk.ru/");
		webDriver.manage().window().maximize();

		KinopoiskHomePage homePage = new KinopoiskHomePage(webDriver);
		var filmPage = homePage.searchFirst("Жить жизнь");

		System.out.println(filmPage.getFilmRating());
		Thread.sleep(5000);
	}

	@AfterMethod(alwaysRun = true)
	void tearDown() {
		webDriver.close();
	}
}
