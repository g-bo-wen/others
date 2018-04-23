package base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class mi {
    public static void main(String[] args) throws Exception{
        // 52617221 rar
        // 504B0304 zip
        // 00000020 MP4

        


        File f = new File("/Users/fdt/Profile/zip/05.zip");
//        SeekableByteChannel channel = Files.newByteChannel(f.toPath());
//        ByteBuffer byteBuffer = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
//        byteBuffer.rewind();
//        org.apache.commons.io.IOUtils.readFully(channel, byteBuffer);
//        byteBuffer.flip();
//        byte[] bu = new byte[6];
//        byteBuffer.get(bu);
//        byte[] sign = new byte[]{(byte)'7', (byte)'z', (byte)0xBC, (byte)0xAF, (byte)0x27, (byte)0x1C};
//
//        //[82, 97, 114, 33, 26, 7]  dwg
//        System.out.println(Arrays.toString(bu));
//        System.out.println(Arrays.toString(sign));
        String fileHeader = GetTypeByHead.getFileHeader(f.getPath());
        System.out.println(fileHeader);

    }
}
