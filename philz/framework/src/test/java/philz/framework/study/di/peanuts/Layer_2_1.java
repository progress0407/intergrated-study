package philz.framework.study.di.peanuts;

import philz.framework.study.di.anno.MiddlePeanut;

@MiddlePeanut
public class Layer_2_1 {

    private Layer_3_1 layer_3_1;

    public Layer_2_1(final Layer_3_1 layer_3_1) {
        this.layer_3_1 = layer_3_1;
    }
}
