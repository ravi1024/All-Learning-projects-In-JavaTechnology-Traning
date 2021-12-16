package com.ravi.springbootconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class HelloController {

    @Autowired
    private DbSettings dbSettings;

    //we should not use Environment Object for look up profiles and properties
    @Autowired
    private Environment environment;

    @Value("${my.greetings}")
    private String myGreetings;

    @Value("Some Static Message")
    private String staticMessage;

    @Value("${my.list.value}")
    private List<String> list;

   /* @Value("#{${db.value}}")
    private Map<String,String> dbValue;*/

    @RequestMapping("/greetings")
    public String getGreetings() {
        return myGreetings+staticMessage+list;
//        return  dbSettings.getValue() + dbSettings.getHost();
    }


    //we should not use Environment Object for look up profiles and properties
    @RequestMapping("/envdetails")
    public String getEnviromentDetails () {
        return environment.toString();
    }

}
