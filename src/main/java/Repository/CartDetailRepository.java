/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entities.Vegetable;
import Entities.CartDetail;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ad
 */
@Repository
public interface CartDetailRepository extends CrudRepository<CartDetail, Integer>{
    
    @Query(value = "select * from orderdetail o group by o.VegetableID order by count(o.Quantity) desc", nativeQuery = true)
    ArrayList<CartDetail> getVegetableByOrderDetail();
}
