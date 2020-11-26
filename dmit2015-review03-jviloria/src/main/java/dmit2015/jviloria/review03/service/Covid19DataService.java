package dmit2015.jviloria.review03.service;

import dmit2015.jviloria.review03.model.Covid19Data;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class Covid19DataService {


    @PersistenceContext(unitName = "h2database-jpa-pu")
    private EntityManager em;

    public void add(Covid19Data newCovid19Data) {
        em.persist(newCovid19Data);
    }

    public List<Covid19Data> findAll() {
        return em.createQuery(
                "SELECT m FROM Covid19Data m ORDER BY m.id"
                , Covid19Data.class)
                .getResultList();
    }

    public Optional<Covid19Data> findById(Long id) {
        Optional<Covid19Data> optionalData = Optional.empty();
        try {
            Covid19Data querySingleResult = em.find(Covid19Data.class, id);
            if (querySingleResult != null) {
                optionalData = Optional.of(querySingleResult);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return optionalData;
    }


    public void update(Covid19Data updatedData) {
        Optional<Covid19Data> optionalData = findById(updatedData.getId());
        if (optionalData.isPresent()) {
            Covid19Data existingData = optionalData.get();
            existingData.setDateReported(updatedData.getDateReported());
            existingData.setAhsZone(updatedData.getAhsZone());
            existingData.setInHospital(updatedData.getInHospital());
            existingData.setInIntensiveCare(updatedData.getInIntensiveCare());
            /*existingBill.setPayeeName(updatedBill.getPayeeName());
            existingBill.setAmountDue(updatedBill.getAmountDue());
            existingBill.setAmountBalance(updatedBill.getAmountBalance());
            existingBill.setDueDate(updatedBill.getDueDate());*/
            em.merge(existingData);
            em.flush();
        }

    }

    public void remove(Long billID) {
        Optional<Covid19Data> optionalData = findById(billID);
        if (optionalData.isPresent()) {
            Covid19Data existingData = optionalData.get();
            //remove(existingMovie);
            em.remove(existingData);
            em.flush();
        }
    }
}
