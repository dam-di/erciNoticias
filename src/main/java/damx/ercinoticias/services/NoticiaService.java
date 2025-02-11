package damx.ercinoticias.services;

import damx.ercinoticias.entities.Noticia;
import damx.ercinoticias.infos.NoticiaInfo;
import damx.ercinoticias.models.ResponseModel;
import damx.ercinoticias.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    NoticiaRepository noticiaRepository;

    public ResponseModel buscarNoticiaPorTitulo(String titulo) {
        List<NoticiaInfo> listaNoticias = noticiaRepository.obtenerNoticiaPorTitulo(titulo);
        if (listaNoticias.isEmpty()) {
            return new ResponseModel(1,"No hay noticias",null);
        }
        return new ResponseModel(0,"Lista de noticias",listaNoticias);
    }

    public ResponseModel buscarNoticiaPorContenidoYFechas(String contenido, LocalDate fecha1, LocalDate fecha2) {
        List<NoticiaInfo> listaNoticias = noticiaRepository.buscarPorContenidoYFechas(contenido, fecha1, fecha2 );
        if (listaNoticias.isEmpty()) {
            return new ResponseModel(1,"No hay noticias",null);
        }
        return new ResponseModel(0,"Lista de noticias",listaNoticias);
    }


}
