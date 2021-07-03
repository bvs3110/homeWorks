package Dao;

import entity.Climber;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class ClimberDao implements Dao<Climber, UUID> {
    private EntityManager manager;

    public void add(Climber climber){
        manager.persist(climber);
    }
    public Climber getByPK(UUID uuid){
        return manager.find(Climber.class, uuid);
    }
    public List<Climber> getAll(){
        Query queryClimber = manager.createQuery("SELECT c FROM Climber c");
        List<Climber> allClimbers = (List<Climber>) queryClimber.getResultList();
        return allClimbers;
    }
    public void update(Climber climber){
        manager.merge(climber);
    }
    public void deleteByPK(UUID uuid){
        manager.remove(getByPK(uuid));
    }
    public List<Climber> findByNameEmail(String fullName, String email){
         TypedQuery<Climber> queryFindByNameEmail = manager.createQuery(
                "SELECT c FROM Climber c WHERE c.fullName = :fullName AND c.email = :email" , Climber.class);
        List<Climber> myClimbers = queryFindByNameEmail
                .setParameter("fullName", fullName)
                .setParameter("email", email)
                .getResultList();
        return myClimbers;
    }
}
