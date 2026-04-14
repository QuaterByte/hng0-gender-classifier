package com.hng.internship.classifier.api;


import com.hng.internship.classifier.Data;
import com.hng.internship.classifier.Error;
import com.hng.internship.classifier.Genderize;
import com.hng.internship.classifier.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.MismatchedInputException;

import java.nio.channels.UnresolvedAddressException;
import java.time.Instant;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class ApiController {

    private RestClient client;

    public ApiController(RestClient client){
        this.client = client;
    }

    @GetMapping(path = "/classify", produces = "application/json")
    public ResponseEntity<?> getClassifier(@RequestParam(required = false) Object name){

        if(name == null || name.toString().trim().isEmpty())
            return  ResponseEntity.badRequest().body(new Error("Missing or empty name"));

        if(!(name instanceof String))
            return ResponseEntity.unprocessableContent().body(new Error("Non-string name"));


         ResponseEntity<Genderize>genderize = client.get().uri("https://api.genderize.io?name={name}", name)
                .retrieve().toEntity(Genderize.class);
         if(!genderize.getStatusCode().is2xxSuccessful())
             return errorResponseEntity();

         Data data = genderizeToData(genderize.getBody());
         if(data.getGender() == null || data.getSample_size() == 0)
             return ResponseEntity.unprocessableContent().body(new Error("No prediction available for the provided name"));
        return  ResponseEntity.ok(new Response(data));
    }

    @ExceptionHandler({UnresolvedAddressException.class, MismatchedInputException.class})
    public ResponseEntity<Error> errorResponseEntity(){
        return ResponseEntity.internalServerError().body(new Error("Upstream or server failure"));
    }


    private Data genderizeToData(Genderize genderize){
        Data data = new Data();
        data.setName(genderize.getName());
        data.setGender(genderize.getGender());
        data.setProbability(genderize.getProbability());
        data.setSample_size(genderize.getCount());
        data.setProcessed_at(utc8601Formatter());

        return data;
    }

    private String utc8601Formatter(){
        StringBuilder builder = new StringBuilder(Instant.now().toString());
         builder = builder.delete(21, 28);
        return  builder.toString();
    }


}
