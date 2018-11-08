package com.ateam.zuml.cinemafinder.navigation;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

@Singleton
public class CiceroneHolder {

    private HashMap<String, Cicerone<Router>> containers;

    @Inject
    CiceroneHolder() {
        containers = new HashMap<>();
    }

    public Cicerone<Router> getCicerone(String containerTag) {
        if (!containers.containsKey(containerTag)) {
            containers.put(containerTag, Cicerone.create());
        }
        return containers.get(containerTag);
    }
}
