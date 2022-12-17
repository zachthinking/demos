package com.github.zachthinking.demo.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void main(String[] args) throws IOException, WriterException {
        String text = "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:a\n" +
                "ORG:b\n" +
                "TITLE:c\n" +
                "END:VCARD";

        generateQRCodeImage(text, 350, 350, "C:/tmp/qr.png");
    }

    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = new File(filePath).toPath();
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}