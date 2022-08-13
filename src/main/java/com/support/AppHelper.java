package com.support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.TestContext;
import ui.auto.core.utils.WebHelper;

public class AppHelper {
    public  static void waitForXHR(int times) {
        for(int i = 0; i< times; i++) {
            WebHelper.sleep(200);
            try{
                WebHelper.waitForXHR();
            } catch (Exception ignore) {

            }
        }
    }

    //unused
    @Step("{0}")
    public static void virtualStep(String msg, Runnable r) {
        r.run();
    }

    public static void scrollToView(WebElement el) {
        ((JavascriptExecutor) WebHelper.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", el);
        WebHelper.sleep(500);
    }

    private  static  void highlightElement(WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor) WebHelper.getWebDriver();
        executor.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;')",el);
    }

    public static void clickWithJS(WebElement el) {
        WebDriver driver = WebHelper.getWebDriver();
        scrollToView(el);
        WebDriverWait wait = new WebDriverWait(driver, TestContext.getTestProperties().getElementTimeout());
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(el), ExpectedConditions.elementToBeClickable(el)));
        highlightElement(el);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", el);
    }

    public static void clickMega(WebElement el) {
        AppHelper.waitForXHR(2);
        try{
            scrollToView(el);
            el.click();
        } catch (Exception e) {
            try {
                clickWithJS(el);
            } catch (Exception e2) {

            }
            AppHelper.waitForXHR(2);
         }
    }

}