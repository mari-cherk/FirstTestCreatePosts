
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.DriverManager;
import java.time.Duration;

public class FirstTestCreatePosts {

    WebDriver driver = null;


    @Test
    public void signIn(){

    System.setProperty("webdriver.chrome.driver", new File(DriverManager.class.getResource("/chromedriver.exe").getFile()).getPath());
    driver = new ChromeDriver();

    driver.get("https://ah-test-mt-test1.cloud.answerhub.com");
    driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));

        WebElement userNameField = driver.findElement(By.xpath("//*[@id='username']"));
        userNameField.sendKeys("marinac");

        WebElement userPasswordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        userPasswordField.sendKeys("654321");

        WebElement signInButton = driver.findElement(By.xpath("//*[@type='submit']"));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create-button']")));


   // }

   // @Test
   // public void createQuestion(){

        WebElement createButton = driver.findElement(By.xpath("//*[@id='create-button']"));
        createButton.click();

       // WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='title']")));

        WebElement questionNameField = driver.findElement(By.xpath("//*[@id='title']"));
        questionNameField.sendKeys("The newest question from marinac for today");

        WebElement questionBodyField = driver.findElement(By.xpath("//*[@class='fr-element fr-view']"));
        questionBodyField.sendKeys("The newest question from marinac for today");

        WebElement topicField = driver.findElement(By.xpath("//*[@id='s2id_autogen1']"));
        topicField.sendKeys("qa");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-result-label' and contains(text(),'qa')]")));
        WebElement neededTopic = driver.findElement(By.xpath("//*[@class='select2-result-label' and contains(text(),'qa')]"));
        neededTopic.click();

        WebElement spaceField = driver.findElement(By.xpath("//*[@id='space_select']"));
        spaceField.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='awesomplete_list_1_item_0']")));
        WebElement neededSpace = driver.findElement(By.xpath("//*[@id='awesomplete_list_1_item_0']"));
        neededSpace.click();

        WebElement postQuestionBtn = driver.findElement(By.xpath("//*[@id='submit-question']"));
        postQuestionBtn.click();

        WebElement questionPostedMessage = driver.findElement(By.xpath("//*[contains(text(),'Your question was successfully posted!')]"));
        String questionPostedMessageText = questionPostedMessage.getText();
        Assert.assertTrue(true,questionPostedMessageText);



    }



}
