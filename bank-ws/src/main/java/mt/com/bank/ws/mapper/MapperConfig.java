package mt.com.bank.ws.mapper;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Waylon.Mifsud
 * @since 06/10/2015
 *
 * Class required in order to notify Orika
 * of the custom mappers we have in the application.
 */
@Component
public class MapperConfig extends ConfigurableMapper
{
    private ApplicationContext applicationContext;

    private MapperFactory mapperFactory;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
        addSpringMappers();
    }

    @Override
    protected void configure(MapperFactory factory)
    {
        super.configure(mapperFactory);
        this.mapperFactory = factory;
    }

    private void addSpringMappers()
    {
        @SuppressWarnings("rawtypes")
        final Map<String, Mapper> mappers = applicationContext
                .getBeansOfType(Mapper.class);
        for (Mapper value : mappers.values())
        {
            this.addMapper(value);
        }
    }

    private void addMapper(Mapper<?, ?> mapper)
    {
        this.mapperFactory.registerMapper(mapper);
    }
}
