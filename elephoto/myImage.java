import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class myImage extends JPanel{
    BufferedImage imagebg ;
    public static void main(String agrs[]){
        JFrame frame = new JFrame();
        frame.setSize(1000,700);
        frame.setTitle("电子相册");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //JPanel jPanel = new JPanel();
        myImage myImage = new myImage();
        frame.add(myImage);
        myImage.initimages();
        //frame.add(jPanel);
        //myImage.repaint();
        myImage.begin();
        frame.setVisible(true);
    }
    int num = 0;
    private void begin() {
        new Thread(new Runnable() {
            @Override
            public void run() {


                while (true){

                    imagebg = images[num];
                    num++;
                    if(num==4){
                        num=0;
                    }
                    while (true){
                        if(ff<100f){
                            ff+=2f;
                            repaint();
                        }else{
                            ff=0f;
                            break;
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }

    float ff=20f;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if(imagebg != null){
            graphics2D.setComposite(AlphaComposite.SrcOver.derive(ff/100f));
            g.drawImage(imagebg,0,0,1000,700,null);
        }
    }

    BufferedImage [] images = new BufferedImage[4];
    public void initimages()
    {
        for (int i = 1; i <=4 ; i++) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(myImage.class.getResource("/images/"+i+".jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            images[i-1]=image;
        }
        imagebg = images[0];
    }
}
