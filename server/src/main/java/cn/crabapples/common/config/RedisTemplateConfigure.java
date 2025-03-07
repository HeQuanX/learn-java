package cn.crabapples.common.config;

import com.alibaba.fastjson2.support.spring.data.redis.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Map;

/**
 * TODO redisTemplate配置
 *
 * @author Mr.He
 * 2020/1/30 22:31
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name 29404
 */
@Configuration
public class RedisTemplateConfigure {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 字符串Key序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 对象值序列化
        FastJsonRedisSerializer<Object> objectRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setValueSerializer(objectRedisSerializer);
        redisTemplate.setHashValueSerializer(objectRedisSerializer);

        redisTemplate.setDefaultSerializer(objectRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Map<String, Map<String, String>>> dictRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<String, Map<String, String>>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 字符串Key序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 对象值序列化
        FastJsonRedisSerializer<Object> objectRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setValueSerializer(objectRedisSerializer);
        redisTemplate.setHashValueSerializer(objectRedisSerializer);

        redisTemplate.setDefaultSerializer(objectRedisSerializer);
        return redisTemplate;
    }


//    @Bean
//    public RedisTemplate<String, Map<String, List<Map<String, String>>>> dictRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Map<String, List<Map<String, String>>>> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        // 字符串Key序列化
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        // 对象值序列化
//        FastJsonRedisSerializer<Object> objectRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
//        redisTemplate.setValueSerializer(objectRedisSerializer);
//        redisTemplate.setHashValueSerializer(objectRedisSerializer);
//
//        redisTemplate.setDefaultSerializer(objectRedisSerializer);
//        return redisTemplate;
//    }


}
