package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.LoginDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.exception.GlobalException;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.rabbitmq.RabbitMQSender;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.util.EmailService;
import com.bridgelabz.fundoonotes.util.MailObject;
import com.bridgelabz.fundoonotes.util.TokenUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.regex.Pattern.matches;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private EmailService emailService;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Autowired
    private MailObject mailObject;

    @Autowired
    private RabbitTemplate template;

    @Override
    public List<User> getUserData() {
        return userRepository.findAll();
    }
    @Override
    public User getUserDataById(String token) {
        long id = tokenUtil.decodeToken(token);
        return userRepository.findById(id).orElseThrow(() -> new GlobalException("User Id With " +
                id + " Does Not Exist"));
    }
    @Override
    public User register(UserDTO userDTO){
        User userData = new User(userDTO);
        Notes notes = new Notes();
        System.out.println(notes);
        userRepository.save(userData);
        String token = tokenUtil.createToken(userData.getId());
        userData.setToken(token);
        mailObject.setEmail(userData.getEmail());
        mailObject.setMessage("registration Verification link" +token );
        mailObject.setSubject("Verification");

        rabbitMQSender.send(mailObject);
//        String user = emailService.getLink(token);
//        emailService.sendEmail(token);
//        emailService.getLink(userDTO.email);

        return userRepository.save(userData);
    }

//    @Override
//    public ResponseDTO newUser(UserDTO userDTO) {
//        User user = new User(userDTO);
//        userRepository.save(user);
//        String token = tokenUtil.createToken(user.getId());
//        user.setToken(token);
//        String email = emailService.sendEmail();
//        System.out.println(email);
//        return new ResponseDTO("Creat new user",user);
//    }

    @Override
    public User login(LoginDTO loginDTO) {
        User user = userRepository.findEmail(loginDTO.getEmail());
        if (user.isVerified())
            if (matches(loginDTO.getPassword(), user.getPassword())) {
                return user;
            }
        return null;
    }
    @Override
    public User verify(String token) {
        User user = this.getUserDataById(token);
        user.setVerify(true);
        userRepository.save(user);
        return user;
    }
    @Override
    public User updateUserData(String token, UserDTO userDTO){
        long userId = tokenUtil.decodeToken(token);
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            User user1 = new User(userDTO);
            userRepository.save(user1);
            return user1;
        }
        else {
            throw new GlobalException("Id not found ");
        }
    }
    @Override
    public String deleteUserData(String token) {
        long ID = tokenUtil.decodeToken(token);
        Optional<User> user = userRepository.findById(ID);
        if (user.isPresent()){
            userRepository.deleteById(ID);
            return "Data Deleted";
        }
        throw new GlobalException("User id " + ID +" is not found");
    }
    @Override
    public String Search(LoginDTO loginDTO) {
        User userDetails = userRepository.findByEmail(loginDTO.getEmail());
        if(userDetails != null)
        {
            throw new GlobalException( loginDTO.getEmail() + " not found!");
        }
        return "USer Logged in Successfully";
    }
  //  @Override
//    public String resetPassword(String email, UserDTO userDTO) {
//        User registrationDetails = userRepository.findPass(email);
//        if (registrationDetails != null) {
//            registrationDetails.setPassword(userDTO.getPassword());
//            userRepository.save(registrationDetails);
//            return "Password Updated";
//        } else {
//            return "Wrong Email Id Provide !!!";
//        }
//    }
//    @Override
//    public User forgotPassword(String emailId, String password) {
//        Optional<User> isUserPresent = userRepository.findByEmailId(emailId);
//        if (isUserPresent.isPresent()) {
//            isUserPresent.get().setPassword(password);
//            return userRepository.save(isUserPresent.get());
//        } else {
//            throw new GlobalException("Invalid Email");
//        }
//    }
}
