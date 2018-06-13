package com.example.ricardo.tasks;

import com.example.ricardo.model.YellowPeperUser;
import com.example.ricardo.ui.LoginScreen;
import com.example.ricardo.ui.ResultDialog;
import com.example.ricardo.ui.WelcomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.example.ricardo.matchers.CustomMatchers.notContainsText;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {

    private final String username;
    private final String password;


    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} Login in the system using username=#username and password=#password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(WelcomePage.LOGIN_BUTTON),
                Enter.theValue(username).into(LoginScreen.USERNAME_FIELD),
                Enter.theValue(password).into(LoginScreen.PASSWORD_FIELD),
                Click.on(LoginScreen.LOGIN_BUTTON)
        );
        WaitUntil.the(ResultDialog.MESSAGE_TITLE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds();
        WaitUntil.the(ResultDialog.MESSAGE_TITLE, notContainsText("Please Wait")).forNoMoreThan(20).seconds();

    }

    public static LoginTask loginUsingCredentials(String username,String password) {
        return instrumented(LoginTask.class, username,password);
    }
}
