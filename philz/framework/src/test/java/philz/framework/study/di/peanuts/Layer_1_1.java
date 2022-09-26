package philz.framework.study.di.peanuts;

import philz.framework.study.di.anno.LargePeanut;

@LargePeanut
public class Layer_1_1 {

    private final Layer_2_1 layer_2_1;
    private final Layer_2_2 layer_2_2;

    public Layer_1_1(final Layer_2_1 layer_2_1, final Layer_2_2 layer_2_2) {
        this.layer_2_1 = layer_2_1;
        this.layer_2_2 = layer_2_2;
    }
}
