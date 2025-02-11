package damx.ercinoticias.repositories;

import damx.ercinoticias.entities.Autor;
import damx.ercinoticias.infos.AutorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    @Query("select a from Autor a where upper(a.nombre) like upper(concat('%', ?1, '%'))")
    List<AutorInfo> buscarPorNombre(String nombre);

}