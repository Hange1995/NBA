package com.hardworking.training.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Random {
    List<User> users=new ArrayList<>();
    AtomicInteger counter = new AtomicInteger();
//    final int MAX_ROW_LENGTH = 3;
//    public List<List<Long>> printUser(List<User> users){
//        List<List<Long>> usersId =new ArrayList<>();
//        users.stream().forEach( (User user) -> {
//            if (counter.getAndIncrement() % MAX_ROW_LENGTH == 0){
//                usersId.add(new ArrayList<>());
//            }
//            usersId.get(usersId.size()-1).add(user.getId());}
//        );
//        return
//    }

    public static void main(String[] args) {
        User u1=new User();
        User u2=new User();
        User u3=new User();
        User u4=new User();
        User u5=new User();
        User u6=new User();
        User u7=new User();
        User u8=new User();
        User u9=new User();
        List<User> users=new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);
        users.add(u8);
        users.add(u9);
        Random random=new Random();
//        System.out.println(random.printUser(users));
    }
}
