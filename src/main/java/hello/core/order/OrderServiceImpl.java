package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRe;
    private final DiscountPolicy discount;

    public OrderServiceImpl(MemberRepository memberRe, DiscountPolicy discount) {
        this.memberRe = memberRe;
        this.discount = discount;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRe.findById(memberId);
        int discountPRice = discount.discount(member, itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPRice);
    }
}
