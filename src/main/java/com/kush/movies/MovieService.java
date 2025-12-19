package com.kush.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> allMovies() {

        System.out.println("Connected to database: " + mongoTemplate.getDb().getName());
        mongoTemplate.getCollectionNames().forEach(System.out::println);

        List<Movie> movies = movieRepository.findAll();

        movies.forEach(System.out::println);
        return movies;
    }

    public Optional<Movie> singleMovie(@NonNull ObjectId id) {
        return movieRepository.findById(id);
    }

}
