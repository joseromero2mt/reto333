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
public class ServiciosCategorias {
     @Autowired
    private RepositorioCategorias metodosCrud;

    public List<Categorias> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categorias> getCategoria(int CategoriaId) {
        return metodosCrud.getCategorias(CategoriaId);
    }

    public Categorias save(Categorias categorias) {
        if (categorias.getId()== null) {
            return metodosCrud.save(categorias);
        } else {
            Optional<Categorias> categoria1 = metodosCrud.getCategorias(categorias.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categorias);
            } else {
                return categorias;
            }
        }
    }

    public Categorias update(Categorias categorias){
        if(categorias.getId()!=null){
            Optional<Categorias>g=metodosCrud.getCategorias(categorias.getId());
            if(!g.isEmpty()){
                if(categorias.getDescription()!=null){
                    g.get().setDescription(categorias.getDescription());
                }
                if(categorias.getName()!=null){
                    g.get().setName(categorias.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categorias;
    }
    public boolean deletecategorias(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
