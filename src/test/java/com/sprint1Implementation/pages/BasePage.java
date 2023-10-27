package com.sprint1Implementation.pages;

import com.sprint1Implementation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
