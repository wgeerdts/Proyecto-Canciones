package com.wgeerdts.canciones_db.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wgeerdts.canciones_db.modelos.Artista;
import com.wgeerdts.canciones_db.modelos.Cancion;
import com.wgeerdts.canciones_db.servicios.ServicioArtistas;
import com.wgeerdts.canciones_db.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
   @Autowired
   private final ServicioCanciones servicioCanciones;

   @Autowired
   private final ServicioArtistas servicioArtistas;

   public ControladorCanciones(ServicioCanciones servicioCanciones,
                              ServicioArtistas servicioArtistas) {
      this.servicioCanciones = servicioCanciones;
      this.servicioArtistas = servicioArtistas;
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
   public String formularioAgregarCancion(Model modelo) {
      modelo.addAttribute("nuevaCancion", new Cancion());
      modelo.addAttribute("listaArtistas", this.servicioArtistas.obtenerTodosLosArtistas());
      return "agregarCancion";
   }

   @PostMapping("/canciones/procesa/agregar")
   public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                       BindingResult validaciones,
                                       @RequestParam("idArtista") Long idArtista){
      if (validaciones.hasErrors()) {
         return "agregarCancion";
      }
      Artista artista = this.servicioArtistas.obtenerArtistaPorId(idArtista);
      nuevaCancion.setArtista(artista);
      this.servicioCanciones.agregarCancion(nuevaCancion);
      return "redirect:/canciones";
   }

   @GetMapping("/canciones/formulario/editar/{idCancion}")
   public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
      Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
      modelo.addAttribute("cancion", cancionActual);
      modelo.addAttribute("listaArtistas",this.servicioArtistas.obtenerTodosLosArtistas());
      return "editarCancion";
   }

   @PutMapping("/canciones/procesa/editar/{idCancion}")
   public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                       BindingResult validaciones,
                                       @PathVariable("idCancion") Long idCancion,
                                       @RequestParam("idArtista") Long idArtista) {
      if (validaciones.hasErrors()) {
         return "editarCancion";
      }
      cancion.setId(idCancion);
      Artista artista = this.servicioArtistas.obtenerArtistaPorId(idArtista);
      cancion.setArtista(artista);
      this.servicioCanciones.actualizaCancion(cancion);
      return "redirect:/canciones/detalle/{idCancion}";
   }

   @DeleteMapping("/canciones/eliminar/{idCancion}")
   public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
      this.servicioCanciones.eliminarCancion(idCancion);
      return "redirect:/canciones";
   }
}
