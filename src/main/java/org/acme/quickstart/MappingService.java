package org.acme.quickstart;

import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;


@ApplicationScoped
public class MappingService {

    @Inject
    HazelcastInstance instance;

    private Map<String,String> retrieveMap() {
        return instance.getMap("map");
    }

    public String put(String key,String value) {
        retrieveMap().put(key, value);
        return value;

    }

    public String get(String key) {
        String value = retrieveMap().get(key);
        return value;
    }


}