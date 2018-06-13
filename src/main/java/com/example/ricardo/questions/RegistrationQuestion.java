package com.example.ricardo.questions;

import com.example.ricardo.model.ResultMessage;
import com.example.ricardo.ui.ResultDialog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegistrationQuestion implements Question<ResultMessage> {
    @Override
    public ResultMessage answeredBy(Actor actor) {

        String title = Text.of(ResultDialog.MESSAGE_TITLE).viewedBy(actor).asString();
        String content = Text.of(ResultDialog.MESSAGE_CONTENT).viewedBy(actor).asString();
        return new ResultMessage(title, content);
    }

}
