package com.domainobjects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.pageobjects.AuthenticationPO;
import com.pageobjects.CreateAccountPO;
import org.assertj.core.api.Assertions;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.AliasedString;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.utils.WebHelper;

@XStreamAlias("registration")
public class RegistrationBDD extends DomainObjectModel {
    private AliasedString url;
    private AuthenticationPO authenticationPO;
    private CreateAccountPO createAccountPO;

    //Default Constructor is needed for data generation facilities
    private RegistrationBDD() {
    }

    public RegistrationBDD(TestContext context) {
        this.context = context;
    }

    @Step("{0} user is on registration page")
    public void is_on_registration_page(String gwt) {
        authenticationPO.initPage(getContext());
        getDriver().get(url.getData());
    }

    @Step("{0} user verify registration page")
    public void is_user_on_registration_page(String gwt) {
        authenticationPO.initPage(getContext());
        authenticationPO.verifySubmitButton();
    }


    @Step("{0} user provide valid account information")
    public void provide_valid_account_information(String gwt) {
        authenticationPO.initPage(getContext());
        authenticationPO.populateEmail();
        authenticationPO.clickCreateAccount();
        createAccountPO.initPage(getContext());
        createAccountPO.fillForm();
    }

    @Step("{0} user click Register button")
    public void click_register_button(String gwt) {
        createAccountPO.clickRegisterButton();
    }

    @Step("{0} user successfully created new account")
    public void successfully_created_new_account(String gwt) {
        WebHelper.waitForXHR();
        Assertions.assertThat(getDriver().getCurrentUrl()).contains("controller=my-account");
    }
}
