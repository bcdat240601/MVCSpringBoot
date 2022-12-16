/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ad
 */
@Data
@Entity(name = "customers")
@Table(name = "customers")
public class Customers {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CustomerID;
    @Column
    private String username;
    @Column
    private String Fullname;
    @Column(name = "Password")
    private String password;
    @Column
    private String Address;
    @Column
    private String City;
}
