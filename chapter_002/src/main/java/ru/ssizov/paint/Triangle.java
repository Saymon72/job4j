package ru.ssizov.paint;

/**
 * @author Semen Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +    ");
        pic.append("  +++++  ");
        pic.append("+++++++++");
        pic.append("++++++++++");
        return pic.toString();
    }
}