import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.guice.LifecycleInjectorBuilder;
import com.netflix.governator.lifecycle.LifecycleManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nir Asis
 */
public class TestGovenrnatorProvidesVsBinds {

    @Test
    public void testBinds() throws Exception {
        test(BindsModule.class);
    }

    @Test(expected = AssertionError.class)
    public void testProvides() throws Exception {
        test(ProvidesModule.class);
    }

    private void test(Class<? extends AbstractModule> module) throws Exception {
        LifecycleInjectorBuilder builder = LifecycleInjector.builder().withModuleClass(module);
        Injector injector = builder.build().createInjector();
        LifecycleManager lifecycleManager = injector.getInstance(LifecycleManager.class);
        lifecycleManager.start();
        SimpleBean instance = injector.getInstance(SimpleBean.class);
        lifecycleManager.close();
        Assert.assertEquals(SimpleBean.PRE_DESTROY, instance.getPhase());
    }
}
