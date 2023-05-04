package cbk.designpattern.nullobject;

class NewCustomerDiscount extends SpecialDiscount{
    
    @Override
    public void addDetailTo(Bill bill) {
        // 신규 고객을 위한 파격 할인 로직
    }
}
