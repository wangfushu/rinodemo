package com.xmrbi.rinoWeb.controller;

import com.xmrbi.rinoWeb.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherInfoController {

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

    @RequestMapping("/rescue_force")
    public ModelAndView myThymeleaf(HttpServletRequest request){
        ModelAndView model = new ModelAndView("html/rescue_force");
        return model;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("xmdq",weatherInfoService.findMonWeatherInfolist("0001"));
        model.addObject("hcdq",weatherInfoService.findMonWeatherInfolist("0002"));
        model.addObject("jmdq",weatherInfoService.findMonWeatherInfolist("0003"));
        model.addObject("xasd",weatherInfoService.findMonWeatherInfolist("0005"));
        return model;
    }

    @RequestMapping("/index_weather")
    public ModelAndView indexWeather(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("html/index_weather");
        model.addObject("xmdq",weatherInfoService.findMonWeatherInfolist("0001"));
        model.addObject("hcdq",weatherInfoService.findMonWeatherInfolist("0002"));
        model.addObject("jmdq",weatherInfoService.findMonWeatherInfolist("0003"));
        model.addObject("xasd",weatherInfoService.findMonWeatherInfolist("0005"));
        return model;
    }

    @RequestMapping("/map")
    public ModelAndView map(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("html/map_off_line");
        return model;
    }

    @RequestMapping(value = "test2" ,method = RequestMethod.POST)
    public Map<String,Object> test2(Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("xmdq",weatherInfoService.findMonWeatherInfolist("0001"));
        map.put("hcdq",weatherInfoService.findMonWeatherInfolist("0002"));
        map.put("jmdq",weatherInfoService.findMonWeatherInfolist("0003"));
        map.put("xasd",weatherInfoService.findMonWeatherInfolist("0005"));
        map.put("typhoon_info",weatherInfoService.findTyphoonInfo("山竹"));
        /*model.addAttribute("xmdq",weatherInfoService.findMonWeatherInfolist("0001"));
        model.addAttribute("hcdq",weatherInfoService.findMonWeatherInfolist("0002"));
        model.addAttribute("jmdq",weatherInfoService.findMonWeatherInfolist("0003"));
        model.addAttribute("xasd",weatherInfoService.findMonWeatherInfolist("0005"));*/
        /*        model.addObject("xldq",weatherInfoService.findMonWeatherInfolist("0004"));*/
        return map;
    }

    @RequestMapping("/frame_weather")
    public ModelAndView frameWeather(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("html/frame_weather");
        return model;
    }

    @RequestMapping("/gmap")
    public ModelAndView mapDemo(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("socket");
        return model;
    }

}
