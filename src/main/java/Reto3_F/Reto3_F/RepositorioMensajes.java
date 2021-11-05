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
public class RepositorioMensajes {
      @Autowired
    private InterfaceMensajes crud3;
    public List<Mensajes> getAll(){
        return (List<Mensajes>) crud3.findAll();
    }
    public Optional<Mensajes> getMessages(int id){
        return crud3.findById(id);
    }

    public Mensajes save(Mensajes messages){
        return crud3.save(messages);
    }
    public void delete(Mensajes messages){
        crud3.delete(messages);
    }
}
