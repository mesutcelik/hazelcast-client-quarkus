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
        Scanner console = new Scanner(System.in);
        System.out.print("Enter networking address: ");
        String ip = console.nextLine();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(ip);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
