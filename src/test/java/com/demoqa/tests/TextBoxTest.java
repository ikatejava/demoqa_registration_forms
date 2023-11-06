package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class TextBoxTest extends TestBase {
    @Test
    void successfulTextBoxTest() {

        String fakerFullName = faker.name().fullName();
        String fakerUserEmail = faker.internet().emailAddress();
        String fakerCurrentAddress = faker.address().secondaryAddress();
        String fakerPermanentAddress = faker.address().fullAddress();

        step("Open DEMOQA Text Box page", () -> {
            textBoxPage.openTextBoxPage();
        });
        step("Fill in Text Box form", () -> {
            textBoxPage.setFullName(fakerFullName)
                       .setUserEmail(fakerUserEmail)
                       .setCurrentAddress(fakerCurrentAddress)
                       .setPermanentAddress(fakerPermanentAddress)
                       .pressSubmitButton();
        });
        step("Check output meanings", () -> {
            textBoxPage.checkOutputName(fakerFullName)
                       .checkOutputEmail(fakerUserEmail)
                       .checkOutputCurrentAddress(fakerCurrentAddress)
                       .checkOutputPermanentAddress(fakerPermanentAddress);
        });
    }
}