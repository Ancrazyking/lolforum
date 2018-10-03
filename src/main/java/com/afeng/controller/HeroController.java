package com.afeng.controller;

import com.afeng.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author afeng
 * @date 2018/9/28 10:48
 **/
@Controller
@RequestMapping("/lol")
public class HeroController
{
    @Autowired
    private HeroService heroService;

    /**
     * 返回英雄集合对象json字符串
     * @return
     */
    //@ResponseBody默认编码为ISO-8859-1
    @ResponseBody
    @RequestMapping(value = "/heroList", produces = "application/json;charset=utf-8")
    public String heroList(ModelAndView mav)
    {
        String jsonStr = heroService.selectAllHero();
        System.out.println(jsonStr);
        return jsonStr;
    }

    /**
     * 返回英雄对象json字符串
     * @param heroName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hero", produces = "application/json;charset=utf-8")
    public String hero(@RequestParam("hero_name") String heroName,ModelAndView mav)
    {
        String jsonStr = heroService.selectHeroByHeroName(heroName);
        System.out.println(heroName);
        return jsonStr;
    }

 /*   @RequestMapping("/heroInfo")
    public String hero(){
        return "hero";
    }*/


    @RequestMapping("/heroInfo")
    public ModelAndView hero(){
        ModelAndView hero=new ModelAndView("hero");
        return hero;
    }



    @RequestMapping("/test")
    public void test(String username)
    {
        System.out.println(username);
    }


}

