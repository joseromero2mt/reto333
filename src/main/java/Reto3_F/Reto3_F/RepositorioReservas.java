/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_F.Reto3_F;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservas {
       @Autowired
    private InterfaceReservas crud4;

    public List<Reservas> getAll(){
        return (List<Reservas>) crud4.findAll();
    }
    public Optional<Reservas> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservas save(Reservas reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservas reservation){
        crud4.delete(reservation);
    }
}
