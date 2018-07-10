package com.shl.onetest.vcode;

import com.shl.onetest.util.RandomUtil;

import java.awt.*;
import java.io.OutputStream;

/**
 * @author songhongli
 **/
public abstract class Captcha {
    // 字体
    protected Font font = new Font("Verdana", Font.ITALIC | Font.BOLD, 28);
    protected int len = 5;
    protected int width = 150;
    protected int height = 40;
    protected String chars = null;

    protected char[] alphas() {
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            cs[i] = RandomUtil.alpha();
        }
        return cs;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    protected Color color(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }

        if (bc > 255) {
            fc = 255;
        }

        int r = fc + RandomUtil.num(bc - fc);
        int g = fc + RandomUtil.num(bc - fc);
        int b = fc + RandomUtil.num(bc - fc);
        return new Color(r, g, b);
    }

    public String text() {
        return chars;
    }

    public abstract void out(OutputStream os);


}
