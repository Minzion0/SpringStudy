package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRe = new MemoryMemberRepository();
    private final DiscountPolicy discount = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRe.findById(memberId);
        int discountPRice = discount.discount(member, itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPRice);
    }
}
