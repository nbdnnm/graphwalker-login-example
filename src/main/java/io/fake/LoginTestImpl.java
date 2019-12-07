package io.fake;

import com.codeborne.selenide.Configuration;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@GraphWalker(value = "random(time_duration(30))")
public class LoginTestImpl extends ExecutionContext implements io.fake.LoginTest {
    public void Input_empty_credentials() {
        $("#username").sendKeys("");
        $("#password").sendKeys("");
        $(".radius").click();
    }

    public void Input_incorrect_username() {
        $("#username").sendKeys("sgregerg");
        $(".radius").click();
    }

    public void Login_page_opened_User_logged_out() {
        $(".example > h2:nth-child(1)")
                .shouldHave(text("Login Page"));
    }

    public void Log_out() {
        $(".button").click();
    }

    public void Input_incorect_password() {
        $("#username").sendKeys("tomsmith");
        $("#password").sendKeys("fwfwe");
        $(".radius").click();
    }

    public void Input_correct_credentials() {
        $("#username").sendKeys("tomsmith");
        $("#password").sendKeys("SuperSecretPassword!");
        $(".radius").click();
    }

    public void Open_login_page() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        open("/login");
    }

    public void User_logged_in() {
        $(".example > h2:nth-child(1)")
                .shouldHave(text("Secure Area"));
    }

    public void Wrong_username() {
        $("#flash")
                .shouldHave(text("Your username is invalid!"));
    }

    public void Wrong_password() {
        $("#flash")
                .shouldHave(text("Your password is invalid!"));
    }
}
