package com.example.footballworldcupscoreboardapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballWorldCupScoreBoardAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballWorldCupScoreBoardAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CommandLineService commandLineService) {
        return args -> {
            while(true){
                commandLineService.displayInstruction();
                commandLineService.startInteraction();
            }
        };
    }

}
