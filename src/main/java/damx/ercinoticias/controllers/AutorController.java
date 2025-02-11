package damx.ercinoticias.controllers;

import damx.ercinoticias.dtos.AutorDto;
import damx.ercinoticias.entities.Autor;
import damx.ercinoticias.models.ResponseModel;
import damx.ercinoticias.repositories.AutorRepository;
import damx.ercinoticias.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @DeleteMapping("/eliminar")
    public ResponseEntity<ResponseModel> eliminarAutor(@RequestBody AutorDto autorDto) {
        return ResponseEntity.ok(autorService.eliminarAutor(autorDto));
    }
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearAutor(@RequestBody AutorDto autordto) {
        return ResponseEntity.ok(autorService.crearAutor(autordto));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ResponseModel> actualizarAutor(@RequestBody AutorDto autordto) {
        return ResponseEntity.ok(autorService.actualizarAutor(autordto));
    }


    @GetMapping("/info/{nombre}")
    public ResponseEntity<ResponseModel> obtenerAutorPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(autorService.obtenerAutoresPorNombre(nombre));
    }
}
