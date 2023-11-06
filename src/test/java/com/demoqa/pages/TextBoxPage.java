package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.tests.TextBoxTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement
        fullName = $("#userName"),
        userEmail = $("#userEmail"),
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

    public TextBoxPage setFullName(String fakerFullName) {
        fullName.setValue(fakerFullName);
        return this;
    }

    public TextBoxPage setUserEmail(String fakerUserEmail) {
        userEmail.setValue(fakerUserEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String fakerCurrentAddress) {
        currentAddress.setValue(fakerCurrentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String fakerPermanentAddress) {
        permanentAddress.setValue(fakerPermanentAddress);
        return this;
    }

    public void pressSubmitButton() {
        submitButton.pressEnter();
    }

    public TextBoxPage checkOutputName(String fakerFullName) {
        outputName.shouldHave(text(fakerFullName));
        return this;
    }

    public TextBoxPage checkOutputEmail(String fakerUserEmail) {
        outputEmail.shouldHave(text(fakerUserEmail));
        return this;
    }

    public TextBoxPage checkOutputCurrentAddress(String fakerCurrentAddress) {
        outputCurrentAddress.shouldHave(text(fakerCurrentAddress));
        return this;
    }

    public TextBoxPage checkOutputPermanentAddress(String fakerPermanentAddress) {
        outputPermanentAddress.shouldHave(text(fakerPermanentAddress));
        return this;
    }
}
