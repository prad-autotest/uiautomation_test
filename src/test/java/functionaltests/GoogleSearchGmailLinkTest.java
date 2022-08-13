package functionaltests;

import com.domainobjects.GoogleSearchDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static ui.auto.core.utils.GivenWhenThen.Given;
import static ui.auto.core.utils.GivenWhenThen.When;

public class GoogleSearchGmailLinkTest extends TestNGBase {

    @Description("Given that the user is on the registration page\n"+
            "When they have enter details for registration\n"+
            "Then user have register successfully \n"+
            "And successfully new account created\n"
    )
    @Features("Verify User Google Search")
    @Issue("ICCS-1000")
    @Stories("User search in google page")
    @Parameters("data-set")
    @Test
    public void verifyGmailLinkGoogleSearch (@Optional("data/fit/googleSearch_EN.xml") String dataSet ) {
        GoogleSearchDO user = new GoogleSearchDO(getContext()).fromResource(dataSet);
        Given(user::is_on_google_search_page);
        When(user::is_user_on_google_search_page);
    }
}
