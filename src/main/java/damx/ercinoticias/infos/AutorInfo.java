package damx.ercinoticias.infos;

import java.time.Instant;
import java.util.Set;

/**
 * Projection for {@link damx.ercinoticias.entities.Autor}
 */
public interface AutorInfo {
    Integer getId();

    String getNombre();

    String getEmail();

    String getBio();

    Set<NoticiaInfo> getNoticias();

    /**
     * Projection for {@link damx.ercinoticias.entities.Noticia}
     */
    interface NoticiaInfo {
        Integer getId();

        String getTitulo();

        Instant getFechaPublicacion();
    }
}