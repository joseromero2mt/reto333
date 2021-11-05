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
public class RepositorioUsuarios {
      @Autowired
    private InterfaceUsuarios crud1;

    public List<Usuarios> getAll(){
        return (List<Usuarios>) crud1.findAll();
    }
    public Optional<Usuarios> getUsuario(int id){
        return crud1.findById(id);
    }

    public Usuarios save(Usuarios users){
        return crud1.save(users);
    }
    public void delete(Usuarios users){
        crud1.delete(users);
    }
}
