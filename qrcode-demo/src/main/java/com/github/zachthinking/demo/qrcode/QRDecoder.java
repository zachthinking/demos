package com.github.zachthinking.demo.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class QRDecoder {

    public static void main(String[] args) throws IOException, NotFoundException, URISyntaxException {
        // 读取二维码图片
        File file = new File(QRDecoder.class.getResource("/qr.png").toURI());
        BufferedImage image = ImageIO.read(file);

        // 转换为ZXing能够解析的类型
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        // 尝试解析二维码
        Result result = new MultiFormatReader().decode(bitmap);
        System.out.println("解析结果： " + result.getText());
    }
}
