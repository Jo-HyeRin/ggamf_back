package shop.ggamf.ggamf.config.dummy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import shop.ggamf.ggamf.config.enums.UserEnum;
import shop.ggamf.ggamf.domain.gameCode.GameCode;
import shop.ggamf.ggamf.domain.room.Room;
import shop.ggamf.ggamf.domain.user.User;

public abstract class DummyEntity {

    protected User newUser(String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("1234");
        User user = User.builder()
                .username(username)
                .password(encPassword)
                .name("유저이름")
                .phone("010-1234-5678" + username)
                .nickname("nick" + username)
                .email(username + "@nate.com")
                .phoneChecked(true)
                .photo("내사진입니다")
                .intro("안녕하세여 유저입니다")
                .stateId(1L)
                .role(UserEnum.USER)
                .build();
        return user;
    }

    protected GameCode newGameCode(String gamename) {
        GameCode gameCode = GameCode.builder()
                .logo(gamename + "사진")
                .gameName(gamename)
                .build();
        return gameCode;
    }

    protected Room newRoom(String roomname, User user, GameCode gameCode) {
        Room room = Room.builder()
                .user(user)
                .gameCode(gameCode)
                .gameName("게임이름")
                .roomName(roomname)
                .totalPeople(3L)
                .active(true)
                .build();
        return room;
    }
}
