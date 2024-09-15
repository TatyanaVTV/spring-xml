package ru.vtvhw.scopes;

import java.util.ArrayList;
import java.util.List;

public class GooglePlayMarket implements MobileMarket {
    private String name;
    private ApiKey apiKey;
    private List<MobileApp> apps = new ArrayList<>();

    public GooglePlayMarket(ApiKey apiKey) {
        this.name = "Google Play";
        this.apiKey = apiKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void publish(MobileApp app) {
        apps.add(app);
    }

    @Override
    public void printPublishedApps() {
        System.out.printf("%s: %n", this);
        apps.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return String.format("Market '%s' (%s) [%s]", name, apiKey, super.toString());
    }
}
