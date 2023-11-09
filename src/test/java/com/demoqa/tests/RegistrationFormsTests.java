package com.demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormsTests extends TestBase {
    @Test
    @Tag("simple")
    void successfulTextBoxTest() {

        step("Open DEMOQA Text Box page", () -> {
            textBoxPage.openTextBoxPage();
        });
        step("Fill in Text Box form", () -> {
            textBoxPage.setFullName(userFullName)
                    .setEmail(userEmail)
                    .setCurrentAddress(userCurrentAddress)
                    .setPermanentAddress(userPermanentAddress)
                    .pressSubmitButton();
        });
        step("Check output meanings", () -> {
            textBoxPage.checkOutputName(userFullName)
                    .checkOutputEmail(userEmail)
                    .checkOutputCurrentAddress(userCurrentAddress)
                    .checkOutputPermanentAddress(userPermanentAddress);
        });
    }

    @Test
    @Tag("sophisticated")
    void successfulRegistrationFormTest() {

        step("Open DEMOQA Student Registration page", () -> {
            registrationPage.openRegistrationPage();
        });
        step("Close advertisements on the page", () -> {
            registrationPage.closeAds();
        });
        step("Fill in Student Registration Form", () -> {
            registrationPage.setFirstName(userFirstName)
                    .setLastName(userLastName)
                    .setEmail(userEmail)
                    .setUserGender(userGender)
                    .setMobileNumber(userMobileNumber)
                    .setUserBirthdate(userBirthMonth, userBirthYear,
                            userBirthDay)
                    .setUserSubject(userSubject)
                    .setUserHobby(userHobby)
                    .uploadPicture(userPicture)
                    .setUserCurrentAddress(userAddress)
                    .setUserState(userState)
                    .setUserCity(setUserRandomCity(userState))
                    .clickSubmitButton();
        });
        step("Check completed form", () -> {
            registrationPage.checkCompletedForm();
        });
        step("Verify results", () -> {
            registrationPage.verifyResults("Student Name", userFirstName + " " + userLastName)
                    .verifyResults("Student Email", userEmail)
                    .verifyResults("Gender", userGender)
                    .verifyResults("Mobile", userMobileNumber)
                    .verifyResults("Date of Birth", userBirthDay + " " + " "
                            + userBirthMonth + "," + userBirthYear)
                    .verifyResults("Subjects", userSubject)
                    .verifyResults("Hobbies", userHobby)
                    .verifyResults("Picture", userPicture)
                    .verifyResults("Address", userAddress)
                    .verifyResults("State and City", userState + " " + userCity);
        });
    }
}