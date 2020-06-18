package com.flowable.training.dp.helloworld;

import com.flowable.core.idm.api.PlatformIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myGreetService")
public class MyGreetService {

    @Autowired
    public PlatformIdentityService platformIdentityService;

    public void greet(String greeter, String personToBeGreeted) {
        String greeterDisplayName = platformIdentityService.createUserQuery().userId(greeter).singleResult().getDisplayName();
        String personToBeGreetedDisplayName = platformIdentityService.createUserQuery().userId(personToBeGreeted).singleResult().getDisplayName();
        System.out.println(greeterDisplayName + " greets " + personToBeGreetedDisplayName);


    }
}
