package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class FormPage {
   private WebDriver driver;

   @FindBy(id = "first-name")
    WebElement firstNameInput;

   @FindBy(id = "last-name")
    WebElement lastNameInput;

   @FindBy(xpath = "//input[@name='gender']/parent::label")
    List<WebElement>  genderRadioLabelList;

    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement>  genderRadioList;

   @FindBy(id = "dob")
    WebElement dateOfBirthInput;

   @FindBy(id = "address")
    WebElement addressInput;

   @FindBy(id = "email")
    WebElement emailInput;

   @FindBy(id = "password")
    WebElement passwordInput;

   @FindBy(id = "company")
    WebElement companyInput;

   @FindBy(id = "role")
   WebElement roleSelect;

   @FindBy(id = "expectation")
    WebElement expectationMultiSelect;

   @FindBy(xpath = "//div[@class='checkbox']")
    List<WebElement> waysOfDevelopmentCheckBoxList;

   @FindBy(xpath = "//div[@class='checkbox']//input")
   List<WebElement> waysOfDevelopmentCheckBoxInputList;

   @FindBy(id = "comment")
    WebElement commentTextArea;

   @FindBy(id = "submit")
    WebElement submitButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName (String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName (String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void chooseGender (String gender){
        int count = 0;
        for (WebElement genderLabel : genderRadioLabelList){
            String label = genderLabel.getText();
            if (gender.equals(label)){
                genderRadioList.get(count).click();
            } else {
                count ++;
            }
        }

    }

    public void setDateOfBirth (String dateOfBirth){
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys(dateOfBirth);
    }

    public void setAddress (String address){
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setEmail (String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword (String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setCompany (String company){
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void chooseRole (String roleName){
        Select role = new Select(roleSelect);
        role.selectByVisibleText(roleName);
    }

    public void selectExpectation (List<String> expectations){
        Select expectationSelect = new Select(expectationMultiSelect);
        if (expectationSelect.isMultiple()){
            expectationSelect.deselectAll();
            List<WebElement> options = expectationSelect.getOptions();
            for (WebElement option : options){
                String optionText = option.getText();
                for (String expectation : expectations){
                    if (optionText.equals(expectation)){
                        option.click();
                    }
                }
            }
        }
    }

    public void selectWaysOfDevelopment (List<String> ways){
        int count = 0;
        for (WebElement waysOfDevelopment : waysOfDevelopmentCheckBoxList){
            String waysString = waysOfDevelopment.getText();
            System.out.println(waysString);

            for (String way : ways){
                if (waysString.equals(way)){
                    waysOfDevelopmentCheckBoxInputList.get(count).click();
                }
            }
            count++;
        }
    }

    public void setComment (String comment){
        commentTextArea.sendKeys(comment);
    }

    public void setSubmit (){
        submitButton.click();
    }

}
