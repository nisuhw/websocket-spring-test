package com.sin.test.service;

import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Room1Service {

    @Scheduled(fixedDelay = 3*1000)
    public void startService() {
        Broadcaster broadcaster = getBroadcaster();
        if (!broadcaster.getAtmosphereResources().isEmpty()) {
            broadcaster.broadcast("{data:" + (int) (Math.random() * 10000) + "}");
        }
    }

    private Broadcaster getBroadcaster(){
        return BroadcasterFactory.getDefault().lookup("/room1",true);
    }
}
