package com.cdg.chooz.entity.user;


import com.cdg.chooz.domain.user.ProvidersType;
import com.cdg.chooz.domain.user.RoleType;
import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import com.cdg.chooz.entity.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String email;

    private String imageUrl;

    private String password;

    @Enumerated(EnumType.STRING)
    private ProvidersType provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지

    private String providerId;  // oauth2를 이용할 경우 아이디값

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private MbtiType mbti;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
//    @JoinColumn(name = "USER_ID")
//    private List<CategoryEntity> categoryLists = new ArrayList<>();

    @Column(name = "modified_MBTI_Date")
    private LocalDateTime modifiedMBTIDate;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Bookmark> bookmarkList = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<CommentEmotion> commentEmotionList = new ArrayList<>();


//    public void mappingCommentLike(CommentEmotion commentEmotion) {
//        this.commentEmotionList.add(commentEmotion);
//    }

//    public void mappingBookmark(Bookmark bookmark) {
//        this.bookmarkList.add(bookmark);
//    }

//    public void updateProfile(String nickname, String image) {
//        this.nickname = nickname;
//        this.imageUrl = image;
//    }
//
//    public void updateMbti(MbtiType mbti, LocalDateTime modifiedMBTIDate) {
//        this.mbti = mbti;
//        this.modifiedMBTIDate = modifiedMBTIDate;
//    }

    public void addUserInfo(Integer age, MbtiType mbti, GenderType gender) {
        this.age = age;
        this.mbti = mbti;
        this.gender = gender;
    }

    @Builder
    // public User(String nickname, String email, String imageUrl, String password, ProvidersType provider, String providerId, RoleType role, Integer age, GenderType gender, MbtiType mbti, List<CategoryEntity> categoryLists, LocalDateTime modifiedMBTIDate)
    public User(String nickname, String email, String imageUrl, String password, ProvidersType provider, String providerId, RoleType role, Integer age, GenderType gender, MbtiType mbti, LocalDateTime modifiedMBTIDate){
        this.nickname = nickname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.mbti = mbti;
        // this.categoryLists = categoryLists;
        this.modifiedMBTIDate = modifiedMBTIDate;
    }

//    public AgeType classifyAge(Integer age){
//        AgeType ageGroup;
//        switch (age/10){
//            case 1:
//                ageGroup = AgeType.teenager;
//                break;
//            case 2:
//                ageGroup = AgeType.twenties;
//                break;
//            case 3:
//                ageGroup = AgeType.thirties;
//                break;
//            case 4:
//                ageGroup = AgeType.fourties;
//                break;
//            case 5:
//                ageGroup = AgeType.fifties;
//                break;
//            default:
//                ageGroup = AgeType.NULL;
//                break;
//        }
//        return ageGroup;
//    }
//    public void clearCategoryList(){
//        this.categoryLists.clear();
//    }

}
