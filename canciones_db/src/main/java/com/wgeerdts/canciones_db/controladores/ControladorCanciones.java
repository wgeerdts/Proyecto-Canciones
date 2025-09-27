package com.wgeerdts.canciones_db.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wgeerdts.canciones_db.modelos.Cancion;
import com.wgeerdts.canciones_db.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
   @Autowired
   private final ServicioCanciones servicioCanciones;

   public ControladorCanciones(ServicioCanciones servicioCanciones) {
      this.servicioCanciones = servicioCanciones;
   }

   @GetMapping("/canciones")
   public String desplegarCanciones(Model modelo) {
      List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
      modelo.addAttribute("listaCanciones", listaCanciones);
      return "canciones";
   }

   @GetMapping("/canciones/detalle/{idCancion}")
   public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
      Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
      if (cancion == null) {
         return "redirect/canciones";
      }
      modelo.addAttribute("cancion", cancion);
      return "detallesCancion";
   }

   @GetMapping("/canciones/formulario/agregar")
   public String formularioAgregarCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion) {
      return "agregarCancion";
   }

   @PostMapping("/canciones/procesa/agregar")
   public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                       BindingResult validaciones){
      if (validaciones.hasErrors()) {
         return "agregarCancion";
      }
      this.servicioCanciones.agregarCancion(nuevaCancion);
      return "redirect:/canciones";
   }

   @GetMapping("/canciones/formulario/editar/{idCancion}")
   public String formularioEditarCancion(@ModelAttribute("cancion") Cancion cancion,
                                          @PathVariable("idCancion") Long idCancion,
                                          Model modelo) {
      Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
      modelo.addAttribute("cancion", cancionActual);
      return "editarCancion";
   }

   @PutMapping("/canciones/procesa/editar/{idCancion}")
   public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                       BindingResult validaciones,
                                       @PathVariable("idCancion") Long idCancion) {
      if (validaciones.hasErrors()) {
         return "editarCancion";
      }
      cancion.setId(idCancion);
      this.servicioCanciones.actualizaCancion(cancion);
      return "redirect:/canciones/detalle/{idCancion}";
   }
}
