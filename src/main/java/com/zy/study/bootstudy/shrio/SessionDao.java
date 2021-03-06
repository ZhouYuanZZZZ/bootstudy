package com.zy.study.bootstudy.shrio;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.Serializable;

@Repository("sessionDao")
public class SessionDao extends EnterpriseCacheSessionDAO {

    private static final Logger logger = LoggerFactory.getLogger(SessionDao.class);

    @Resource
    private JedisPool jedisPool;

    private final String  SESSIONID_PREFIX = "sessionId-";

    private final int KEY_EXPIRE_TIME = 60*60;

    private JavaUuidSessionIdGenerator sessionIdGenerator = new JavaUuidSessionIdGenerator();



    public SessionDao(){
        super();
        this.setSessionIdGenerator(sessionIdGenerator);
    }

    @Override
    protected Serializable doCreate(Session session) {
        logger.info("doCreate start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(1);

            String uuid = (String) generateSessionId(session);
            assignSessionId(session,uuid);
            resource.set(SerializationUtils.serialize(SESSIONID_PREFIX+uuid), SerializationUtils.serialize(session));
            resource.expire(SerializationUtils.serialize(SESSIONID_PREFIX+uuid),KEY_EXPIRE_TIME);
        } catch (Exception e) {
            logger.error("doCreate error", e);
        }finally {
            if(resource != null){
                resource.close();
            }
            logger.info("doCreate end");
        }

        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info("doReadSession start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(1);

            byte[] bytes = resource.get(SerializationUtils.serialize(SESSIONID_PREFIX+sessionId));
            Session session = (Session) SerializationUtils.deserialize(bytes);
            return session;
        } catch (Exception e) {
            logger.error("doReadSession error", e);
            return null;
        }finally {
            if(resource != null){
                resource.close();
            }
            logger.info("doReadSession end");
        }
    }

    @Override
    protected void doUpdate(Session session) {
        logger.info("doUpdate start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(1);

            resource.set(SerializationUtils.serialize(SESSIONID_PREFIX+session.getId()), SerializationUtils.serialize(session));
            resource.expire(SerializationUtils.serialize(SESSIONID_PREFIX+session.getId()),KEY_EXPIRE_TIME);

        } catch (Exception e) {
            logger.error("doUpdate error", e);
        }finally {
            if(resource != null){
                resource.close();
            }
            logger.info("doUpdate end");
        }

    }

    @Override
    protected void doDelete(Session session) {
        logger.info("doDelete start");
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(1);

            resource.del(SerializationUtils.serialize(SESSIONID_PREFIX+session.getId()));

        } catch (Exception e) {
            logger.error("doDelete error", e);
        }finally {
            if(resource != null){
                resource.close();
            }
            logger.info("doDelete end");
        }
    }
}
