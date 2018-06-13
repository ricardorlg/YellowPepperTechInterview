package com.example.ricardo.ui;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class WelcomePage {

    public static final Target REGISTER_BUTTON = Target.the("Register Field").located(
            MobileBy.AccessibilityId("register_button"));

    public static final Target LOGIN_BUTTON = Target.the("Login Field").located(
            MobileBy.AccessibilityId("login_button"));

}
