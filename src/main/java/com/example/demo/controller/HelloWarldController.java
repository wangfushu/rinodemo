package com.example.demo.controller;

import com.example.demo.domain.SysDictionary;
import com.example.demo.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloWarldController {

    @Autowired
    private WeatherInfoService weatherInfoService;

    @RequestMapping("/test")
    public String index(Model model) {
       /* Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setDictName("aa1");
        sysDictionaryRepository.save(sysDictionary);*/
        model.addAttribute("model","Thymeleaf模板引擎");
        return "test";
    }

    @RequestMapping("/myThymeleaf")
    public ModelAndView myThymeleaf(HttpServletRequest request){
        ModelAndView model = new ModelAndView("/test");
        model.addObject("model","Thymeleaf模板引擎");
        return model;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        //ModelAndView model = new ModelAndView("index");
       /* List<SysDictionary> sysDictionaryList = sysDictionaryRepository.findByDictName("aa1");
        model.addObject("sysDictionary",sysDictionaryList.get(0));*/

        ModelAndView model = new ModelAndView("index");
        model.addObject("xmdq",weatherInfoService.findMonWeatherInfolist("0001"));
        model.addObject("hcdq",weatherInfoService.findMonWeatherInfolist("0002"));
        model.addObject("jmdq",weatherInfoService.findMonWeatherInfolist("0003"));
/*        model.addObject("xldq",weatherInfoService.findMonWeatherInfolist("0004"));*/
        model.addObject("xasd",weatherInfoService.findMonWeatherInfolist("0005"));
        return model;
    }

    @RequestMapping("/map")
    public ModelAndView map(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("html/map_baidu.html");
        return model;
    }

    @RequestMapping(value = "/test2" ,method = RequestMethod.POST)
    public SysDictionary test2(Model model) {
        /*List<SysDictionary> sysDictionaryList = sysDictionaryRepository.findByDictName("aa1");
        model.addAttribute("sysDictionary",sysDictionaryList.get(0));*/
        return null;
    }

}
