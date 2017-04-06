package mt.com.bank.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 *
 * Class loads the internal and external property files to the property placeholder configurer
 * so that other beans such as Entity Manager, Transaction Manager can be instantiated.
 */
@Configuration
@PropertySources
({
    @PropertySource(value = "file:${path}", ignoreResourceNotFound = true),
    @PropertySource(value = "classpath:core.properties", ignoreResourceNotFound = true)
})
public class Properties
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}