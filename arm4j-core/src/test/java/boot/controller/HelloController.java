package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/HelloGet", method = RequestMethod.GET)
    @ResponseBody
    public String helloGet(String name, String content) {
        return name + ":" + content;
    }

    @RequestMapping(value = "/HelloPost", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(String name, String content) {
        return name + ":" + content;
    }

    @RequestMapping(value = "/HelloPostByBody", method = RequestMethod.POST)
    @ResponseBody
    public String helloPostByBody(@RequestBody String content) {
        return content;
    }

    @RequestMapping(value = "/HelloPostByFormParamAndBody", method = RequestMethod.POST)
    @ResponseBody
    public String helloPostByFormParamAndBody(String name, String content, @RequestBody String body) {
        return "{" + name + ":" + content + "}、{ " + body + "}";
    }

}