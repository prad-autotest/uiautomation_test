package com.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;

import java.util.List;

public class HiddenSelectComponent extends PageComponent {
    private List<WebElement> options;

    @Override
    protected void init() {
        options = coreElement.findElements(By.tagName("option"));
    }

    public void setValue() {
        for (WebElement option :options) {
            if (option.getText().trim().equals(getData())) {
                option.click();
                break;
            }
        }
    }

    public String getValue() {
        return getData(); //Skip validation
    }

    public void validateData(DataTypes dataTypes) {
        Assertions.assertThat(getValue()).isEqualTo(getData(dataTypes));
    }
}
