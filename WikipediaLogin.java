package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class WikipediaLogin {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try(FileInputStream fin = new FileInputStream("C:\\Users\\Krushnakant\\Desktop\\Automation\\AmazonLogin\\src\\main\\java\\config\\config.properties")){
            prop.load(fin);
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.findElement(By.xpath(prop.getProperty("loginButton"))).click();
            driver.findElement(By.id(prop.getProperty("loginID"))).sendKeys(prop.getProperty("userID"));
            driver.findElement(By.id(prop.getProperty("loginPassword"))).sendKeys(prop.getProperty("userPassword"));
            driver.findElement(By.id(prop.getProperty("loginBtn"))).click();
            Thread.sleep(3000);
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
