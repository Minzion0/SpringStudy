package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRe;
    private  DiscountPolicy discount;
    @Autowired
    public void setDiscount(DiscountPolicy discount) {
        System.out.println("discount = " + discount);
        this.discount = discount;
    }
   @Autowired
    public void setMemberRe(MemberRepository memberRe) {
        System.out.println("memberRe = " + memberRe);
        this.memberRe = memberRe;
    }

   @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository 2= " + memberRepository);
        System.out.println("discountPolicy 2= " + discountPolicy);
        this.memberRe = memberRepository;
        this.discount = discountPolicy;
    }

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
