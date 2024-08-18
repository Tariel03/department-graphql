package com.example.departmentgraphql.automation;

import com.example.departmentgraphql.repos.ChefRepository;
import com.example.departmentgraphql.services.ChefService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class ChefWatcher {
    private final ChefService chefService;
    @Scheduled(fixedDelay = 1000  * 60  )
    public void printChefs(){
        log.info("There are {} chefs in database", chefService.findAll().size());


    }
}
