package com.example.ricardo.interactions;

import com.example.ricardo.model.YellowPeperUser;
import com.example.ricardo.ui.RegisterScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillRegisterForm implements Interaction {

    private YellowPeperUser user;

    public FillRegisterForm(YellowPeperUser user) {
        this.user = user;
    }

    @Override
    @Step("{0} Fills the Register Form with his #user")
    public <T extends Actor> void performAs(T actor) {
        RegisterScreen.NAME_FIELD.resolveFor(actor).type(user.getName());
        RegisterScreen.USERNAME_FIELD.resolveFor(actor).type(user.getUserName());
        RegisterScreen.PASSWORD_FIELD.resolveFor(actor).type(user.getPassword());
    }

    public static Interaction withUserData(YellowPeperUser user) {
        return instrumented(FillRegisterForm.class, user);
    }
}
