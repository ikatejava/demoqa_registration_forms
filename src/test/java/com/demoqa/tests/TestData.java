package com.demoqa.tests;

public class TestData extends TestBase {
    public static String

    userFullName = faker.name().fullName(),

    userEmail = faker.internet().emailAddress(),

    userCurrentAddress = faker.address().secondaryAddress(),
    userPermanentAddress = faker.address().fullAddress(),

    userFirstName = faker.name().firstName(),
    userLastName = faker.name().lastName(),


    userGender = faker.options().option("Male", "Female", "Other"),

    userMobileNumber = faker.phoneNumber().subscriberNumber(10),

    userBirthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"),
    userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2023)),
    userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),

    userSubject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry", "Civics",
                                                 "Commerce", "Computer Science", "Economics", "English",
                                                 "Hindi", "History", "Maths", "Physics", "Social Studies"),

    userHobby = faker.options().option("Sports", "Reading", "Music"),

    userPicture = "iTerkin.jpg",

    userAddress = faker.address().fullAddress(),

    userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),

    randomNCRCity = faker.options().option("Delhi", "Gurgaon", "Noida"),
    randomUttarPradeshCity = faker.options().option("Agra", "Lucknow", "Merrut"),
    randomHaryanaCity = faker.options().option("Karnal", "Panipat"),
    randomRajasthanCity = faker.options().option("Jaipur", "Jaiselmer");

    static String userCity;

    public static String setUserRandomCity(String userRandomState) {
        if (userRandomState == "NCR") {
            userCity = randomNCRCity;
        } else if (userRandomState == "Uttar Pradesh") {
            userCity = randomUttarPradeshCity;
        } else if (userRandomState == "Haryana") {
            userCity = randomHaryanaCity;
        } else {
            userCity = randomRajasthanCity;
        }
        return userCity;
    }
}
