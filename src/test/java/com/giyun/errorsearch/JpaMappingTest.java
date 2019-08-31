package com.giyun.errorsearch;

import com.giyun.errorsearch.domain.Board;
import com.giyun.errorsearch.domain.User;
import com.giyun.errorsearch.domain.enums.LanguageType;
import com.giyun.errorsearch.repository.BoardRepository;
import com.giyun.errorsearch.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle= "테스트";
    private final String email= "test@gamil.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init(){
        User user = userRepository.save(User.builder()
            .name("Giyun")
            .password("test")
            .email(email)
            .createdDate(LocalDateTime.now())
            .build());

        boardRepository.save(Board.builder()
            .title(boardTestTitle)
            .content("콘텐츠")
            .languageType(LanguageType.JAVA)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .user(user)
            .build());
    }

    @Test
    public void 생성돼는지_테스트(){
        User user  = userRepository.findByEmail(email);
        assertThat(user.getName(), is("Giyun"));
        assertThat(user.getPassword(), is("test"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getContent(), is("콘텐츠"));
        assertThat(board.getLanguageType(),is(LanguageType.JAVA));
    }

}
