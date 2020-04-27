package com.xiaofsu.service.impl;

import com.xiaofsu.dao.PaymentDao;
import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;
import com.xiaofsu.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author xiaoFsu
 * @since 2020-04-27 18:04:36
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @param serverPort
     * @return 实例对象
     */
    @Override
    public CommonResult queryById(Long id, String serverPort) {

        Payment payment = this.paymentDao.queryById(id);
        if(null != payment) {
            return new CommonResult(200, "查询数据成功！"+serverPort,payment);
        }else{
            return new CommonResult(500,"查询数据失败!"+serverPort,null);
        }
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Payment> queryAllByLimit(int offset, int limit) {
        return this.paymentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        this.paymentDao.insert(payment);
        return payment;
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
//    @Override
//    public Payment update(Payment payment) {
//        this.paymentDao.update(payment);
//        return this.queryById(payment.getId());
//    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.paymentDao.deleteById(id) > 0;
    }
}