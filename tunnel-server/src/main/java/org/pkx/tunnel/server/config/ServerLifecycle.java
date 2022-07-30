package org.pkx.tunnel.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerLifecycle implements SmartLifecycle {

    private final NettyServer nettyServer;

    @Override
    public void start() {
        nettyServer.run();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
