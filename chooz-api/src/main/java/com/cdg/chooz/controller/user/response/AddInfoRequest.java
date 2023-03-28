package com.cdg.chooz.controller.user.response;

import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 유저 정보 추가 기입 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddInfoRequest {

    private MbtiType mbti;

    private Integer age;

    private GenderType gender;

}
