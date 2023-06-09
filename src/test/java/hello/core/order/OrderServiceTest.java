package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService service ;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
       service= appConfig.memberService();
       orderService= appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long mamberId=1L;
        Member member = new Member(mamberId, "mamberA", Grade.VIP);
        service.join(member);
        Order order = orderService.createOrder(mamberId, "itemA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);
    }


}
