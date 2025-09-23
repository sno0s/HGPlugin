package br.dev.sno0s.hgplugin.tests;

import br.dev.sno0s.hgplugin.listeners.PlayerJoinListener;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerJoinListenerTest {

    @Test
    void instanciaNaoEhNula() {
        PlayerJoinListener listener = new PlayerJoinListener();
        assertNotNull(listener);
    }
}
