package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//practice from lc

@Controller
@ResponseBody
// can add @RequestMapping up top so that every path starts with whatever you want. /example/hello
@RequestMapping("/hello")
public class HelloController {
    // Handles request at /hello
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @PostMapping("/duh")
    public String duh(){
        return "Duh";
    }

    //Does both get and post requests
    @RequestMapping(value ="/hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    public String hellogoodbye(){
        return "Hello and Goodbye!";

    }

    //Handles request of the form /hola?name=LaunchCode
//    @GetMapping("/hola")
//    @ResponseBody
//    public String holaWithQueryParam(@RequestParam String name) {
//        return "Hola, " + name + "!";
//    }

    //Handles requests of the form /hello/LaunchCode (handles dynamic data)
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
    //This submits form as a GET
//    @GetMapping("/form")
//    @ResponseBody
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action='hola'>" + //submit a request to /hola
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'> " +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String holaWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hola
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'> " +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
