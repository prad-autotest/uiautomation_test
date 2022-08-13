package com.domainobjects;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.pageobjects.GoogleSearchPO;
import com.support.AppHelper;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.AliasedString;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.utils.WebHelper;

@XStreamAlias("googleSerach")
public class GoogleSearchDO extends DomainObjectModel {
    private AliasedString url;
    private GoogleSearchPO googleSearchPO;

    //Default Constructor is needed for data generation facilities
    private GoogleSearchDO() {
    }

    public GoogleSearchDO(TestContext context) {
        this.context = context;
    }

    @Step("{0} user is on google search page")
    public void is_on_google_search_page(String gwt) {
        googleSearchPO.initPage(getContext());
        getDriver().manage().window().maximize();
        getDriver().get("https://www.google.com/");
//        getDriver().get(url.getData());
    }

    @Step("{0} user verify google search page")
    public void is_user_on_google_search_page(String gwt) {
        googleSearchPO.initPage(getContext());
        googleSearchPO.verifyGoogleSerch();
    }

    @Step("{0} user enter keyword1 in google search page")
    public void is_user_keyword1_search_on_google_search_page(String gwt) {
        googleSearchPO.initPage(getContext());
        googleSearchPO.searchGoogleKeyword1();
        WebHelper.waitForXHR();
    }

    @Step("{0} user enter keyword2 in google search page")
    public void is_user_keyword2_search_on_google_search_page(String gwt) {
        googleSearchPO.initPage(getContext());
        googleSearchPO.searchGoogleKeyword2();
        AppHelper.waitForXHR(3);
    }

    @Step("{0} verify gmail link in google search page")
    public void verify_gmaillnk_in_google_search_page(String gwt) {
        googleSearchPO.initPage(getContext());
        googleSearchPO.searchGoogleKeyword2();
        AppHelper.waitForXHR(3);
    }


}
