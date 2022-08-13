package com.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;

public class CheckboxComponent extends PageComponent {
    @Override
    protected void init() {
    }

    public void setValue() {
        if (!getValue().equals(getData())) {
            coreElement.click();
        }
    }

    public String getValue() {
        return Boolean.toString(coreElement.findElement(By.tagName("input")).isSelected());
    }

    public void validateData(DataTypes dataTypes) {
        Assertions.assertThat(getValue()).isEqualTo(getData(dataTypes));
    }
}
