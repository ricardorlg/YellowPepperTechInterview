package com.example.ricardo.ui;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterScreen {
    public static final Target NAME_FIELD = Target.the("Name Field").located(
            MobileBy.AccessibilityId("name_text"));
    public static final Target USERNAME_FIELD = Target.the("Username Field").located(
            MobileBy.AccessibilityId("username_text"));
    public static final Target PASSWORD_FIELD = Target.the("Password Field").located(
            MobileBy.AccessibilityId("password_text"));
    public static final Target REGISTER_BUTTON = Target.the("Register button").located(
            MobileBy.AccessibilityId("register_button"));

}
