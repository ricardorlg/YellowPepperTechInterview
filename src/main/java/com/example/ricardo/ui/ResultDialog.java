package com.example.ricardo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultDialog {
    public static final Target MESSAGE_TITLE = Target.the("Result Message Title").located(
           By.id("android:id/alertTitle"));
    public static final Target MESSAGE_CONTENT = Target.the("Result Message Description").located(
            By.id("android:id/message"));
    public static final Target PROGRESS_ICON = Target.the("Progress Icon").located(
            By.id("android:id/progress"));
}
