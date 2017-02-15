import com.google.inject.AbstractModule;

public class BindsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SimpleBean.class);
    }
}
