package com.pageobjects;

import datainstiller.data.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.support.PageObjectModel;
import ui.auto.core.utils.WebHelper;

public class GoogleSearchPO extends PageObjectModel {
    private String searchkey1_txt;
    private String searchkey2_txt;

    @Data(skip = true)
    @FindBy(xpath = "//input[@name='q']")
    private WebElement googleSearchTxtbox;

    @Data(skip = true)
    @FindBy(xpath = "(//a[@class='gb_d'])[1]")
    private WebElement gmailLink;


    @Data(skip = true)
    @FindBy(xpath = "(//input[@name='q']/following::input[@type='submit' and @name='btnK'])[2]")
    private WebComponent googleSearchBtn;

    @Step("{0} Enter search keyword1 in google search box")
    public void searchGoogleKeyword1() {
        googleSearchTxtbox.sendKeys(searchkey1_txt, Keys.ENTER);
    }

    @Step("{0} Enter search keyword2 in google search box")
    public void searchGoogleKeyword2() {
        googleSearchTxtbox.sendKeys(searchkey2_txt, Keys.ENTER);
    }

    @Step("{0} Verify Google Search box page")
    public void verifyGoogleSerch(){
        googleSearchTxtbox.isDisplayed();
        googleSearchBtn.isDisplayed();
        WebHelper.waitForXHR();
    }

    @Step("{0} Click on Gmail Link in Google Search page")
    public void verifyGmailLink(){
        gmailLink.isDisplayed();
        gmailLink.click();
        WebHelper.waitForXHR();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("gmail"), "Verify Gmail URL");
    }

}
