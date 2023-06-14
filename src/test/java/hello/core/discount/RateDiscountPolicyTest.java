package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.lang.annotation.RetentionPolicy;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Component
@MainDiscountPolicy
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy =new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10%할인이 적용되어야 한다")
    void vip_o(){
        //given

        Member member = new Member(1L, "MemberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인적용 없음")
    void vip_x(){

        Member member = new Member(1L, "MemberBasic", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}