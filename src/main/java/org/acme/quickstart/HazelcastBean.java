package org.acme.quickstart;

import com.hazelcast.client.config.ClientConfig;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.client.HazelcastClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HazelcastBean {


    @Produces
    HazelcastInstance createInstance() {
        ClientConfig clientConfig = new ClientConfig();
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
