package com.afeng.mapper;
import com.afeng.pojo.Hero;

import java.util.List;
/**
 * @author afeng
 * @date 2018/9/28 10:34
 **/
public interface HeroDao
{
    List<Hero> selectAllHero();

    Hero selectHeroById(Integer id);
}
