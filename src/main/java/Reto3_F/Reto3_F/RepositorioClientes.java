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
public class RepositorioClientes {
      @Autowired
    private InterfaceClientes crud1;

    public List<Clientes> getAll(){
        return (List<Clientes>) crud1.findAll();
    }
    public Optional<Clientes> getCliente(int id){
        return crud1.findById(id);
    }

    public Clientes save(Clientes clientes){
        return crud1.save(clientes);
    }
    public void delete(Clientes clientes){
        crud1.delete(clientes);
    }
}
