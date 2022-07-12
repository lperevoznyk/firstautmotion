package configreader;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:framework-config.properties")
public interface FrameworkProperties extends Config {

    @Key("foo.bar")
    String getFooBar();

    @Key("selenium.pageload.timeout")
    int getPageTimeout();

    @Key("selenium.implicitly.timeout")
    int getImplicitlyTimeout();

}