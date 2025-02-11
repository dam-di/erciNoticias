package damx.ercinoticias.repositories;

import damx.ercinoticias.entities.Noticia;
import damx.ercinoticias.infos.NoticiaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {
    @Query("select n from Noticia n where upper(n.titulo) like upper(concat('%', ?1, '%'))")
    List<NoticiaInfo> obtenerNoticiaPorTitulo(String titulo);

    @Query("""
            select n from Noticia n
            where upper(n.contenido) like upper(concat('%', ?1, '%')) and n.fechaPublicacion between ?2 and ?3""")
    List<NoticiaInfo> buscarPorContenidoYFechas(String contenido, LocalDate fechaPublicacionStart, LocalDate fechaPublicacionEnd);


}