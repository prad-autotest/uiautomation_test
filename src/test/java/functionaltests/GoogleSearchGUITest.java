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

public class GoogleSearchGUITest extends TestNGBase {

    @Description("Given that the user is on the Google Search page\n"+
            "When user click on gmail link in Google search page\n"+
            "Then user successfully verify Gmail page \n"
    )
    @Features("Verify Gmail Link in Google Search")
    @Issue("ICCS-4000")
    @Stories("User verify Gmail link in google page")
    @Parameters("data-set")
    @Test
    public void verifyGoogleSearch (@Optional("data/fit/googleSearch_EN.xml") String dataSet ) {
        GoogleSearchDO user = new GoogleSearchDO(getContext()).fromResource(dataSet);
        Given(user::is_on_google_search_page);
        When(user::is_user_on_google_search_page);
    }
}
