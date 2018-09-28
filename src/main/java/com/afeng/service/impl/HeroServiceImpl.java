package com.afeng.service.impl;

import com.afeng.mapper.HeroDao;
import com.afeng.pojo.Hero;
import com.afeng.service.HeroService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author afeng
 * @date 2018/9/28 10:38
 **/


@Service
public class HeroServiceImpl implements HeroService
{
    @Autowired
    private HeroDao heroDao;

    public String selectAllHero()
    {
        List<Hero> heroList = heroDao.selectAllHero();
        String heroListJsonStr = JSON.toJSONString(heroList);
        System.out.println(heroListJsonStr);
        return heroListJsonStr;
    }

    public String selectHeroById(Integer id)
    {
        Hero hero = heroDao.selectHeroById(id);
        String heroJsonStr = JSON.toJSONString(hero);
        return heroJsonStr;
    }
}
