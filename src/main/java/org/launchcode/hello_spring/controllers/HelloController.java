package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    // Handles request at /hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @PostMapping("/duh")
    @ResponseBody
    public String duh(){
        return "Duh";
    }

    //Does both get and post requests
    @RequestMapping(value ="/hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hellogoodbye(){
        return "Hello and Goodbye!";

    }

    //Handles request of the form /hola?name=LaunchCode
    @GetMapping("/hola")
    @ResponseBody
    public String holaWithQueryParam(@RequestParam String name) {
        return "Hola, " + name + "!";
    }


}
