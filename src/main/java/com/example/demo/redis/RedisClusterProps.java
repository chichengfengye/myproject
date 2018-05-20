package com.example.demo.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ConfigurationProperties(prefix = "redis")
public class RedisClusterProps {
    private List<Name> nodes;
    private int timeout;
    private final RedisClusterProps.Pool pool = new RedisClusterProps.Pool();

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public RedisClusterProps.Pool getPool() {
        return pool;
    }

    public List<Name> getNodes() {
        return nodes;
        /*Set<HostAndPort> hostAndPortSet = new HashSet<>();
        for (Name name:nodes) {
            HostAndPort hostAndPort = new HostAndPort(name.getHost(), name.getPort());
            hostAndPortSet.add(hostAndPort);
        }

        return hostAndPortSet;*/
    }

    public void setNodes(List<Name> nodes) {
        this.nodes = nodes;
    }

    public static class Name{
        public String host;
        public int port;
        public String getHost(){
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }
        public int getPort(){
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

    public static class Pool {
        public int maxTotal;
        public int maxIdle;
        public int minIdle;
        public long maxWaitMillis;
        public boolean testWhileIdle;
        public boolean testOnBorrow;
        public boolean testOnReturn;

        public int getMaxTotal() {
            return maxTotal;
        }

        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        public long getMaxWaitMillis() {
            return maxWaitMillis;
        }

        public void setMaxWaitMillis(long maxWaitMillis) {
            this.maxWaitMillis = maxWaitMillis;
        }

        public boolean isTestWhileIdle() {
            return testWhileIdle;
        }

        public void setTestWhileIdle(boolean testWhileIdle) {
            this.testWhileIdle = testWhileIdle;
        }

        public boolean isTestOnBorrow() {
            return testOnBorrow;
        }

        public void setTestOnBorrow(boolean testOnBorrow) {
            this.testOnBorrow = testOnBorrow;
        }

        public boolean isTestOnReturn() {
            return testOnReturn;
        }

        public void setTestOnReturn(boolean testOnReturn) {
            this.testOnReturn = testOnReturn;
        }
    }
}
