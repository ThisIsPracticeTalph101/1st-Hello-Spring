package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
//    public String holaWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
//    public String holaWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";


    //}

    @RequestMapping(value ="/hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }

    @GetMapping("/form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hola
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value= 'english'> English </option>" +
                "<option value= 'french'> French </option>" +
                "<option value= 'german'> German </option>" +
                "<option value= 'spanish'> Spanish </option>" +
                "<option value= 'japanese'> Italian </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'> " +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
