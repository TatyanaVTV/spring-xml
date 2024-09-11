package ru.vtvhw.scopes;

import java.util.ArrayList;
import java.util.List;

public class RuStoreMarket implements MobileMarket {
    private String name;
    private List<MobileApp> apps = new ArrayList<>();

    public RuStoreMarket(String name) {
        this.name = name;
    }

    @Override
    public void publish(MobileApp app) {
        apps.add(app);
    }

    @Override
    public void printPublishedApps() {
        System.out.printf("Market '%s': %n");
        apps.forEach(System.out::println);
    }
}
