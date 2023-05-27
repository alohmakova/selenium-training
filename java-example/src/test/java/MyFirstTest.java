import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
  @Test
  public void myFirstTest(){
    driver.get("https://software-testing.ru/");
    wait.until(titleIs("Software-Testing.Ru"));
    driver.get("https://www.google.com/");
    driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
    wait.until(titleIs("webdriver - Google Search"));
  }
  @After
  public void stop(){
    driver.quit();
    driver = null;
  }

}
