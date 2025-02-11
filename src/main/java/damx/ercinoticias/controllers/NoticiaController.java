package damx.ercinoticias.controllers;

import damx.ercinoticias.models.ResponseModel;
import damx.ercinoticias.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<ResponseModel> obtenerNoticiasPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(noticiaService.buscarNoticiaPorTitulo(titulo));
    }

    @GetMapping("/contenidofechas/{contenido}/{fecha1}/{fecha2}")
    public ResponseEntity<ResponseModel> obtenerNoticiasPorContenidoYFechas(@PathVariable String contenido,
                                                                            @PathVariable LocalDate fecha1,
                                                                            @PathVariable LocalDate fecha2) {
        return ResponseEntity.ok(noticiaService.buscarNoticiaPorContenidoYFechas(contenido, fecha1, fecha2));
    }
}
