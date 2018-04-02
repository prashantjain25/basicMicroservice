package com.generic.engine.basicMicroservice.handler;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generic.engine.basicMicroservice.model.BaseModel;
import com.generic.engine.basicMicroservice.model.ParkingCard;
import com.generic.engine.basicMicroservice.model.UserDetails;

//import io.swagger.annotations.Api;
@RestController
@RequestMapping(value = "/user/{name:[\\w]+}",  //use regex for rest of the endpoint
produces = { MediaType.APPLICATION_JSON_VALUE },
consumes= { MediaType.APPLICATION_JSON_VALUE })

//@Api(tags = SwaggerTagsConstants.SWAGGER_TAG_GET_GRAMMAR)
public class UserSaveDemo  {
    //private static final Logger LOGGER = LoggerFactory.getLogger(UserSaveDemo.class);  -- iLogger implementation
    final static Logger logger = Logger.getLogger(UserSaveDemo.class);

    @GetMapping
    //@ResponseStatus(value=HttpStatus.NOT_FOUND) //done by default for @RestController
    public  ResponseEntity<?> handleAny(@ModelAttribute BaseModel base,@PathVariable String name) throws UserNotFoundException {
        HashMap<String, Object> m=new HashMap();
        m.put("status","suc");
        m.put("UserDetails",base);
        if(m.get("status").equals("fail"))
            throw new UserNotFoundException();
     //   m.put("HttpStatus", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(m,HttpStatus.OK); //Put map or any other object except ResponseEntity
        
    }

}
