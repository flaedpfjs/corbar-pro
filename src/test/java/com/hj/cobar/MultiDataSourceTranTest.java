package com.hj.cobar;

import com.alibaba.cobar.client.transaction.MultipleDataSourcesTransactionManager;
import com.hj.cobar.bean.Cont;
import com.hj.cobar.bean.Tb2;
import com.hj.cobar.service.ContService;
import com.hj.cobar.service.Tb2Service;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Random;


/**
 *  分库分表
 */
public class MultiDataSourceTranTest extends TestCase {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    Tb2Service tb2Service = (Tb2Service) context.getBean("tb2Service");

    private ContService contService = (ContService)context.getBean("contService");

    private MultipleDataSourcesTransactionManager transactionManager = (MultipleDataSourcesTransactionManager)context.getBean("transactionManager");


    /**
     * 对于分库分表的数据源可以做到事务回滚 但是单数据源与分库分表的数据进行插入时，无法做到回滚如：
     * tb2插入成功，但是Cont插入失败，导致tb2的数据无法回滚
     */
    public void test1(){
        DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
        txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = transactionManager.getTransaction(txDef);
        try {
            Tb2 tb2 = new Tb2();
            tb2Service.addTb2(tb2);

            Cont cont = new Cont();
            cont.setName("gd-rollback");
            Long taobaoId = new Long(new Random().nextInt(10000));
            cont.setTaobaoId(taobaoId);

            Cont cont1 = null;
            System.out.print(cont1.getId());
            contService.addCont(cont);


        } catch (Exception e) {
            System.out.println(e);
            transactionManager.rollback(transactionStatus);
            return;
        }

        transactionManager.commit(transactionStatus);



    }

    /**
     * 对于分库分表的数据源可以做到事务回滚 但是单数据源与分库分表的数据进行插入时，无法做到回滚如：
     * cont插入成功，但是tb2插入失败，cont数据是可以回滚
     */
    public void test2(){
        DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
        txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = transactionManager.getTransaction(txDef);
        try {
            Cont cont = new Cont();
            cont.setName("gd-rollback");
            Long taobaoId = new Long(new Random().nextInt(10000));
            cont.setTaobaoId(taobaoId);

            contService.addCont(cont);

            Tb2 tb2 = new Tb2();
            Tb2 tb21 = null;
            System.out.print(tb21.getId());
            tb2Service.addTb2(tb2);


        } catch (Exception e) {
            System.out.println(e);
            transactionManager.rollback(transactionStatus);
            return;
        }

        transactionManager.commit(transactionStatus);



    }


}
