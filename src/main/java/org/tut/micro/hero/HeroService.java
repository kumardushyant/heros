package org.tut.micro.hero;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.tut.micro.hero.data.Hero;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class HeroService {

    @ConfigProperty(name = "level.multiplier", defaultValue = "1")
    int levelMultiplier;

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Hero> getAllHeros() {
        return Hero.listAll();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Hero findById(Long id) {
        return Hero.findById(id);
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Hero findRamdomHero() {
        Hero randomHero = null;
        while(randomHero == null) {
            randomHero = Hero.findRandom();
        }
        return randomHero;
    }

    public Hero saveHero(@Valid Hero hero) {
        hero.level = hero.level * levelMultiplier;
        Hero.persist(hero);
        return hero;
    }

    public Hero updateHero(@Valid Hero hero) {
        Hero entity = Hero.findById(hero.id);
        entity.name = hero.name;
        entity.otherName = hero.otherName;
        entity.picture = hero.picture;
        entity.level = hero.level;
        entity.powers = hero.powers;
        return entity;
    }

    public void deleteHero(Long id) {
        Hero hero = Hero.findById(id);
        hero.delete();
    }
}
