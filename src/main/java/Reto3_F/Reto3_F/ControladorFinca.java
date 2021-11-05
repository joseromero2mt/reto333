/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_F.Reto3_F;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorFinca {
    @Autowired
    private ServiciosFinca servicio;
    @GetMapping("/all")
    public List<Finca> getFinca(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Finca> getFinca(@PathVariable("id") int farmId) {
        return servicio.getFinca(farmId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Finca save(@RequestBody Finca farm) {
        return servicio.save(farm);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Finca update(@RequestBody Finca farm) {
        return servicio.update(farm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int farmId) {
        return servicio.deleteFinca(farmId);
    } 
}
