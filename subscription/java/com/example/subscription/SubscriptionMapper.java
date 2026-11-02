package com.example.subscription;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SubscriptionMapper {

    // DBからサブスク一覧を取得
    @Select("""
        SELECT
            id,
            service_name AS serviceName,
            price,
            billing_cycle AS billingCycle,
            next_renewal_date AS nextRenewalDate
        FROM subscriptions
        ORDER BY id
        """)
    List<Subscription> findAll();

    // DBに新しいサブスクを保存
    @Insert("""
        INSERT INTO subscriptions
            (service_name, price, billing_cycle, next_renewal_date)
        VALUES
            (#{serviceName}, #{price}, #{billingCycle}, #{nextRenewalDate})
        """)
    void insert(
        String serviceName,
        int price,
        String billingCycle,
        java.time.LocalDate nextRenewalDate
    );
    
    //IDを指定してサブスク1件取得
    @Select("""
    		SELECT
    		id,
    		service_name AS serviceName,
    		price,
    		billing_cycle AS billingCycle,
    		next_renewal_date AS nextRenewalDate
    		FROM subscriptions
    		WHERE id = #{id}
    		""")
   Subscription findById(int id);
    
 // サブスクの情報を更新
    @Update("""
        UPDATE subscriptions
        SET
            service_name = #{serviceName},
            price = #{price},
            billing_cycle = #{billingCycle},
            next_renewal_date = #{nextRenewalDate}
        WHERE id = #{id}
        """)
    void update(
        int id,
        String serviceName,
        int price,
        String billingCycle,
        java.time.LocalDate nextRenewalDate
    );
    

 // サブスクをデータベースから削除
    @Delete("""
        DELETE FROM subscriptions
        WHERE id = #{id}
        """)
    void deleteById(int id);
}

