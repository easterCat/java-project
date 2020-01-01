import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Li {
    public static void main(String[] args) throws IOException {
        // 三个测试方法
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
        test07();
    }

    public static void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符为" + c);
    }

    public static void test02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符，按 q 键结束");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("你输入的字符为" + c);
        } while (c != 'q');
    }

    public static void test03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("请输入一行字符");
        System.out.println("输入end退出");
        do {
            str = bufferedReader.readLine();
            System.out.println("输入的是=>" + str);
        } while (!str.equals("end"));
        System.out.println("你输入的字符为" + str);
    }

    public static void test04() {
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
    }

    public static void test05() throws IOException {
        try {
            byte bWrite[] = {11, 21, 3, 40, 5};
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    public static void test06() throws IOException {
        File f = new File("test.txt");
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append("中文输入");
        writer.append("\r\n");
        writer.append("english");
        writer.close();
        fop.close();
        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        StringBuffer sb = new StringBuffer();

        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();
    }

    public static void test07() {
        try {
            String dirname = "./bin";
            File d = new File(dirname);
            d.mkdirs();

            File f = new File("./bin/111.txt");
            FileOutputStream fop = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            writer.append("中文输入");
            writer.append("\r\n");
            writer.append("english");
            writer.close();
            fop.close();

            File f2 = new File("./bin/222.txt");
            FileOutputStream fop2 = new FileOutputStream(f2);
            OutputStreamWriter writer2 = new OutputStreamWriter(fop2, "UTF-8");
            writer2.append("中文输入");
            writer2.append("\r\n");
            writer2.append("english");
            writer2.close();
            fop2.close();

            String dirname2 = "./bin/test";
            File d2 = new File(dirname2);
            d2.mkdirs();

            if (d.isDirectory()) {
                System.out.println("目录 " + dirname);

                String s[] = d.list();
                int length = s.length;
                for (int i = 0; i < length; i++) {
                    File f3 = new File(dirname + "/" + s[i]);
                    if (f3.isDirectory()) {
                        System.out.println(s[i] + " 是一个目录");
                    } else {
                        System.out.println(s[i] + " 是一个文件");
                    }
                }
            } else {
                System.out.println(dirname + " 不是一个目录");
            }
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}