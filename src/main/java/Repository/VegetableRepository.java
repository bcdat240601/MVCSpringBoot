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
public interface VegetableRepository extends CrudRepository<Vegetable, Integer> {

    @Query(value = "select * from vegetable v, category c where c.CatagoryID = v.CatagoryID", nativeQuery = true)
    Iterable<Vegetable> getVegetables();

    @Query(value = "select * from vegetable v, category c where v.CatagoryID = ?1 and c.CatagoryID = v.CatagoryID", nativeQuery = true)
    Iterable<Vegetable> getVegetablesByCategory(String id);

    @Query(value = "select * from vegetable v, category c where  c.CatagoryID = v.CatagoryID and VegetableID = ?1", nativeQuery = true)
    Vegetable getVegetableByID(String id);
}
