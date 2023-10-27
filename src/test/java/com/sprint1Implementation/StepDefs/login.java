package com.sprint1Implementation.StepDefs;

import com.sprint1Implementation.pages.LoginPage;
import com.sprint1Implementation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import org.checkerframework.checker.units.qual.C;

import javax.naming.CompositeName;

public class login {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Launch login page through Before method (hooks)");
    }
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        String username = null;
        String password = null;

        if(userType.equalsIgnoreCase("user")) {
            username = ConfigurationReader.getProperty("user");
            password = ConfigurationReader.getProperty("user_password");
        }else if(userType.equalsIgnoreCase("employee")){
            username = ConfigurationReader.getProperty("employee");
            password = ConfigurationReader.getProperty("employee_password");
        }
        new LoginPage().login(username, password);
    }


    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

}
