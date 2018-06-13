package com.example.ricardo.ui;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {
    public static final Target USERNAME_FIELD = Target.the("Username login Field").located(
            MobileBy.AccessibilityId("username_text"));
    public static final Target PASSWORD_FIELD = Target.the("Password login Field").located(
            MobileBy.AccessibilityId("password_text"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(
            By.id("com.yellowpepper.automation_test:id/loginButton"));
}
