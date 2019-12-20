// 创建二维数组
// type[][] typeName = new type[typeLength1][typeLength2];
public class Person6 {
    public static void main(String[] args) {
        // 二维数组 a 可以看成一个两行三列的数组。
        String[][] s = new String[2][];
        s[0] = new String[3];
        s[1] = new String[3];
        s[0][0] = new String("good");
        s[0][1] = new String("luck");
        s[0][2] = new String("lulu");
        s[1][0] = new String("0");
        s[1][1] = new String("1");
        s[1][2] = new String("2");

        // 多维数组的引用 arrayName[index1][index2]
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(s[i][j]);
            }
        }
    }
}