/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entities.Customers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ad
 */
@Repository
public interface UserRepository extends JpaRepository<Customers, Integer>{
    @Query(value = "select * from customers where username =  ?1 and Password = ?2", nativeQuery = true)
    Customers findByusernameAndPassword(String username, String Password);
}
