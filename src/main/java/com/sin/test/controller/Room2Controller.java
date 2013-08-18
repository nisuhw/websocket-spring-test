package com.sin.test.controller;

import com.sin.test.service.Room2Service;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/room2")
public class Room2Controller {
    @Autowired
    private Room2Service room2Service;

    @RequestMapping("/subscribe")
    @ResponseBody
    public void subscribe(HttpServletRequest request) {
        Meteor meteor = Meteor.build(request);
        meteor.resumeOnBroadcast(meteor.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING).suspend(-1);
        room2Service.getBroadcaster().addAtmosphereResource(meteor.getAtmosphereResource());
    }
}
