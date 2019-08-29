package co.gc.RestDemo719.controller;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.gc.RestDemo719.entity.Movie;
import co.gc.RestDemo719.repo.MovieRepo;

@RestController
public class MovieController {

	@Autowired
	MovieRepo m;

	@GetMapping("/")
	public List<Movie> listMovies() {
//		List<Book> bookList = new ArrayList<>();
//		bookList.add(new Book(1L, "Java for Beginners", "Grant Chripus", "Non-Fiction"));
//		bookList.add(new Book(1L, "JavaScript for Beginners", "Grant Chripus", "Non-Fiction"));
//		bookList.add(new Book(1L, "Help Me Learn Spring", "John Doe", "Non-Fiction"));

		List<Movie> movieList = m.findAll();

		return movieList;
	}

//	@GetMapping("find-movie-id/{id}")
//	public Optional<Movie> findMovie(@PathVariable("id") Long id) {
//		Optional<Movie> movie = m.findById((long) id);
//		return movie;
//	}

	@GetMapping("find-movie-title/{title}")
	public Movie findTitle(@PathVariable("title") String title) {
		Movie movie = m.findByTitle(title);
		return movie;
	}

	@GetMapping("category-types")
	public TreeSet<String> findDistinctCat() {
		return m.findDistinctCategory();
	}

	@GetMapping("find-by-director/{name}")
	public List<Movie> findDirector(@PathVariable("name") String director) {
		return m.findByDirector(director);
	}

	@GetMapping("find-movie-in-category/{category}")
	public List<Movie> findMovieInCategory(@PathVariable("category") String category) {
		List<Movie> movie = m.findByCategory(category);
		return movie;

	}

	@GetMapping("find-by-key-word/{keyword}")
	public List<Movie> findByKewWord(@PathVariable("keyword") String keyWord) {
		List<Movie> movie = m.findByTitleContains(keyWord);
		return movie;
	}

	@GetMapping("find-random-movie")
	public Movie findRandMovie() {
		return m.findByRandMovie();
	}

	@GetMapping("find-random-movie-category/{cat}")
	public List<Movie> findRandCategory(@PathVariable("cat") String cat) {
		return m.findByRandCategory(cat);
	}
	
	@GetMapping("find-random-movie-list/{num}")
	public List<Movie> findRandMovieList(@PathVariable("num")int num){
		List<Movie> movie = m.findByRandMovieList(num);
		return movie;
	}
}
