package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {
    @Test
    void successfulRegistrationFormTest() {
        open(baseUrl + "/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Jeffrey");
        $("#lastName").setValue("Simpson");
        $("#userEmail").setValue("jeff@essenger.net");

        $("#genterWrapper").$(byText("Other")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("January");

        $("[aria-label='Choose Thursday, January 25th, 1990']").click();
        $("#subjectsInput").setValue("a").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("b").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("c").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("c").setValue("Civics").pressEnter();
        $("#subjectsInput").setValue("c").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("e").setValue("English").pressEnter();
        $("#subjectsInput").setValue("h").setValue("History").pressEnter();
        $("#subjectsInput").setValue("m").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("s").setValue("Social Studies").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("Jeff_Simpson.jpg");

        $("#currentAddress").setValue("Sanctum Eternal");

        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Jeffrey Simpson"),
                text("jeff@essenger.net"), text("Other"), text("Other"),
                text("1234567890"), text("1234567890"), text("25 January,1990"),
                text("Arts, Biology, Chemistry, Civics, Computer Science, " +
                        "English, History, Maths, Social Studies"),
                text("Reading, Music"), text("Jeff_Simpson.jpg"),
                text("Sanctum Eternal"), text("NCR Delhi"));
    }
}
