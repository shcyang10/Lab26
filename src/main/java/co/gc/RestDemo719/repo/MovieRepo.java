package co.gc.RestDemo719.repo;

import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gc.RestDemo719.entity.Movie;

//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
	// any special queries can go in the repo but must follow proper naming conventions
	Movie findByTitle(String t);
	
	
	/*
	 * The @Query annotation can be used to create our own special queries
	 * if the jpa documentation doesn't show these as options
	 * 
	 * You can use native sql queries by adding an additional parameter
	 */
	@Query("select distinct category from Movie ")
	TreeSet<String> findDistinctCategory();
	
	List<Movie> findByCategory(String category);
	
	List<Movie> findByDirector(String director);
	
	List<Movie> findByTitleContains(String kw);

	@Query(value="select * from movie where category=? order by rand() limit 1", nativeQuery=true)
	List<Movie> findByRandCategory(String cat);
	
	@Query(value="select * from movie order by rand() limit 1", nativeQuery=true)
	Movie findByRandMovie();

	@Query(value="select * from movie order by rand() limit ?", nativeQuery=true)
	List<Movie> findByRandMovieList(int num);
}
