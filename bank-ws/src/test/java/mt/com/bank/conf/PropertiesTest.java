package mt.com.bank.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
@Configuration
@PropertySources
({
    @PropertySource(value = "classpath:application-test.properties", ignoreResourceNotFound = true),
})
public class PropertiesTest
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}