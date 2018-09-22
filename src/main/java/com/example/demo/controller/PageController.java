package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {
    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/challenge")
    public  String challenge(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping( "/challenge/{name}")
    public String challengePath(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping("/generator")
    public String viralgenerator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model){
        //value dari request dijadikan integer
        int mMultiplier = Integer.parseInt(a);
        int hmMultiplier = Integer.parseInt(b);

        //kalau value 0, diberi default masing - masing multiplier
        //adalah 1
        if(mMultiplier==0){mMultiplier=1;}
        if(hmMultiplier==0){hmMultiplier=1;}

        String fWord = "h";

        //karakter "h" ditambahkan menurut jumlah "m" nya
        for (int i =1;  i<=mMultiplier; i++){
            fWord+="m";
        }

        //satu kata sudah dibuat
        //menambahkan <hmMultiplier - 1> kata sel   anjutnya
        String result = fWord;
        for (int j =1;  j<=hmMultiplier-1; j++){
            result+=(" " + fWord);
        }

        //agar dapat dirender html
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);
        return "generator";
    }
}
