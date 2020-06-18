package com.flowable.training.dp.helloworld;

import com.flowable.core.idm.api.PlatformIdentityService;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.BpmnError;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("myAwesomeGreetTask")
public class MyAwesomeGreetTask implements JavaDelegate {

    @Autowired
    public PlatformIdentityService platformIdentityService;

    public String greeter;
    public String personToBeGreeted;

    private static final String GREETER_VARIABLE = "greeter";
    private static final String PERSON_TO_BE_GREETED_VARIABLE = "personToBeGreeted";

    @Override
    public void execute(DelegateExecution execution) {
        String greeter = (String) execution.getVariable(GREETER_VARIABLE);
        String personToBeGreeted = (String) execution.getVariable(PERSON_TO_BE_GREETED_VARIABLE);

        if(greeter.equals("admin")) {
            throw new FlowableIllegalArgumentException("Never greet an admin!!!");
        }

        String greeterDisplayName = platformIdentityService.createUserQuery().userId(greeter).singleResult().getDisplayName();
        String personToBeGreetedDisplayName = platformIdentityService.createUserQuery().userId(personToBeGreeted).singleResult().getDisplayName();
        System.out.println(greeterDisplayName + " greets " + personToBeGreetedDisplayName);

        RuntimeService runtimeService = null;
        List<Execution> sadasdads = runtimeService.createExecutionQuery()
                .processInstanceId("sadasdads")
                .list();



    }
}
