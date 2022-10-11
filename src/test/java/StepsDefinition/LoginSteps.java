package StepsDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Before
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/amanda_cavalcante/eclipse-workspace/NetlixTests/src/test/resources/Driver/chromedriver.exe" );
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	@Given("user is on Youtube page")
	public void user_is_on_youtube_page() {
	    driver.navigate().to("https://www.youtube.com/");
	}
	@Given("user clicks on login")
	public void user_clicks_on_login() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button/yt-formatted-string")));
		WebElement login =driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button/yt-formatted-string"));
		login.click();
	}

	@When("user enters a valid email")
	public void user_enters_a_valid_email() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")));
	    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("testandocomatici");
	    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
	}

	@When("user enters a valid password")
	public void user_enters_a_valid_password() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Testes1234!");
	    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
	}

	@Then("user is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[1]/ytd-topbar-logo-renderer/a/div/ytd-logo/yt-icon")));
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/");
	    
	}
	@When("user enters a invalid {string}")
	public void user_enters_a_invalid(String string) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")));
	    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(string);
	}

	@When("user clicks on Next button")
	public void user_clicks_on_next_button() {
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
	}

	@Then("a error message invalid account is raised")
	public void a_error_message_invalid_account_is() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Digite um e-mail ou número de telefone válido\"]")));
	    Assert.assertEquals(driver.findElement(By.xpath("//*[text()=\"Digite um e-mail ou número de telefone válido\"]")).getText(), "Digite um e-mail ou número de telefone válido");
	}

	@When("user enters a invalid  password {string}")
	public void user_enters_a_invalid_password(String string) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(string);
	    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
		
	}
	@Then("a error message invalid password is raised")
	public void a_error_message_invalid_password() {
			
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"Senha incorreta\")]")));
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),\"Senha incorreta\")]")).getText(), "Senha incorreta. Tente novamente ou clique em \"Esqueceu a senha?\" para escolher uma outra.");
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
