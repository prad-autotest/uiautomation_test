package com.tests;

import com.domainobjects.RegistrationBDD;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ui.auto.core.testng.TestNGBase;


import static ui.auto.core.utils.GivenWhenThen.*;

public class TestRegistrationBDD extends TestNGBase {

    @Description("Given that the user is on the registration page\n"+
            "When they have enter details for registration\n"+
            "Then user have register successfully \n"+
            "And successfully new account created\n"
    )
    @Features("New account creation")
//    @Severity("Critical")
    @Issue("ICCS-1000")
    @Stories("User registration and new account creation")
    @Parameters("data-set")
    @Test
    public void testForValidRegistrationBDD (@Optional("data/fit/registration_data_dynamic.xml") String dataSet ) {
        RegistrationBDD user = new RegistrationBDD(getContext()).fromResource(dataSet);
        Given(user::is_on_registration_page);
        When(user::provide_valid_account_information);
        And(user::click_register_button);
        Then(user::successfully_created_new_account);
    }
}
