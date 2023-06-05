package Projem;

import Utulity.BaseDriver;
import Utulity.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SwagLabsSenaryo extends BaseDriver {


    @Test
    public void Test1(){

        driver.get("https://www.saucedemo.com/");



        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        MyFunc.bekle(1);

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        MyFunc.bekle(1);

        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        MyFunc.bekle(1);

        //1.ürün
        WebElement BackpackElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        BackpackElement.click();


        WebElement addToCart=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();


        WebElement buttonBack=driver.findElement(By.xpath("//button[text()='Back to products']"));
        buttonBack.click();

        //2.ürün
        WebElement boltTshirtTextElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        boltTshirtTextElement.click();
        MyFunc.bekle(1);

        WebElement addToCart2=driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCart2.click();
        MyFunc.bekle(1);

        //sepete tıklattık
        WebElement sepet=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();
        //MyFunc.Bekle(1);

        WebElement buttonCheckOut=driver.findElement(By.xpath("//button[@id='checkout']"));
        buttonCheckOut.click();
        //MyFunc.Bekle(1);

        // bilgi girişi
        WebElement firstname=driver.findElement(By.xpath("//input[@name='firstName']"));
        firstname.sendKeys("sedat");
        //MyFunc.Bekle(1);

        WebElement lastname=driver.findElement(By.xpath("//input[@id='last-name']"));
        lastname.sendKeys("aksoy");
        //MyFunc.Bekle(1);

        WebElement zipcode=driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipcode.sendKeys("232333");
        //MyFunc.Bekle(1);

        WebElement btnContinue=driver.findElement(By.xpath("//input[@id='continue']"));
        btnContinue.click();
        //MyFunc.Bekle(1);

        // ürünlerin ücretleri
        List<WebElement> ucretler=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double toplam=0;
        for(WebElement e: ucretler)
        {
            //System.out.println(e.getText());  //$29.99
            toplam += Double.parseDouble(e.getText().substring(1));  // [$].""  veya  replace("$","")
        }
        System.out.println("toplam = " + toplam);

        WebElement webAltToplam=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        //System.out.println("webAltToplam = " + webAltToplam.getText());
        double altToplam= Double.parseDouble(webAltToplam.getText().substring(13));
        System.out.println("altToplam = " + altToplam);


        Assert.assertTrue((toplam==altToplam));






        driverBekleKapat();
    }





}
