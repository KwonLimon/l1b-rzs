package com.mitit.l1b.config;

import com.mitit.l1b.entity.Movie;
import com.mitit.l1b.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieSeeder implements ApplicationRunner {

    private final MovieRepository repository;

    @Override
    public void run(ApplicationArguments args) {
        repository.save(new Movie(null, "Тіні забутих предків", "Сергій Параджанов",
                new BigDecimal("149.00"), 1965, 97,
                "/posters/tini.svg", stills("tini"),
                "Поетична історія кохання Івана та Марічки на тлі гуцульських Карпат.",
                "Драма", "12+"));
        repository.save(new Movie(null, "Земля", "Олександр Довженко",
                new BigDecimal("99.00"), 1930, 75,
                "/posters/zemlia.svg", stills("zemlia"),
                "Класика світового кіно про життя українського села.",
                "Драма", "12+"));
        repository.save(new Movie(null, "Інтерстеллар", "Крістофер Нолан",
                new BigDecimal("199.00"), 2014, 169,
                "/posters/interstellar.svg", stills("interstellar"),
                "Група дослідників вирушає крізь червоточину, щоб знайти людству новий дім.",
                "Наукова фантастика", "12+"));
        repository.save(new Movie(null, "Кіборги", "Ахтем Сеітаблаєв",
                new BigDecimal("179.00"), 2017, 113,
                "/posters/kiborhy.svg", stills("kiborhy"),
                "Фільм про оборону Донецького аеропорту українськими військовими.",
                "Воєнна драма", "16+"));
        repository.save(new Movie(null, "Паразити", "Пон Чжун Хо",
                new BigDecimal("189.00"), 2019, 132,
                "/posters/parasite.svg", stills("parasite"),
                "Бідна родина хитрістю влаштовується на роботу до заможної сім’ї.",
                "Трилер", "16+"));
    }

    private static List<String> stills(String slug) {
        return List.of("/stills/" + slug + "-1.svg", "/stills/" + slug + "-2.svg");
    }
}
