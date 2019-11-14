package com.datangedu.cn.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ImgCodeUtil {
	private static int width = 90;
    private static int height = 20;
    private static int codeCount = 4;
    private static int xx = 15;
    private static int fontHeight = 18;
    private static  int codeY = 16;
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    public static Map<String,Object> generateCodeAndPic() {
        
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        
        Random random = new Random();
      
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

       
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
      
        gd.setFont(font);

       
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }

       
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

       
        for (int i = 0; i < codeCount; i++) {
            
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);

           
            randomCode.append(code);
        }
        Map<String,Object> map  =new HashMap<String,Object>();
       
        map.put("code", randomCode);
       
        map.put("codePic", buffImg);
        return map;
    }
    /*
    public static void main(String[] args) throws Exception {
        
        OutputStream out = new FileOutputStream("D://"+System.currentTimeMillis()+".jpg");
        Map<String,Object> map = ImgCodeUtil.generateCodeAndPic();
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
        System.out.println("验证码"+map.get("code"));
    }
    */
}
