
import java.lang.*;
public class Sentence_Correction
{
        public static void main(String[] args)
        {
            int count=0,k=0;
            String str="rahul goes to school EVERYDAY";
            char[] arr=str.toCharArray();
            int Length=arr.length;
            arr[k]=Character.toUpperCase(arr[0]);
            System.out.println(str);
            for(int i=1+count;i<Length;i++)
            {
                k++;
                count=0;
                if(arr[i]==' ')
                {
                    arr[k]=' ';
                    arr[++k]=Character.toUpperCase(arr[++i]);
                    count++;
                }
                else
                {
                    arr[k]=Character.toLowerCase(arr[i]);
                }
            }
            for(char i:arr)
            {
                System.out.print(i);
            }
        }
    }

