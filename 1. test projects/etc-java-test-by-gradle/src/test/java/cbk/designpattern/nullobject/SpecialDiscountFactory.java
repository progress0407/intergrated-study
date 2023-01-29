package cbk.designpattern.nullobject;

class SpecialDiscountFactory {

    public SpecialDiscount create(Customer customer) {
        if (checkNewCustomer(customer)) {
            return new NewCustomerDiscount();
        }

        // 특별 할인 혜택이 없을 때 null 대신할 객체를 리턴한다
        return new NullSpecialDiscount();
    }

    private boolean checkNewCustomer(Customer customer) {
        return false;
    }
}
