import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class imageCode {

    static String[] strs={"a","b","c","d","e","f","g","h","i","j","k"};

    public static void main(String[] args) throws IOException {
        int w = 150;
        int h = 50;
        int imageType = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(w,h,imageType);
        Graphics g = image.getGraphics();
        g.setColor(Color.yellow);
        g.fillRect(0,0,w,h);


        Random random=new Random();
        g.setColor(Color.red);
        g.setFont(new Font("楷体",Font.PLAIN,25));
        int x=30;
        int y=30;
        for (int i = 0; i <4 ; i++) {
            int num=random.nextInt(strs.length);
            String str = strs[num];
            g.drawString(str,x,y);
            x  =  x+25;
        }

        g.setColor(Color.green);
        for (int i = 0; i <10 ; i++) {

            int x1 = random.nextInt(30);
            int y1 = random.nextInt(50);
            int x2 = random.nextInt(30)+120;
            int y2 = random.nextInt(50);


            g.drawLine(x1,y1,x2,y2);
        }



        ImageIO.write(image,"jpg",new File("E:\\javabasicpra\\checkcode\\a.jpg"));
    }
}
