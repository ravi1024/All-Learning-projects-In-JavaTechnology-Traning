package com.ravi.springsecurityoauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    OAuth2AuthorizedClientService service;

    @RequestMapping("/home")
    public String home(){
        /*Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        OAuth2AuthenticationToken oauthToken =
                (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient client =
                clientService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName());

        System.out.println("client.getAccessToken().getTokenValue(): " + client.getAccessToken().getTokenValue());*/
        return "home";
    }

    @RequestMapping("/")
    public String rootApi(OAuth2AuthenticationToken token)
    {
        System.out.println(service);
        System.out.println(token.getPrincipal());

        OAuth2AuthorizedClient client =
                service.loadAuthorizedClient(
                        token.getAuthorizedClientRegistrationId(),
                        token.getName());

        System.out.println("client: " + client);
        System.out.println("token---> " + client.getAccessToken().getTokenValue());
        //System.out.println(client.getAccessToken().getTokenValue());
        return "Hello World! from method";
    }
}
