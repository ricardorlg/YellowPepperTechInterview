package com.example.ricardo.tasks;

import com.example.ricardo.interactions.FillRegisterForm;
import com.example.ricardo.model.YellowPeperUser;
import com.example.ricardo.ui.RegisterScreen;
import com.example.ricardo.ui.ResultDialog;
import com.example.ricardo.ui.WelcomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.CanBeSilent;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.example.ricardo.matchers.CustomMatchers.notContainsText;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class RegisterTask implements Task {

    private final YellowPeperUser user;

    public RegisterTask(YellowPeperUser user) {
        this.user = user;
    }

    @Override
    @Step("{0} SignUp in the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(WelcomePage.REGISTER_BUTTON),
                FillRegisterForm.withUserData(user),
                Click.on(RegisterScreen.REGISTER_BUTTON)
        );
        WaitUntil.the(ResultDialog.MESSAGE_TITLE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds();
        WaitUntil.the(ResultDialog.MESSAGE_TITLE, notContainsText("Please Wait")).forNoMoreThan(10).seconds();

    }

    public static RegisterTask registerInTheAppWith(YellowPeperUser userInformation) {
        return instrumented(RegisterTask.class, userInformation);
    }


}
