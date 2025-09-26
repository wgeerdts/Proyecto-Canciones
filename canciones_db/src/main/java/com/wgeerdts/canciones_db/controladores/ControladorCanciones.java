package com.wgeerdts.canciones_db.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wgeerdts.canciones_db.modelos.Cancion;
import com.wgeerdts.canciones_db.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {
   @Autowired
   private final ServicioCanciones servicioCanciones;

   public ControladorCanciones(ServicioCanciones servicioCanciones){
      this.servicioCanciones = servicioCanciones;
   }

   @GetMapping("/canciones")
   public String desplegarCanciones(Model modelo){
      List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
      modelo.addAttribute("listaCanciones", listaCanciones);
      return "canciones";
   }

   @GetMapping("/canciones/detalle/{idCancion}")
   public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model modelo){
      Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
      if (cancion==null) {
         return "redirect/canciones";
      }
      modelo.addAttribute("cancion", cancion);
      return "detallesCancion";
   }
}
