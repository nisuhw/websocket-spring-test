package com.sin.test.service;

import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Room2Service {
    private Broadcaster broadcaster= BroadcasterFactory.getDefault().get("/room2");

    public Broadcaster getBroadcaster() {
        return broadcaster;
    }

    @Scheduled(fixedDelay = 3*1000)
    public void startService() {
        if (!broadcaster.getAtmosphereResources().isEmpty()) {
            broadcaster.broadcast("{data:"+(int)(Math.random()*10000)+"}");
        }
    }
}
