/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_F.Reto3_F;




import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosUsuarios {
       @Autowired
     private RepositorioUsuarios metodosCrud;
     
     public List<Usuarios> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Usuarios> getUsuario(int userId) {
        return metodosCrud.getUsuario(userId);
    }

    public Usuarios save(Usuarios user){
        if(user.getIdUsuario()==null){
            return metodosCrud.save(user);
        }else{
            Optional<Usuarios> e= metodosCrud.getUsuario(user.getIdUsuario());
            if(e.isEmpty()){
                return metodosCrud.save(user);
            }else{
                return user;
            }
        }
    }

    public Usuarios update(Usuarios user){
        if(user.getIdUsuario()!=null){
            Optional<Usuarios> e= metodosCrud.getUsuario(user.getIdUsuario());
            if(!e.isEmpty()){
                if(user.getName()!=null){
                    e.get().setName(user.getName());
                }
                if(user.getEmail()!=null){
                    e.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    e.get().setPassword(user.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean deleteUsuario(int userId) {
        Boolean aBoolean = getUsuario(userId).map(user -> {
            metodosCrud.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
