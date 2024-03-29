package com.sanq.product.redis.service;

import java.util.List;
import java.util.Set;

/**
 * version: redis
 * ---------------------
 *
 * @param
 * @author sanq.Yan
 * @date 2019/6/29
 */
public interface JedisPoolService {

    /**
     * 保存字符串
     *
     * @param key
     * @param val
     * @return
     */
    boolean set(String key, String val);

    /**
     * 保存字符串
     *
     * @param key
     * @param val
     * @param seconds 有效时间
     * @return
     */
    boolean set(String key, String val, int seconds);

    /**
     * 获取字符串
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 删除
     *
     * @param key
     * @return
     */
    boolean delete(String key);

    /**
     * 自增
     *
     * @param key
     * @return
     */
    long incr(String key);

    /**
     * 自增 存在有效期
     *
     * @param key
     * @param second
     * @return
     */
    long incrAtTime(String key, int second);

    /**
     * 自增
     *
     * @param key
     * @param max 从max开始
     * @return
     */
    long incr(String key, int max);


    /**
     * 自减
     *
     * @param key
     * @return
     */
    long decr(String key);

    /**
     * 自减
     *
     * @param key
     * @param minus 步长
     * @return
     */
    long decrBy(String key, long minus);

    /**
     * 判断redis中是否存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 根据条件查询出key
     *
     * @param pattern
     * @return
     */
    List<String> keys(String pattern);

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     * @return
     */
    boolean expire(String key, int seconds);

    /**************************华丽丽的分割线**************************************/

    /**
     * rpush
     * 将元素push在list的尾部  ==> rpop 删除尾部元素
     * <p>
     * lpush
     * 类似于压栈操作，将元素放入头部 ==> lpop 删除头部元素
     * <p>
     * 这里使用到rpush
     *
     * @param key
     * @param value
     * @return
     */
    long putList(String key, String value);

    /**
     * 移除List
     *
     * @param key
     * @return
     */
    boolean rmList(String key, long start, long end);

    /**
     * 获取List
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> getList(String key, long start, long end);

    /**
     * 获取List长度
     *
     * @param key
     * @return
     */
    long llen(String key);

    /**************************华丽丽的分割线**************************************/

    /**
     * 保存到有序set
     *
     * @param key
     * @param score
     * @param value
     * @return
     */
    boolean putSet(String key, double score, String value);

    /**
     * 获取set
     *
     * @param key
     * @param start
     * @param end
     * @param order ASC DESC
     * @return
     */
    Set<String> getSet(String key, long start, long end, String order);

    /**
     * 获取set长度
     *
     * @param key
     * @return
     */
    long zcard(String key);

    /**
     * 判断value是否存在于set中
     *
     * @param key
     * @param val
     * @return
     */
    boolean zrank(String key, String val);

    /**
     * 移除元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    long rmSet(String key, long start, long end);

    /**
     * 添加指定分数
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    double incrByScope(String key, double score, String member);

    /**************************华丽丽的分割线**************************************/

    /**
     * 添加到统计
     *
     * @param key
     * @param value
     * @return
     */
    boolean pfAdd(String key, String... value);

    /**
     * 获取统计数量
     *
     * @param key
     * @return
     */
    long pfCount(String key);

    /**
     * 位图
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    boolean setBit(String key, long offset, boolean value);

    /**
     * 获取位图
     *
     * @param key
     * @param offset
     * @return
     */
    boolean getBit(String key, long offset);

    Long bitCount(String key);

    /**
     * 执行lua脚本
     *
     * @param script
     * @param keys
     * @param args
     * @return
     */
    boolean eval(String script, List<String> keys, List<String> args);

    /**
     * 批量删除key
     *
     * @param pattern
     * @return
     */
    boolean deletes(String pattern);
}
