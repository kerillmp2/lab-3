import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

@Stateless
public class DBConnection {

    @PersistenceContext(unitName = "hibernate")
    protected EntityManager em;

    public void insert(FishingPoint fishingPoint) {
        em.persist(fishingPoint);
    }

    public List<FishingPoint> findAll(String curSession) {

        if(em == null){
            System.out.println("EM IS NULL!!!!!!!");
        }

        List<FishingPoint> fishingPoints = null;

        Query query = em.createQuery("select fp from FishingPoint fp where fp.session = :session");
        query.setParameter("session", curSession);

        fishingPoints = query.getResultList();

        return fishingPoints;
    }
}