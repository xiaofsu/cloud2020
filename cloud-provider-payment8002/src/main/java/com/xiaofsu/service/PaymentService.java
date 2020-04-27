package com.xiaofsu.service;

import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;

import java.util.List;

/**
 * (Payment)表服务接口
 *
 * @author xiaoFsu
 * @since 2020-04-27 18:04:36
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @param serverPort
     * @return 实例对象
     */
    CommonResult queryById(Long id, String serverPort);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Payment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
//    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}