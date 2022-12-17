/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entities.Vegetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ad
 */
@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Integer>{
    @Query(value = "select * from vegetable where CatagoryID = ?1", nativeQuery = true)
    Iterable<Vegetable> getVegetablesByCategory(String id);
    
}
