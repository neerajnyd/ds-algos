package com.ny.streamdataprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMoviesActors {
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static void main(String... args) throws IOException {
        final Set<Movie>     movies = new HashSet<>();
        final Stream<String> lines  = Files.lines(Paths.get("C:\\Users\\NY\\Documents\\GitHub\\ds-algos\\src\\main\\java\\com\\ny\\streamdataprocessing\\movies-mpaa.txt"));
        lines.forEach((String line) -> {
            String[] elements    = line.split("/");
            String   title       = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
            String   releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
            if (releaseYear.contains(",")) {
                return;
            }
            Movie movie = new Movie(title, Integer.parseInt(releaseYear));
            for (int i = 1; i < elements.length; i++) {
                String[] name      = elements[i].split(", ");
                String   lastName  = name[0].trim();
                String   firstName = "";
                if (name.length > 1) {
                    firstName = name[1].trim();
                }
                Actor actor = new Actor(lastName, firstName);
                movie.addActor(actor);
            }
            movies.add(movie);
        });
        System.out.println("# movies = " + movies.size());
        final long numberOfActors = movies.stream().flatMap(movie -> movie.actors().stream()).distinct().count();
        System.out.println("# of actors : " + numberOfActors);
        final Entry<Actor, Long> mostViewedActor = movies.stream().flatMap(movie -> movie.actors().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Entry.comparingByValue()).get();
        System.out.println("Most viewed actor : " + mostViewedActor);
        final Entry<Integer, Entry<Actor, AtomicLong>> get = movies.stream()
                .collect(
                        Collectors.groupingBy(
                                Movie::releaseYear,
                                Collector.of(
                                        (Supplier<HashMap<Actor, AtomicLong>>) HashMap::new,
                                        (map, movie) -> movie.actors().forEach(actor -> map.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet()),
                                        (map1, map2) -> {
                                            map2.forEach((key, value) -> map1.merge(key, value, (al1, al2) -> {
                                                al1.addAndGet(al2.get());
                                                return al1;
                                            }));
                                            return map1;
                                        },
                                        Collector.Characteristics.IDENTITY_FINISH
                                )
                        )
                )
                .entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Entry::getKey,
                                entry -> entry.getValue().entrySet().stream()
                                        .max(
                                                Entry.comparingByValue(Comparator.comparing(AtomicLong::get))
                                        )
                                        .get()
                        )
                )
                .entrySet().stream()
                .max(Entry.comparingByValue(Comparator.comparing(entry -> entry.getValue().get()))).get();
        System.out.println(get);
    }
}