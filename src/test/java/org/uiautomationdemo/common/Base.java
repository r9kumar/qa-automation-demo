package org.uiautomationdemo.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    private String sessionId;
    protected WebDriver driver;

    @Rule
    public final TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Before
    public void setUp() throws Exception {
        String browserName = System.getProperty("browserName");

        driver = BrowserFactory.getBrowser(browserName);

        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
        driver.manage().timeouts().implicitlyWait(Wait.EXPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Override
    public String getSessionId() {
        return this.sessionId;
    }
}