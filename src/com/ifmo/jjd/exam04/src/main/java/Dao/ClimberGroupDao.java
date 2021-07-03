package Dao;

import entity.Climber;
import entity.ClimbingGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ClimberGroupDao implements Dao<ClimbingGroup, Integer> {
    private EntityManager manager;

    public void add(ClimbingGroup climbingGroup){
        manager.persist(climbingGroup);
    }
    public ClimbingGroup getByPK(Integer id){
        return manager.find(ClimbingGroup.class, id);
    }
    public List<ClimbingGroup> getAll(){
        Query queryClimbingGroup = manager.createQuery("SELECT c FROM ClimbingGroup c");
        List<ClimbingGroup> allClimbingGroup = (List<ClimbingGroup>) queryClimbingGroup.getResultList();
        return allClimbingGroup;
    }
    public void update(ClimbingGroup climbingGroup){
        manager.merge(climbingGroup);
    }
    public void deleteByPK(Integer id){
        manager.remove(getByPK(id));
    }
    public List<ClimbingGroup> findByNameEmail(){
        TypedQuery<ClimbingGroup> queryClimbingGroup = manager.createQuery(
                "SELECT c FROM ClimbingGroup c WHERE c.start > myNow" , ClimbingGroup.class);
        List<ClimbingGroup> myClimbingGroup = queryClimbingGroup
                .setParameter("myNow", LocalDateTime.now())
                .getResultList();
        return myClimbingGroup;
    }
}
