package akstas84.qa.tests.demoqa;

import akstas84.qa.tests.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

  Faker faker = new Faker();

  String firstName = faker.name().firstName(),
          lastName = faker.name().lastName(),
          email = faker.internet().emailAddress(),
          gender = "Other",
          mobile = faker.number().digits(10),
          dayOfBirth = "05",
          monthOfBirth = "April",
          yearOfBirth = "1990",
          subject1 = "Chemistry",
          subject2 = "Commerce",
          hobby1 = "Sports",
          hobby2 = "Reading",
          hobby3 = "Music",
          picture = "1.png",
          currentAddress = faker.address().fullAddress(),
          state = "Uttar Pradesh",
          city = "Merrut";

  @Test
  void successfullFillFormTest(){
    step("Open Student registration form", () -> {
    open("https://demoqa.com/automation-practice-form");
      $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
  });

    step("Fill studens registration form", ()-> {
      step("Fill common data", ()-> {
          $("#firstName").val(firstName);
          $("#lastName").val(lastName);
          $("#userEmail").val(email);
          $("#genterWrapper").$(byText(gender)).click();
          $("#userNumber").val(mobile);
      });
      step("Set date", ()-> {
          $("#dateOfBirthInput").clear();
          $(".react-datepicker__month-select").selectOption(monthOfBirth);
          $(".react-datepicker__year-select").selectOption(yearOfBirth);
          $(".react-datepicker__day--0" + dayOfBirth).click();
      });
      step("Set subject", ()-> {
        $("#subjectsInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();

      });
      step("Set hobbies", ()-> {
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
      });
      step("Upload image", ()->
        $("#uploadPicture").uploadFromClasspath("img/" + picture));
      step("Set address", ()-> {
        $("#currentAddress").val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText(city)).click();
      });
      step("Submit form", () ->
              $("#submit").click());
      });

    step("Verify successful form submit", () -> {
      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    });
  }
}
