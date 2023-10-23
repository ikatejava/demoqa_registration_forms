package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {
    @Test
    void successfulTextBoxTest() {
        open(baseUrl + "/text-box");

        $("#userName").setValue("Jeffrey Simpson");
        $("#userEmail").setValue("jeff@essenger.net");
        $("#currentAddress").setValue("Sanctum Eternal");
        $("#permanentAddress").setValue("K-PAX");
        $("#submit").pressEnter();

        $("#output #name").shouldHave(text("Name:Jeffrey Simpson"));
        $("#output #email").shouldHave(text("Email:jeff@essenger.net"));
        $("#output #currentAddress").shouldHave(text("Current Address :Sanctum Eternal"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :K-PAX"));
    }
}