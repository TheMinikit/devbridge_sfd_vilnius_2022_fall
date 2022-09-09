import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main
{
    private static ArrayList<Character> digit_list = new ArrayList<>()
    {
        {
            add('0');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }
    };
    public static void main(String args[])
    {
        String filename = "inputfile.txt";
        ArrayList<String> input_list = new ArrayList<>();
        try
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                input_list.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < input_list.size(); i++)
        {
            String digits = "";
            for (int i2 = 0; i2 < input_list.get(i).length(); i2++)
            {

                if (digit_check(input_list.get(i).charAt(i2)))
                {
                    digits += input_list.get(i).charAt(i2);
                }
                else
                {
                    if (digits.length() > 0 && Integer.parseInt(digits) >= 10)
                    {
                        System.out.println(input_list.get(i));
                    }
                    digits = "";
                }
                if (digits.length() > 0 && i2 + 1 == input_list.get(i).length() && Integer.parseInt(digits) >= 10)
                {
                    System.out.println(input_list.get(i));
                }
            }
        }

    }

    private static boolean digit_check(char digit)
    {
        return digit_list.contains(digit);
    }
}
