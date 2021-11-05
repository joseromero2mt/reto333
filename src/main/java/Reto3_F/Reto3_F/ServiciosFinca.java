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
public class ServiciosFinca {
     @Autowired
    private RepositorioFinca metodosCrud;

    public List<Finca> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Finca> getFinca(int farmId) {
        return metodosCrud.getFinca(farmId);
    }

    public Finca save(Finca farm){
        if(farm.getId()==null){
            return metodosCrud.save(farm);
        }else{
            Optional<Finca> e=metodosCrud.getFinca(farm.getId());
            if(e.isEmpty()){
                return metodosCrud.save(farm);
            }else{
                return farm;
            }
        }
    }

    public Finca update(Finca farm){
        if(farm.getId()!=null){
            Optional<Finca> e=metodosCrud.getFinca(farm.getId());
            if(!e.isEmpty()){
                if(farm.getId()!=null){
                    e.get().setId(farm.getId());
                }
                if(farm.getAddress()!=null){
                    e.get().setAddress(farm.getAddress());
                }
                if(farm.getDescription()!=null){
                    e.get().setDescription(farm.getDescription());
                }
                if(farm.getExtension()!=null){
                    e.get().setExtension(farm.getExtension());
                }
               
                if(farm.getName()!=null){
                    e.get().setName(farm.getName());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }


    public boolean deleteFinca(int farmId) {
        Boolean aBoolean = getFinca(farmId).map(farm -> {
            metodosCrud.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
