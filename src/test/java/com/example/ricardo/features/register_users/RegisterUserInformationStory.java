package com.example.ricardo.features.register_users;

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
import static com.example.ricardo.tasks.OpenApplication.opensTheApplication;
import static com.example.ricardo.tasks.RegisterTask.registerInTheAppWith;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class RegisterUserInformationStory {
    private Actor ricardo = Actor.named("ricardo");
    @Managed
    private WebDriver hisMobileDevice;

    @Before
    public void setUp() {
        givenThat(ricardo.can(BrowseTheWeb.with(hisMobileDevice))).has(opensTheApplication());
    }


    @Test
    public void it_should_register_user_with_all_fields() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().
                withName(ricardo.getName()).
                withUserName("ricardo_test_user_22").
                withPassword("1234");
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), successfulRegistration())).waitingForNoLongerThan(10).seconds());
    }

    @Test
    public void it_should_register_user_without_name() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().
                withUserName("ricardo_test_user_23").
                withPassword("1234");
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), successfulRegistration())).waitingForNoLongerThan(10).seconds());
    }

    @Test
    public void it_should_not_register_user_without_username() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().
                withPassword("1234");
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulRegistrationMissingUserName())).waitingForNoLongerThan(10).seconds());
    }

    @Test
    public void it_should_not_register_user_without_password() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().
                withUserName("test")
                .build();
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulRegistrationMissingPassword())).waitingForNoLongerThan(10).seconds());
    }

    @Test
    public void it_should_not_register_user_without_information() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().build();
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulRegistrationMissingUserName())).waitingForNoLongerThan(10).seconds());
    }

    @Test
    public void it_should_not_register_user_with_used_username() {
        YellowPeperUser ricardoPersonalInformation = new YellowPeperUser.UserBuilder().
                withName(ricardo.getName()).
                withUserName("testlogin").
                withPassword("1234");
        when(ricardo).attemptsTo(registerInTheAppWith(ricardoPersonalInformation));
        then(ricardo).should(eventually(seeThat("The Result Message ", registrationResultMessage(), unSuccessfulRegistrationUsernameUsed())).waitingForNoLongerThan(10).seconds());
    }
}
