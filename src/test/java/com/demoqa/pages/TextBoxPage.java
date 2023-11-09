package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement
            fullName = $("#userName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public void openTextBoxPage() {
        open(baseUrl + "/text-box");
    }

    public TextBoxPage setFullName(String userFullName) {
        fullName.setValue(userFullName);
        return this;
    }

    public TextBoxPage setEmail(String userEmail) {
        email.setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String userCurrentAddress) {
        currentAddress.setValue(userCurrentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String userPermanentAddress) {
        permanentAddress.setValue(userPermanentAddress);
        return this;
    }

    public void pressSubmitButton() {

        submitButton.pressEnter();
    }

    public TextBoxPage checkOutputName(String userFullName) {
        outputName.shouldHave(text(userFullName));
        return this;
    }

    public TextBoxPage checkOutputEmail(String userEmail) {
        outputEmail.shouldHave(text(userEmail));
        return this;
    }

    public TextBoxPage checkOutputCurrentAddress(String userCurrentAddress) {
        outputCurrentAddress.shouldHave(text(userCurrentAddress));
        return this;
    }

    public void checkOutputPermanentAddress(String userPermanentAddress) {
        outputPermanentAddress.shouldHave(text(userPermanentAddress));
    }
}
