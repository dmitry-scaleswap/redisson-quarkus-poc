package com.example.playground;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import org.redisson.api.RedissonClient;

@Dependent
public class RedissonConfig {
  void startup(@Observes StartupEvent event, RedissonClient redissonClient, DummySpec dummySpec) {
    var remoteService = redissonClient.getRemoteService();
    remoteService.register(DummySpec.class, dummySpec, 10);
  }
}
