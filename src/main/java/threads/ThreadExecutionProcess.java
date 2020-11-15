package threads;

import lombok.SneakyThrows;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThreadExecutionProcess implements Runnable{

    private String name;

    public ThreadExecutionProcess(String currentName) {
        this.name = currentName;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.setProperty("webdriver.gecko.driver","/home/arkadeep/Downloads/geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://docs.google.com/forms/d/e/1FAIpQLScDcaKz5tligNde2NqLKjJRGy8fV4AxPJKhsCsiB-cxsnexIg/viewform");
        WebElement textBox = webDriver.findElement(By.xpath("//div[@class='quantumWizTextinputPapertextareaContentArea exportContentArea']/textarea"));
        textBox.sendKeys(WordUtils.capitalizeFully(name) + " is cute!");
        WebElement submit = webDriver.findElement(By.xpath("//span[@class='appsMaterialWizButtonPaperbuttonContent exportButtonContent']/span"));
        submit.click();
        Thread.sleep(2000);
        webDriver.close();
    }
}
