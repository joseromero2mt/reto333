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
public class RepositorioCategorias {
    @Autowired
    private InterfaceCategorias crud;
    public List<Categorias> getAll(){
        return (List<Categorias>) crud.findAll();
    }
    public Optional<Categorias> getCategorias(int id){
        return crud.findById(id);
    }

    public Categorias save(Categorias Categorias){
        return crud.save(Categorias);
    }
    public void delete(Categorias Categorias){
       crud.delete(Categorias);
    }
}
