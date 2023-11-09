package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.VerifyResultsComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    VerifyResultsComponent verifyResultsComponent = new VerifyResultsComponent();

    SelenideElement
            registrationForm = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            userGenderChoice = $("#genterWrapper"),
            mobileNumber = $("#userNumber"),
            birthdateInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            userHobbyChoice = $("#hobbiesWrapper"),
            userPictureUpload = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            stateCityChoice = $("#stateCity-wrapper"),
            userStateChoice = stateCityChoice.$("#state"),
            userCityChoice = stateCityChoice.$("#city"),
            submitButton = $("#submit"),
            completedForm = $(".modal-content"),
            completedFormHeader = $(".modal-header");


    public void openRegistrationPage() {
        open(baseUrl + "/automation-practice-form");
        registrationForm.shouldHave(text("Student Registration Form"));
    }

    public void closeAds() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage setFirstName(String userFirstName) {
        firstName.setValue(userFirstName);
        return this;
    }

    public RegistrationPage setLastName(String userLastName) {
        lastName.setValue(userLastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        email.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserGender(String userGender) {
        userGenderChoice.$(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setMobileNumber(String userMobileNumber) {
        mobileNumber.setValue(userMobileNumber);
        return this;
    }

    public RegistrationPage setUserBirthdate(String userBirthMonth, String userBirthYear,
                                             String userBirthDay) {
        birthdateInput.click();
        calendarComponent.setDate(userBirthMonth, userBirthYear, userBirthDay);
        return this;
    }

    public RegistrationPage setUserSubject(String userSubject) {
        userSubjectInput.setValue(userSubject).pressEnter();
        return this;
    }

    public RegistrationPage setUserHobby(String userHobby) {
        userHobbyChoice.$(byText(userHobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String userPicture) {
        userPictureUpload.uploadFromClasspath(userPicture);
        return this;
    }

    public RegistrationPage setUserCurrentAddress(String userAddress) {
        userCurrentAddress.setValue(userAddress);
        return this;
    }

    public RegistrationPage setUserState(String userState) {
        userStateChoice.click();
        stateCityChoice.$(byText(userState)).click();
        return this;
    }

    public RegistrationPage setUserCity(String userCity) {
        userCityChoice.click();
        stateCityChoice.$(byText(userCity)).click();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkCompletedForm() {
        completedForm.should(appear);
        completedFormHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public RegistrationPage verifyResults(String key, String value) {
        verifyResultsComponent.verifyTableResults(key, value);
        return this;
    }
}
