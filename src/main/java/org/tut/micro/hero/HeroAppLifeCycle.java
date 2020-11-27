package org.tut.micro.hero;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import io.quarkus.runtime.configuration.ProfileManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class HeroAppLifeCycle {

    public static final Logger LOGGER = Logger.getLogger(HeroAppLifeCycle.class);

    void onStart(@Observes StartupEvent evt) {
        LOGGER.info("  _   _                      _    ____ ___ ");
        LOGGER.info(" | | | | ___ _ __ ___       / \\  |  _ \\_ _|");
        LOGGER.info(" | |_| |/ _ \\ '__/ _ \\     / _ \\ | |_) | | ");
        LOGGER.info(" |  _  |  __/ | | (_) |   / ___ \\|  __/| | ");
        LOGGER.info(" |_| |_|\\___|_|  \\___/   /_/   \\_\\_|  |___|");
        LOGGER.info("                         Powered by Quarkus");
        LOGGER.infof("The application HERO is starting with profile `%s`", ProfileManager.getActiveProfile());
    }

    void onStop(@Observes ShutdownEvent evt) {
        LOGGER.info("The application HERO is stopping...");
    }
}
