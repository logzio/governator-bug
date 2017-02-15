import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;

/**
 * Created by Nir Asis
 */
public class ProvidesModule extends AbstractModule {

    @Override
    protected void configure() {}

    @Provides
    @Singleton
    private SimpleBean simpleBeanProvider() {
        return new SimpleBean();
    }
}
