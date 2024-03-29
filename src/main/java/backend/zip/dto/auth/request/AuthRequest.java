package backend.zip.dto.auth.request;

import backend.zip.domain.enums.Role;
import backend.zip.domain.enums.SocialType;
import backend.zip.domain.user.User;
import lombok.Getter;

public class AuthRequest {
    @Getter
    public static class SignUpRequest{
        String email;
        String password;
        String nickName;

        public User toUser(String encodedPassword) {
            return User.builder()
                    .email(this.email)
                    .password(encodedPassword)
                    .nickName(this.nickName)
                    .role(Role.ROLE_USER)
                    .build();
        }
    }
    @Getter
    public static class LoginRequest{
        String email;
        String password;
    }

    @Getter
    public static class KakaoLoginRequest{
        String socialId;
        String email;
        String nickName;
        public User toUser(String encodedPassword) {
            return User.builder()
                    .socialId(this.socialId)
                    .email(this.email)
                    .password(encodedPassword)
                    .nickName(this.nickName)
                    .role(Role.ROLE_USER)
                    .socialType(SocialType.KAKAO)
                    .build();
        }
    }

    @Getter
    public static class AuthcodeRequest {
        String email;
    }

    @Getter
    public static class VerificationRequest {
        String email;
        String code;
    }
}
