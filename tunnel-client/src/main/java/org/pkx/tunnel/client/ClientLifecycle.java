package org.pkx.tunnel.client;

import lombok.RequiredArgsConstructor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientLifecycle implements SmartLifecycle {

    private final NettyClient nettyServer;

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
