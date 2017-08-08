package com.statrix.rest.service.repository;


import com.statrix.rest.models.Users;
import com.statrix.rest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Users> users;

    static{
        users = populateDummyUsers();
    }

    @Override
    public Users findById(long id) {
        for(Users user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public Users findByName(String name) {
        for(Users user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(Users user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(Users user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(long id) {
        for (Iterator<Users> iterator = users.iterator(); iterator.hasNext(); ) {
            Users user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Users> findAllUsers() {
        return users;
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(Users user) {
        return findByName(user.getName())!=null;
    }

    private static List<Users> populateDummyUsers(){
        List<Users> users = new ArrayList<Users>();
        users.add(new Users(counter.incrementAndGet(),"Vasya","123@m.ru","qwerty", 123));
        users.add(new Users(counter.incrementAndGet(),"Petya","123@m.ru","qwerty", 123));
        users.add(new Users(counter.incrementAndGet(),"Masha","123@m.ru","qwerty", 123));
        return users;
    }
}
