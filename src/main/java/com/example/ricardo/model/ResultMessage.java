package com.example.ricardo.model;

import java.util.Objects;

public class ResultMessage {

    private final String tittle;
    private final String message;

    public ResultMessage(String tittle, String message) {
        this.tittle = tittle;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getTittle() {
        return tittle;
    }

    public static class ResultMessagesBuilder {

        public ResultMessage successfulRegistrationResult() {
            return new ResultMessage("Success", "Register successful, please login");
        }

        public ResultMessage missingUserNameRegistrationResult() {
            return new ResultMessage("Error", "Username cannot be missing or blank");
        }

        public ResultMessage missingPasswordRegistrationResult() {
            return new ResultMessage("Error", "Password cannot be missing or blank");
        }

        public ResultMessage successfulLoginResult(String actorName) {
            return new ResultMessage("Success", "Welcome " + actorName);
        }

        public ResultMessage missingUserNameLoginResult() {
            return new ResultMessage("Error", "username is required.");
        }

        public ResultMessage missingPasswordLoginResult() {
            return new ResultMessage("Error", "password is required.");
        }
        public ResultMessage invalidLoginCredentials() {
            return new ResultMessage("Error", "Invalid username/password.");
        }
        public ResultMessage errorWithRegistrationUsernameInUse() {
            return new ResultMessage("Error", "Account already exists for this username.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultMessage)) return false;
        ResultMessage that = (ResultMessage) o;
        return Objects.equals(getTittle(), that.getTittle()) &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTittle(), getMessage());
    }

    @Override
    public String toString() {
        return String.format("Result Message with {tittle='%s', message='%s'}", tittle, message);
    }
}
