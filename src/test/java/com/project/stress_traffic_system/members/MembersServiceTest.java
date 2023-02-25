package com.project.stress_traffic_system.members;//package com.project.stress_traffic_system.members;

import com.project.stress_traffic_system.cart.repository.CartRepository;
import com.project.stress_traffic_system.jwt.JwtUtil;
import com.project.stress_traffic_system.members.dto.LoginRequestDto;
import com.project.stress_traffic_system.members.dto.MembersResponseMsgDto;
import com.project.stress_traffic_system.members.dto.SignupRequestDto;
import com.project.stress_traffic_system.members.entity.Members;
import com.project.stress_traffic_system.members.entity.MembersRoleEnum;
import com.project.stress_traffic_system.members.repository.MembersRepository;
import com.project.stress_traffic_system.members.service.MembersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class) //Mockito 의 가짜 객체를 사용
@SpringBootTest
public class MembersServiceTest {

    @Autowired //로그테스트할 때는 실제 DB를 이용
    MembersService memberService;

    @Mock //가짜 객체
    MembersRepository membersRepository;

    //Mock MembersService 를 만들 때 주입할 객체들//
    @Mock
    CartRepository cartRepository;
    @Mock
    JwtUtil jwtUtil;
    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입 기능 확인")
    public void signup() throws Exception {
        //given
        //Mock 서비스 생성
        MembersService MockMembersService = new MembersService(membersRepository,cartRepository,jwtUtil,passwordEncoder);

        SignupRequestDto signupRequestDto = SignupRequestDto.builder()
                .username("usertest")
                .password("abc1234!")
                .address("서울")
                .build();

        Members members = new Members("usertest","abc1234!","서울", MembersRoleEnum.MEMBER);

        //실제 리포지터리를 따라서 custom 레포지터리를 구현
        //Mock 레포지터리에 멤버클래스를 저장하면 멤버를 반환한다.
        when(membersRepository.save(any(Members.class))).thenReturn(members);
        //유저를 찾을 때 회원가입을 하기위해 Optional.empty를 반환
        when(membersRepository.findByUsername(members.getUsername())).thenReturn(Optional.empty());

        //Mock 서블릿 생성
        HttpServletResponse response = mock(HttpServletResponse.class);


        //when /*회원가입을 하면 Mock 레포터리에 저장된다.*/
        MembersResponseMsgDto responseMsgDto = MockMembersService.signup(signupRequestDto,response);

        //then
        assertThat(responseMsgDto.getMsg()).isEqualTo("회원가입 성공");
    }

    //로그인은 실제 DB와 연동이 되는지 확인하기 위해 통합테스로 진행한다.
    @Test
    @DisplayName("로그인 기능 확인")
    public void login() throws Exception {
        //given
        //실제 DB에 있는 아이디와 비밀번호
        String username = "zser27";
        String password = "abcde123?";

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .username(username)
                .password(password)
                .build();

        HttpServletResponse response = mock(HttpServletResponse.class);

        //when
        MembersResponseMsgDto responseMsgDto =  memberService.login(loginRequestDto, response);

        //then
        assertThat(responseMsgDto.getMsg()).isEqualTo("로그인 성공");
    }

}