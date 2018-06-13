package com.example.ricardo.tasks;

import com.example.ricardo.interactions.ActivateScreen;
import com.example.ricardo.ui.WelcomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.CanBeSilent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenApplication implements Task, CanBeSilent {
    @Override
    public boolean isSilent() {
        return true;
    }

    @Override
    @Step("{0} Opens the Application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("YellowPepper Test Application"),
                ActivateScreen.activatesScreen(WelcomePage.LOGIN_BUTTON)
        );
    }

    public static OpenApplication opensTheApplication(){
        return Tasks.instrumented(OpenApplication.class);
    }
}
