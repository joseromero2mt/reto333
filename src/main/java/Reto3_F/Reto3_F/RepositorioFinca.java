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
public class RepositorioFinca {
    
    @Autowired
    private InterfaceFinca crud;

    public List<Finca> getAll(){
        return (List<Finca>) crud.findAll();
    }

    public Optional<Finca> getFinca(int id){
        return crud.findById(id);
    }

    public Finca save(Finca farm){
        return crud.save(farm);
    }
    public void delete(Finca farm){
        crud.delete(farm);
    }
    
}
