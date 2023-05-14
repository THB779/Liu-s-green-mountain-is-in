package homework.xiangmu4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AccountBook1 {
    private static final String FILE_PATH = "accountbook.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date;
        String content;
        double amount;
        char choice;

        do {
            // Prompt user for input
            System.out.print("输入日期（YYYY-MM-DD）：");
            date = scanner.nextLine();
            System.out.print("输入备注： ");
            content = scanner.nextLine();
            System.out.print("输入金额（收入为正数，费用为负数）");
            amount = scanner.nextDouble();
            scanner.nextLine();
            // consume newline character

            // 读写数据
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
                writer.write(date + "\t" + content + "\t" + amount + "\n");
                writer.close();
                System.out.println("数据已添加到账簿中。");
            } catch (IOException e) {
                System.out.println("写入文件时出错。");
            }

            // Prompt user to continue or exit
            System.out.print("是否继续录入（Y/N） ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'Y'||choice == 'y');

        // Print out all the data in the account book
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line = "";
            System.out.println("=== 记账本===\"");
            System.out.println("日期\t备注\t金额");
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");
                System.out.println(fields[0] + "\t" + fields[1] + "\t" + fields[2]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("读取文件时出错。");
        }

        scanner.close();
    }
}