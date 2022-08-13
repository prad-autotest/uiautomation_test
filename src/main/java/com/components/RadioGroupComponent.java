package com.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;

import java.util.List;

public class RadioGroupComponent extends PageComponent {

    @Override
    protected void init() {
    }

    public void setValue() {
        By by = By.xpath(".//div[contains(.,'" + getData() + "')]");
        WebElement el = coreElement.findElement(by);
        if (!el.isSelected()) {
            el.click();
        }
    }

    public String getValue() {
        By by = By.xpath(".//span[@class='checked']/../../../label");
        long t_o = System.currentTimeMillis() + 5000;
        List<WebElement> elements;
        do {
            elements = coreElement.findElements(by);
        } while (elements.isEmpty() || !elements.get(0).isDisplayed() && System.currentTimeMillis() < t_o);
        return elements.get(0).getText().trim();
    }

    public void validateData(DataTypes dataTypes) {
        Assertions.assertThat(getValue()).isEqualTo(getData(dataTypes));
    }
}
