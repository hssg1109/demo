package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.User;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserAccountService {
    //private final UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired  //add
    private UserRepository userRepository;

    public void createAccount(Long userId, UserAccount userAccount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userAccount.setUser(user);
        userAccountRepository.save(userAccount);
    }

    
    // @Transactional
    // public UserAccount openNewAccount(Long userId, String accountNum, String accountPW) {
    //     //add
    //     User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("사용자를 찾을 수 없습니다."));
        
    //     UserAccount account = new UserAccount();
    //     account.setAccountNum(accountNum);
    //     account.setAccountPW(accountPW);
    //     //add
    //     account.setUser(user);//연결된 유저 설정

    //     return this.userAccountRepository.save(account); // 저장 후 엔티티 반환
    // }
}