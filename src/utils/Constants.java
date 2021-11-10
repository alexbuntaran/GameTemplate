package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

    public static final String NAME = "Name";
    public static final Dimension FRAME_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int FRAME_WIDTH = (int) FRAME_SIZE.getWidth();
    public static final int FRAME_HEIGHT = (int) FRAME_SIZE.getHeight();
    public static final int NUMBER_OF_BUFFERS = 3;
    
}
