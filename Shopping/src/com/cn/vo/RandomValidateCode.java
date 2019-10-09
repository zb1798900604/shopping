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
	//���������֤��ľ�������
    private String randomStringAll = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int width = 80;    //�������
    private int height = 26;   //�����ĸ߶�
    private int lineSize = 40; //�������ߵ�����
    private int stringnum = 4; //����������
    private Random random = new Random();  //java�ṩ�����������

    //��ȡ����
    private Font getFont(){
        //Font : java.awt���¡�����1 : ʹ�����������  ����2 : �������ʽ��Font.CENTER_BASELINE�� ���л���  ����3 : �����С
        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
    }

    //��ȡ�����ɫ(r,g,b)[0-255]
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

    //���������֤��
    public void getRandomCode(HttpServletRequest request, HttpServletResponse response){
        //��ȡSession�Ự����
        HttpSession session = request.getSession();
        //BufferedImage.TYPE_INT_BGR : ��ʾһ������8λRGB��ɫͼƬ
        //��Ӧ��Windows����BGR��ɫģ�ͣ�����3���ֽڴ洢��Blue��Green����red������ɫ
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //��ȡͼƬ����
        //Graphics : ���ƽӿ�(������ͼ�Ρ��ı���ͼƬ)
        Graphics graphics = image.getGraphics();
        //fillRect : �Ծ�����仭������
        graphics.fillRect(0,0,width,height);
        graphics.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
        graphics.setColor(getRandomColor(110,133));

        //ѭ��������������
        for(int i=0;i<=lineSize;i++) {
            //drowLine : �򻭲��л�������
            drowLine(graphics);
        }

        //���������֤��
        String randomString = "";
        for(int i=1;i<=stringnum;i++){ //ѭ�����ɼ���
            randomString=drowString(graphics,randomString,i);
        }
        session.removeAttribute("randomCode");
        session.setAttribute("randomCode",randomString);
        graphics.dispose(); //dispose : ������Դ
        try {
            //ͨ��response��ͼƬ��Դ��Ӧ���ͻ�ҳ��
            //ImageIO : ͼ��IO��
            //response.getOutputStream() : ��ȡ�������Ӧ�����е����������ͼƬ����Ӧ�Կͻ���ҳ��
            ImageIO.write(image,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //����ֱ��
    private void drowLine(Graphics g){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
    }
    //
    private String drowString(Graphics g,String randomString,int i){
        //���û����е�����
        g.setFont(getFont());
        //���û����е���ɫ
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
        //��ȡ��������ַ�
        String rand = String.valueOf(getRandomString(random.nextInt(randomStringAll.length())));
        //��ȡ����ַ�������
        randomString +=rand;
        //ת������ϵԭ��
        g.translate(random.nextInt(3), random.nextInt(3));
        //�򻭲��л����ַ�
        g.drawString(rand, 13*i, 16);
        return randomString;
    }

    //String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //��ȡrandomString�ַ�����num���������ַ�
    public String getRandomString(int num){
        return String.valueOf(randomStringAll.charAt(num));
    }
	
	
	
	
	
	
	
	
	
	
	
}
