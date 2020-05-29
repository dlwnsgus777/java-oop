package bowling.domain;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlayerTests {

    @Test
    public void 플레이어이름이_잘_생성되는가() {
        try {
            // when
            Player player = new Player("test");

            // then
            Field field =  player.getClass().getDeclaredField("name");
            field.setAccessible(true);

            String playerName = (String)field.get(player);

            assertThat(playerName, is("test"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}