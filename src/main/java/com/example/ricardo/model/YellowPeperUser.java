package com.example.ricardo.model;

import java.util.Objects;

public class YellowPeperUser {
    private final String name;
    private final String userName;
    private final String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public YellowPeperUser() {
        this.name = "";
        this.userName = "";
        this.password = "";
    }

    public YellowPeperUser(String name, String username, String password) {
        this.name = name;
        this.userName = username;
        this.password = password;
    }

    public YellowPeperUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.name = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YellowPeperUser)) return false;
        YellowPeperUser that = (YellowPeperUser) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getUserName(), getPassword());
    }

    @Override
    public String toString() {
        return String.format("Personal Information{name='%s', userName='%s', password='%s'}", name, userName, password);
    }

    public static class UserBuilder {
        private String name = "";
        private String userName = "";
        private String password = "";

        public UserBuilder() {
        }

        public UserBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public YellowPeperUser withPassword(String password) {
            this.password = password;
            return build();
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public YellowPeperUser build(){
            return new YellowPeperUser(name, userName, password);
        }
    }
}
