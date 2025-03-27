package com.example.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
@Service
public class UserService {
    @Autowired
    private com.example.demo.respositories.UserRepository rep;
    public User addUser(User u)
    {
        return rep.save(u);
    }
    public List<User>getUser()
    {
        return rep.findAll();
    }
    public User updatebyid(Long id,User user)
    {
        user.setId(id);
        return rep.save(user);
    }
    public String deleteusersbyid(Long id)
    {
        rep.deleteById(id);
        return "User deleted successfully";
    }
    public Page<User> paginated(int page,int size){
        Pageable pageable=PageRequest.of(page,size,Sort.by("name").ascending());
        return rep.findAll(pageable);
    }
    
    public User getUserByEmail(String email) {
        return rep.findByEmail(email);
    }
}
