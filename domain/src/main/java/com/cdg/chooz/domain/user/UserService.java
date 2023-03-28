package com.cdg.chooz.domain.user;

import com.cdg.chooz.controller.user.response.AddInfoRequest;
import com.cdg.chooz.entity.user.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Service
public class UserService {

    public void addUserInfo(AddInfoRequest addInfoRequest, Long userId) {
    //public void addUserInfo(AddInfoRequest addInfoRequest, Long userId) throws NotFoundException{
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new NotFoundException("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
        }

        User user = byId.get();
        user.addUserInfo(addInfoRequest.getAge(), addInfoRequest.getMbti(), addInfoRequest.getGender());



        userRepository.save(user);

    }
}
