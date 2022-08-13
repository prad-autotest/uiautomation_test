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

import static ui.auto.core.utils.GivenWhenThen.*;

public class GoogleSearch2Test extends TestNGBase {

    @Description("Given that the user is on the registration page\n"+
            "When they have enter details for registration\n"+
            "Then user have register successfully \n"+
            "And successfully new account created\n"
    )
    @Features("Verify User Google Search")
    @Issue("ICCS-2000")
    @Stories("User search in google page")
    @Parameters("data-set")
    @Test
    public void verifyGoogleSearch (@Optional("data/fit/googleSearch_EN.xml") String dataSet ) {
        GoogleSearchDO user = new GoogleSearchDO(getContext()).fromResource(dataSet);
        Given(user::is_on_google_search_page);
        When(user::is_user_on_google_search_page);
        And(user::is_user_keyword2_search_on_google_search_page);

    }
}
