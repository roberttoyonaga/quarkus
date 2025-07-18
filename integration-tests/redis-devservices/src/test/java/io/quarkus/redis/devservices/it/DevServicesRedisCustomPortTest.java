package io.quarkus.redis.devservices.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.redis.devservices.it.profiles.DevServicesCustomPortProfile;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.ports.SocketKit;

@QuarkusTest
@TestProfile(DevServicesCustomPortProfile.class)
public class DevServicesRedisCustomPortTest {

    @Test
    @DisplayName("should start redis container with the given custom port")
    public void shouldStartRedisContainer() {
        Assertions.assertTrue(SocketKit.isPortAlreadyUsed(6371));
    }

}
