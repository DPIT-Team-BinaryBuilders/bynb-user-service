//package com.binarybuilders.bynb_user_service.controller;
//
//import com.binarybuilders.bynb_user_service.service.DangerRequestService;
//import com.binarybuilders.bynb_user_service.service.UserService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    private final DangerRequestService dangerRequestService;
//
//    public UserController(DangerRequestService dangerRequestService) {
//        this.dangerRequestService = dangerRequestService;
//    }
//
//    @GetMapping("/user/{userId}/danger")
//    public String getDangerId(@PathVariable String userId) {
//        return dangerRequestService.getDangerId(userId);
//    }
//}