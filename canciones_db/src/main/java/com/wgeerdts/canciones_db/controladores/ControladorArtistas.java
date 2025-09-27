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

import com.wgeerdts.canciones_db.modelos.Artista;
import com.wgeerdts.canciones_db.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
   @Autowired
   private final ServicioArtistas servicioArtistas;

   public ControladorArtistas(ServicioArtistas servicioArtistas) {
      this.servicioArtistas = servicioArtistas;
   }

   @GetMapping("/artistas")
   public String desplegarArtistas(Model modelo) {
      List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
      modelo.addAttribute("listaArtistas", listaArtistas);
      return "artistas";
   }

   @GetMapping("/artistas/detalle/{idArtista}")
   public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model modelo) {
      Artista artista = this.servicioArtistas.obtenerArtistaPorId(idArtista);
      if (artista == null) {
         return "redirect:/artistas";
      }
      modelo.addAttribute("artista", artista);
      return "detallesArtista";
   }

   @GetMapping("/artistas/formulario/agregar")
   public String formularioAgregarArtista(@ModelAttribute("nuevoArtista") Artista nuevoArtista) {
      return "agregarArtista";
   }

   @PostMapping("/artistas/procesa/agregar")
   public String procesarAgregaArtistas(@Valid @ModelAttribute("nuevoArtista") Artista nuevoArtista,
                                       BindingResult validaciones){
      if (validaciones.hasErrors()) {
         return "agregarArtista";
      }
      this.servicioArtistas.agregarArtista(nuevoArtista);
      return "redirect:/artistas";
   }
}
