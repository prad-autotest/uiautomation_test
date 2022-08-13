package com.pageobjects;

import datainstiller.data.Data;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.support.PageObjectModel;
import ui.auto.core.utils.WebHelper;

public class AuthenticationPO extends PageObjectModel {
    private WebComponent email_create;
    @Data(skip = true)
    @FindBy(id = "SubmitCreate")
    private WebComponent submit;

    @Step("{0} Populate email field.")
    public void populateEmail() {
        setElementValue(email_create);
    }

    @Step("{0} Click 'Create an account' button")
    public void clickCreateAccount(){
        submit.click();
        WebHelper.waitForXHR();
        waitForUrl("back=my-account#account-creation");
    }

    @Step("{0} Verify submit button")
    public void verifySubmitButton(){
        submit.isDisplayed();
        WebHelper.waitForXHR();
    }

}
