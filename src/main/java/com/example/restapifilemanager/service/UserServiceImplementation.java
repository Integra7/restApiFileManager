package com.example.restapifilemanager.service;


//import com.example.restapifilemanager.dao.RoleDao;
import com.example.restapifilemanager.repo.UserModelRepo;
import com.example.restapifilemanager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService
{
    @Autowired
    private UserModelRepo userModelRepo;

    @Override
    public void save(UserModel userModel)
    {
        userModel.setPassWord(userModel.getPassWord());
        userModelRepo.save(userModel);
    }
    @Override
    public UserModel findByUserName(String username)
    {
        return userModelRepo.findByUserName(username);
    }
    @Override

    public UserModel findByUserNameAndPassword(String username, String password)
    {
        UserModel checked = findByUserName(username);
        if (password == checked.getPassWord())
            return checked;
        return null;
    }

    public UserModel authenticate(String username, String password)
    {
        return userModelRepo.findByUserNameAndPassWord(username,password);
    }

}
