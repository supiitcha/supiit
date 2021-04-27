package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "test1")
    public List<User> getAllByJsql() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "test2")
    public List<User> getByCityAndActiveAndAge(@RequestParam String city,@RequestParam String active,@RequestParam String age) {
        List<User> users = userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
        return users;
    }

    @GetMapping(value = "test3")
    public List<User> getAll() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping(value = "test4/{id}")
    public Optional<User> getById(@PathVariable String id) {
        Optional<User> users = userService.findById(Integer.parseInt(id));
        return users;
    }

    @GetMapping(value = "test5")
    public Page<User> getByLimit(@RequestParam String start, @RequestParam String limit, @RequestParam String field) {
        Page<User> users = userService.findAllByLimit(Integer.parseInt(start), Integer.parseInt(limit),field);
        return users;
    }

    @GetMapping(value = "test6")
    public List<User> getByAgeInWithBody(@RequestBody Map<String,Object> ages) {
        List<User> users = userService.findByAgeIn((List<Integer>) ages.get("age"));
        return users;
    }

    @GetMapping(value = "test7")
    public List<User> getAllByQuery(){
        List<User> users = userService.findAllByQuery();
        return users;
    }

    @GetMapping(value = "test8")
    public List<User> getAllByParamsQuery(@RequestParam String active, @RequestParam String city){
        List<User> users = userService.findAllByParamsQuery(Integer.parseInt(active),city);
        return users;
    }

    @GetMapping(value = "test9")
    public List<User> getAllByJpqlQuery(){
        List<User> users = userService.findAllByJpqlQuery();
        return users;
    }

    @GetMapping(value = "test10")
    public List<User> getByAddressIn(@RequestBody Map<String, Object> data){
        List<User> users = userService.findByAddressIn((List<String>) data.get("address"));
        return users;
    }

    @GetMapping(value = "test11")
    public List<User> getByAddressAndMobile(@RequestParam String address, @RequestParam String mobile){
        List<User> users = userService.findByAddressAndMobile(address,mobile);
        return users;
    }
}
