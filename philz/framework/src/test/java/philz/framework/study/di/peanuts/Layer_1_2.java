package philz.framework.study.di.peanuts;

import philz.framework.study.di.anno.LargePeanut;

@LargePeanut
public class Layer_1_2 {

    private Layer_2_3 layer_2_3;

    public Layer_1_2(final Layer_2_3 layer_2_3) {
        this.layer_2_3 = layer_2_3;
    }
}
