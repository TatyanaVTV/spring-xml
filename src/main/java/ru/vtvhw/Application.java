package ru.vtvhw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vtvhw.scopes.MobileApp;
import ru.vtvhw.scopes.MobileMarket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        mobileAppsPublishing(context);
        context.close();
    }

    private static String getMarketName() {
        Properties properties = new Properties();
        try(InputStream propertiesFileIS = Application.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(propertiesFileIS);
            return properties.getProperty("market.name", "ruStore");
        } catch (IOException ex) {
            return "ruStore";
        }
    }

    private static void mobileAppsPublishing(ClassPathXmlApplicationContext context) {
        String marketName = getMarketName();
        System.out.printf("%n-== First request of singleton bean '%s' ==-%n%n", marketName);
        MobileMarket market = context.getBean(marketName, MobileMarket.class);
        MobileApp app;
        for (int i = 1; i < 6; i++) {
            app = context.getBean("mobileApp", MobileApp.class);
            app.setName(app.getName() + " #" + i);
            market.publish(app);
        }
        System.out.println();
        market.printPublishedApps();

        System.out.printf("%n-== Second request of singleton bean '%s' ==-%n%n", marketName);
        market = context.getBean(marketName, MobileMarket.class);
        market.printPublishedApps();
    }
}