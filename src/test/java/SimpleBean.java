import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;

/**
 * Created by Nir Asis
 */
@Singleton
public class SimpleBean {

    public static String CONSTRUCT = "Construct";
    public static String POST_CONSTRUCT = "PostConstruct";
    public static String PRE_DESTROY = "PreDestroy";
    private String phase;

    public SimpleBean() {
        phase = CONSTRUCT;
        System.out.println("SimpleBean Constructor");
    }

    @PostConstruct
    public void init() {
        phase = POST_CONSTRUCT;
        System.out.println("SimpleBean PostConstruct");
    }

    @PreDestroy
    public void close() {
        phase = PRE_DESTROY;
        System.out.println("SimpleBean PreDestroy");
    }

    public String getPhase() {
        return phase;
    }
}
