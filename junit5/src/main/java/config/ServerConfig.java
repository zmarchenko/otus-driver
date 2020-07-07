package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties.properties")
public interface ServerConfig extends Config{

    @Key("otus")
    String otus();

    @Key("yandex")
    String yandex();


}
