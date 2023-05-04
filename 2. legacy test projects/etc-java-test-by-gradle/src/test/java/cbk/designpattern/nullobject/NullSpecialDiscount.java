package cbk.designpattern.nullobject;

class NullSpecialDiscount extends SpecialDiscount {
    @Override
    public void addDetailTo(Bill bill) {
        // 그 어떤 것도 하지 않는다
    }
}
