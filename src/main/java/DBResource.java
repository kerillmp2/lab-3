import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DBResource {

    @Produces
    @PersistenceContext(name = "hibernate")
    private EntityManager em;

}
