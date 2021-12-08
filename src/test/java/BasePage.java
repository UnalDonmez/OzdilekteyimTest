//import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.assertj.core.api.AssertionInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.apache.log4j.Logger;

import javax.xml.bind.Element;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest{

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Step("<logo> uygulamanın açıldığını kontrol et")
    public void AppStartCheck(String logoImg){
        Assert.assertTrue("Uygulama baslatilamadi!!!",appiumDriver.findElement(By.id(logoImg)).isDisplayed());
        logger.info("Uygulama acildi");
    }

    @Step("<idControl> id kotrol et")
    public void HomeChec(String HpCheck){
        Assert.assertTrue("Anasayfaya girilemedi!!!",appiumDriver.findElement(By.id(HpCheck)).isDisplayed());
        logger.info("Alisveris sayfasi acildi.");
    }

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(1000*wait);
        logger.info(wait + "saniye beklendi.");

    }

    @Step("<selectorid> id'li elemente tıkla")
    public void clickByid(String selectorid){
        appiumDriver.findElement(By.id(selectorid)).click();
        logger.info(selectorid + "elentine tıklandı.");
    }

    @Step("<selectorid> id'li elemente tıklat")
    public void clickByidKategori(String selectorid){
        appiumDriver.findElement(By.id(selectorid)).click();
        logger.info(selectorid + "elentine tıklandı.");
    }

    @Step("<xpath> kategori sayfasini kontrol et")
    public void searchInput(String kategoriItem) {
        Assert.assertTrue("Kategori sayfasi acilmadi!!!", appiumDriver.findElement(By.id(kategoriItem)).isDisplayed());
        logger.info("Search input bulundu");
    }

    @Step("<xpath> kadin elemente tıklayın")
    public void clickByxpathKadin(String selectxPath){
        appiumDriver.findElement(By.xpath(selectxPath)).click();
        logger.info(selectxPath + "elentine tıklandı.");
    }

    @Step("<xpath> pantolon elemente tıklayın")
    public void clickByxpathPantolon(String selectxPath){
        appiumDriver.findElement(By.xpath(selectxPath)).click();
        logger.info(selectxPath + "elentine tıklandı.");
    }

    @Step("<scroll et>")
    public void scrollEt(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(540,1900)).moveTo(PointOption.point(540,700)).release().perform();
        logger.info("Scroll yapıldı.");
    }

    @Step("rastgele urun sec")
    public void selectRandomElement() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
        logger.info("Rastgele ürün secimi yapildi.");
    }

    @Step("<idControl> detay kontrolü")
    public void DetayUrurn(String detayId){
        Assert.assertTrue("Urun detay kontrolü",appiumDriver.findElement(By.id(detayId)).isDisplayed());
        logger.info("Detay kontolü yapıldı");
    }

    @Step("<element> favoriye ekle")
    public void FavEkle(String favId){
        appiumDriver.findElement(By.id(favId)).click();
        System.out.println("favorilere eklendi");
        logger.info("ürün favorilere eklendi.");
    }

    @Step("<element> giris sayfasını komtrol et")
    public void GirisKontol(String girisId){
        Assert.assertTrue("Giris sayfasi acilmadi",appiumDriver.findElement(By.id(girisId)).isDisplayed());
        logger.info("Sayfa girişi kontrol edildi");
    }

    @Step("<id> id'li elemente <mail> mail girin")
    public void KullaniciAdi(String mailId,String mailText){
        appiumDriver.findElement(By.id(mailId)).sendKeys(mailText);
        logger.info("Kullanıcı maili girildi");
    }

    @Step("<id> 'li elemente kullanici <sifre> sifre girin")
    public void KullaniciSifre(String sifreId, String sifreText){
        appiumDriver.findElement(By.id(sifreId)).sendKeys(sifreText);
        logger.info("Kullanıcı sifresi girildi");
    }

    @Step("<id> 'li elente tıklarak geri dön")
    public  void BackBtn(String backBtn){

        appiumDriver.findElement(By.id(backBtn)).click();
        logger.info("Geri tusuna basildi");
    }

    @Step("<element> sepete ekleme yap")
    public  void AddToCart(String sepetId){
        appiumDriver.findElement(By.id(sepetId)).click();
        logger.info("Sepete ekle tusuna basildi");
    }

}
