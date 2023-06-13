package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final   MemberRepository memberRe;
    private  final DiscountPolicy discount;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRe.findById(memberId);
        int discountPRice = discount.discount(member, itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPRice);
    }
    //테스트용
    public MemberRepository getMemberRe(){
        return memberRe;
    }
}
