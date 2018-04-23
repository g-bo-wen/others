package base;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.*;
import java.util.*;


// zip is 504b0304  rar is 52617221  7z 377abcaf
public class Unzip {
    public static void main(String[] args) throws Exception {
//unZip(new File("/Volumes/Untitled/01kz.zip"), "/Users/fdt/software", "st109");
        File file = new File("/Volumes/Seagate Backup Plus Drive/1069");
        Map<String, String> headers = new HashMap<>();
        Queue<File> dir = new ArrayDeque<>();
        dir.add(file);
        File di = null;
        while ((di = dir.poll()) != null) {
            File[] listFiles = di.listFiles();
            for (File listFile : listFiles) {
                if (listFile.isDirectory()) {
                    dir.add(listFile);
                } else {
                    String header = GetTypeByHead.getFileHeader(listFile.getPath());
//                    headers.put(header,listFile.getName());
                    if (header.equals("504B0304") || header.equals("3C68746D") || header.equals("3C21444F")) {
                        unZip(listFile, null, null);
                    }
                }
            }
        }

//        headers.forEach((k, v) -> System.out.println(k + "   ---    " + v));
    }

    public static void listFile(File file) {

    }

    /**
     * 解压加密的压缩文件
     *
     * @param zipfile // 压缩文件
     * @param dest    // 解压路径
     * @param passwd  // 密码
     * @throws ZipException
     */
    public static void unZip(File zipfile, String dest, String passwd) throws ZipException {
        ZipFile zfile = new ZipFile(zipfile);
        zfile.setFileNameCharset("GBK");//在GBK系统中需要设置
        if (!zfile.isValidZipFile()) {
            System.err.println(GetTypeByHead.getFileHeader(zipfile.getPath()) + "\t" + zipfile.getPath() + " is not zip file");
        }
       // System.out.println(zipfile.getName() + " is zip file");
//        File file = new File(dest);
//        if (file.isDirectory() && !file.exists()) {
//            file.mkdirs();
//        }
//        if (zfile.isEncrypted()) {
//            zfile.setPassword(passwd.toCharArray());
//        }

    }

    public static String bytesToHexString(File file) throws FileNotFoundException, IOException {
        byte[] src = new byte[4];
        FileInputStream in = new FileInputStream(file);
        in.read(src);
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * @param orgPath 源压缩文件地址
     * @param tarpath 解压后存放的目录地址
     * @author kxl
     */
    public static void apache7ZDecomp(String orgPath, String tarpath, String password) {

        try {
            SevenZFile sevenZFile = new SevenZFile(new File(orgPath), password.getBytes("UTF-16LE"));
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while (entry != null) {

                // System.out.println(entry.getName());
                if (entry.isDirectory()) {

                    new File(tarpath + entry.getName()).mkdirs();
                    entry = sevenZFile.getNextEntry();
                    continue;
                }
                FileOutputStream out = new FileOutputStream(tarpath
                        + File.separator + entry.getName());
                byte[] content = new byte[(int) entry.getSize()];
                sevenZFile.read(content, 0, content.length);
                out.write(content);
                out.close();
                entry = sevenZFile.getNextEntry();
            }
            sevenZFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(orgPath);
            e.printStackTrace();
        }
    }
}
