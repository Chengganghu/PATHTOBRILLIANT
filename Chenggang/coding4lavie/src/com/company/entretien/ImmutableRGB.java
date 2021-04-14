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

    /**
     * 关于缓存的问题，我上网查了一下，可能一开始我就把两个概念混淆了，一个是缓存穿透和缓存击穿，上午讨论的是缓存穿透的问题，
     * 目前缓存穿透的解决方案其实网上已经很清楚了，一种是缓存空对象，其实和我说的缓存直接返回空类似，为了避免占用过多的key，
     * 可以为空对象加上过期时间。另外缓存与数据库不一致的问题，可以通过在数据库添加这个数据后，利用消息机制将空对象缓存清除。
     * 另外一种方式是布隆过滤器，简单理解就是bitmap维护一个缓存和数据库存在的key集合，通过多次hash降低hash冲突的概率。通过
     * 过滤器之后，证明存在这个key，再去访问。适用于命中率不高，数据相对固定的场景。
     *
     */
}
