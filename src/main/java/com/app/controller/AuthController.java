package com.app.controller;

import com.app.entity.User;
import com.app.payload.JWTTokenDto;
import com.app.payload.LoginDto;
import com.app.repository.UserRepository;
import com.app.service.OTPService;
import com.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
     private UserRepository userRepository;
     private UserService userService;
     private OTPService otpService;
//     private PasswordEncoder passwordEncoder;
     public AuthController(UserRepository userRepository ,UserService userService,OTPService otpService/*, PasswordEncoder passwordEncoder */) {
          this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
           this.userService=userService;
         this.otpService = otpService;
     }

     @PostMapping("/signup")
     public ResponseEntity<?> createUser(@RequestBody User user){
          Optional<User> opUsername= userRepository.findByUsername(user.getUsername());
          if(opUsername.isPresent()){
               return new ResponseEntity<>("username exists", HttpStatus.INTERNAL_SERVER_ERROR);
          }
          Optional<User> opEmail= userRepository.findByEmailId(user.getEmailId());
          if(opEmail.isPresent()){
               return new ResponseEntity<>("email exists", HttpStatus.INTERNAL_SERVER_ERROR);
          }
//         String encodedPassword = passwordEncoder.encode(user.getPassword());
//          user.setPassword(encodedPassword);
         String hashpw= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
          user.setPassword(hashpw);
          user.setRole("ROLE_USER");
          userRepository.save(user);
          return new ResponseEntity<>("user created", HttpStatus.CREATED);
     }

    @PostMapping("/content-manager-signup")
    public ResponseEntity<?> createContentManagerAccount(@RequestBody User user){
        Optional<User> opUsername= userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("username exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opEmail= userRepository.findByEmailId(user.getEmailId());
        if(opEmail.isPresent()){
            return new ResponseEntity<>("email exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String hashpw= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user.setRole("ROLE_CONTENTMANAGER");
        userRepository.save(user);
        return new ResponseEntity<>("user created", HttpStatus.CREATED);
    }

    @PostMapping("/blog-manager-signup")
    public ResponseEntity<?> createBlogManagerAccount(@RequestBody User user){
        Optional<User> opUsername= userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("username exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opEmail= userRepository.findByEmailId(user.getEmailId());
        if(opEmail.isPresent()){
            return new ResponseEntity<>("email exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String hashpw= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user.setRole("ROLE_BLOGMANAGER");
        userRepository.save(user);
        return new ResponseEntity<>("user created", HttpStatus.CREATED);
    }

     @PostMapping("/usersign")
     public ResponseEntity<?> userSignIn(@RequestBody LoginDto dto){
    String jwtToken = userService.verifyLogin(dto);
    if(jwtToken!=null){
        JWTTokenDto tokenDto = new JWTTokenDto();
        tokenDto.setToken(jwtToken);
        tokenDto.setTokenType("JWT");
        return new ResponseEntity<>(tokenDto, HttpStatus.CREATED);
    }
         return new ResponseEntity<>("Invalid Token", HttpStatus.INTERNAL_SERVER_ERROR);
     }
     @PostMapping("/login-otp")
     public String generateOtp(@RequestParam String mobile){
        Optional<User> opUser= userRepository.findByMobile(mobile);
        if(opUser.isPresent()){
            String otp= otpService.generatedOTP(mobile);
            return otp + "   " + mobile;
        }
         return "User not found";

     }
}
