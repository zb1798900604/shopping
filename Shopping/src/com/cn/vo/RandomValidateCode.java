package com.cn.vo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {
	//设置随机验证码的具体内容
    private String randomStringAll = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int width = 80;    //画布宽度
    private int height = 26;   //画布的高度
    private int lineSize = 40; //画布中线的总数
    private int stringnum = 4; //随机码的数量
    private Random random = new Random();  //java提供的随机数的类

    //获取字体
    private Font getFont(){
        //Font : java.awt包下。参数1 : 使用字体的名称  参数2 : 字体的样式（Font.CENTER_BASELINE） 居中基线  参数3 : 字体大小
        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
    }

    //获取随机颜色(r,g,b)[0-255]
    private Color getRandomColor(int f_color,int b_color){
        if(f_color>255)
            f_color = 255;
        if(b_color>255)
            b_color = 255;

        int r = f_color + random.nextInt(b_color-f_color-16);
        int g = f_color + random.nextInt(b_color-f_color-17);
        int b = f_color + random.nextInt(b_color-f_color-18);

        return new Color(r,g,b); //  RGB(r,g,b,a)
    }

    //处理随机验证码
    public void getRandomCode(HttpServletRequest request, HttpServletResponse response){
        //获取Session会话对象
        HttpSession session = request.getSession();
        //BufferedImage.TYPE_INT_BGR : 表示一个具有8位RGB颜色图片
        //对应于Windows风格的BGR颜色模型，具有3个字节存储的Blue、Green、和red三种颜色
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //获取图片画布
        //Graphics : 绘制接口(线条、图形、文本、图片)
        Graphics graphics = image.getGraphics();
        //fillRect : 以矩形填充画布区域
        graphics.fillRect(0,0,width,height);
        graphics.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
        graphics.setColor(getRandomColor(110,133));

        //循环线条的总数据
        for(int i=0;i<=lineSize;i++) {
            //drowLine : 向画布中绘制线条
            drowLine(graphics);
        }

        //随机生成验证码
        String randomString = "";
        for(int i=1;i<=stringnum;i++){ //循环生成几个
            randomString=drowString(graphics,randomString,i);
        }
        session.removeAttribute("randomCode");
        session.setAttribute("randomCode",randomString);
        graphics.dispose(); //dispose : 消毁资源
        try {
            //通过response将图片资源响应给客户页面
            //ImageIO : 图象IO流
            //response.getOutputStream() : 获取服务端响应对象中的输出流，将图片流响应对客户端页面
            ImageIO.write(image,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //绘制直线
    private void drowLine(Graphics g){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
    }
    //
    private String drowString(Graphics g,String randomString,int i){
        //设置画布中的字体
        g.setFont(getFont());
        //设置画布中的颜色
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
        //获取单个随机字符
        String rand = String.valueOf(getRandomString(random.nextInt(randomStringAll.length())));
        //获取随机字符并连接
        randomString +=rand;
        //转换坐标系原点
        g.translate(random.nextInt(3), random.nextInt(3));
        //向画布中绘制字符
        g.drawString(rand, 13*i, 16);
        return randomString;
    }

    //String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //获取randomString字符串中num索引处的字符
    public String getRandomString(int num){
        return String.valueOf(randomStringAll.charAt(num));
    }
	
	
	
	
	
	
	
	
	
	
	
}
