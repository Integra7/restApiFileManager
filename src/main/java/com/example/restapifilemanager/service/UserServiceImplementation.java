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

   // @Autowired
    //private RoleDao roleDao;

    @Override
    public void save(UserModel userModel)
    {
        userModel.setPassWord(userModel.getPassWord());
        //Set<RoleModel> roles = new HashSet<>();
        //roles.add(roleDao.getOne(1L));
        //userModel.setRoles(roles);
        userModelRepo.save(userModel);
    }
    @Override
    public UserModel findByUserName(String username)
    {
        return userModelRepo.findByUserName(username);
    }
}
