package damx.ercinoticias.infos;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

/**
 * Projection for {@link damx.ercinoticias.entities.Noticia}
 */
public interface NoticiaInfo {
    Integer getId();

    String getTitulo();

    String getContenido();

    LocalDate getFechaPublicacion();

    AutorInfo1 getIdAutor();

    CategoriaInfo getIdCategoria();

    Set<EtiquetaInfo> getEtiquetas();

    /**
     * Projection for {@link damx.ercinoticias.entities.Autor}
     */
    interface AutorInfo1 {
        Integer getId();

        String getNombre();

        String getEmail();
    }

    /**
     * Projection for {@link damx.ercinoticias.entities.Categoria}
     */
    interface CategoriaInfo {
        Integer getId();

        String getNombre();
    }

    /**
     * Projection for {@link damx.ercinoticias.entities.Etiqueta}
     */
    interface EtiquetaInfo {
        Integer getId();

        String getNombre();
    }
}