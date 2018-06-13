package com.example.ricardo.features.login;

import com.example.ricardo.model.YellowPeperUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.example.ricardo.matchers.CustomMatchers.*;
import static com.example.ricardo.questions.ResultMessagesQuestions.registrationResultMessage;
import static com.example.ricardo.tasks.LoginTask.loginUsingCredentials;
import static com.example.ricardo.tasks.OpenApplication.opensTheApplication;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class LoginStory {

    private Actor ricardo = Actor.named("ricardo");
    private final String validUsername="testlogin";
    private final String password="1234";


    @Managed
    private WebDriver hisMobileDevice;

    @Before
    public void setUp() {
        givenThat(ricardo.can(BrowseTheWeb.with(hisMobileDevice))).has(opensTheApplication());
    }

    @Test
    public void it_should_login_with_valid_credentials() {
        when(ricardo).attemptsTo(loginUsingCredentials(validUsername,password));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), successfulLoginResult(ricardo.getName()))).waitingForNoLongerThan(20).seconds());
    }

    @Test
    public void it_should_show_error_message_when_login_without_username() {
        when(ricardo).attemptsTo(loginUsingCredentials("",password));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulLoginResultMissingUsername())).waitingForNoLongerThan(20).seconds());
    }

    @Test
    public void it_should_show_error_message_when_login_without_password() {
        when(ricardo).attemptsTo(loginUsingCredentials(validUsername,""));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulLoginResultMissingPassword())).waitingForNoLongerThan(20).seconds());
    }

    @Test
    public void it_should_show_error_message_when_login_without_credentials() {
        when(ricardo).attemptsTo(loginUsingCredentials("",""));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulLoginResultMissingUsername())).waitingForNoLongerThan(20).seconds());
    }

    @Test
    public void it_should_show_error_message_when_login_with_invalid_credentials() {
        String invalidUsername = "non_register_user";
        when(ricardo).attemptsTo(loginUsingCredentials(invalidUsername,password));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulLoginResultBadCredentials())).waitingForNoLongerThan(20).seconds());
    }

    @Test
    public void it_should_show_error_message_when_login_with_invalid_password() {
        when(ricardo).attemptsTo(loginUsingCredentials(validUsername,"3241"));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulLoginResultBadCredentials())).waitingForNoLongerThan(20).seconds());
    }

}
