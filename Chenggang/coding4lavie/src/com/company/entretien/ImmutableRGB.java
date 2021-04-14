package com.company.entretien;

/**
 * 不可变对象，只提供getter，不提供setter
 */
public class ImmutableRGB {

    private final ColorBox colorBox;


    public ImmutableRGB(int R, int G, int B) {
        this.colorBox = new ColorBox(R, G, B);
    }

    /**
     * 获取box时返回的是新对象，类似于深拷贝，保证引用数据类型也无法修改其内存中的值
     *
     * @return ColorBox
     */
    public ColorBox getColorBox() {
        return new ColorBox(this.colorBox.R, this.colorBox.G, this.colorBox.B);
    }

    /**
     *  box存储R G B信息，final修饰基本数据类型，无法通过getter去修改，并且不提供setter
     */
    static class ColorBox {
        private final int R;
        private final int G;
        private final int B;

        public ColorBox(int r, int g, int b) {
            R = r;
            G = g;
            B = b;
        }

        public int getR() {
            return R;
        }

        public int getG() {
            return G;
        }

        public int getB() {
            return B;
        }

    }
}
