/**Name: Ahsan Ali Shah
 S_ID: 023-20-0049
 S_Name: Syed
 Date: 21-20-0049
 Course: Data Structures
 Description: This file contains 5 methods: 1st one extracts all the words from, 2nd one extracts email addresses from file, 3rd one extracts boundaries of 4 dimendional Array, 4th one extracts center of 4 dimensional array and last checks if array conatains 4 consecutive values
 */
package LAB1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class NLArray{
    public static void main(String[] args) {

        wordTokenize("myFile.txt");
        extractEmail("myFile.txt");

        int arr[][] = {{0,1,2,3},{2,2,2,2},{1,2,3,4},{7,7,7,9}};
        System.out.println("\n"+"Boundaries of Given Array");
        extractBoundaries (arr);
        System.out.print("\n"+"Center of Given Array");
        cropCenterPart (arr);
        System.out.println("\n"+NConRep(arr));

    }
    //Method returning array having words from file.
    public static String [] wordTokenize (String fileName){
        // Reading from a file
        try
        {
            int index=0;
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNext())
            {
                String data = reader.next();
                index++;
            }
            String array[] = new String[index];
            index=0;
            File file1 = new File(fileName);
            Scanner read = new Scanner(file1);
            while (read.hasNext())
            {
                String data = read.next();
                int len = data.length()-1;
                if(data.charAt(len)<=65 && data.charAt(len)<=90 || data.charAt(len)>=97 && data.charAt(len)<=122){
                    data = data.substring(0,len);
                    if(data.length()>0)
                        array[index++] = data;
                }
                else{
                    if(data.length()>0)
                        array[index++] = data;
                }
            }
            index--;
            System.out.println("Special Characters Removed");
            return array;
        }
        catch(IOException e) {
            System.out.println("--------------fileNotFound--------------");
        }
        return null;
    }
    public static String[] extractEmail (String fileName){
        // Reading from a file
        try
        {
            int index=0;
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNext())
            {
                String data = reader.next();
                int len = data.length();
                for(int i =0; i<len; i++){
                    if(data.charAt(i)=='@' && (data.charAt(0)>=65 && data.charAt(0)<=90 || data.charAt(0)>=97 && data.charAt(0)<=122)){
                        index++;
                    }
                }
            }
            String array[] = new String[index];
            index=0;
            File file1 = new File(fileName);
            Scanner read = new Scanner(file1);
            while (read.hasNext())
            {
                String data = read.next();
                int len = data.length();
                for(int i =0; i<len; i++){
                    if(data.charAt(i)=='@' && (data.charAt(0)>=65 && data.charAt(0)<=90 || data.charAt(0)>=97 && data.charAt(0)<=122)){
                        System.out.println("Email: "+data);
                        array[index++] = data;
                    }
                }
            }
            return array;
        }
        catch(IOException e) {
            System.out.println("--------------fileNotFound--------------");
        }
        return null;
    }
    public static void extractBoundaries (int arr[][]){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i==0){
                    System.out.print(arr[i][j]+"  ");
                }
                else if(j==0){
                    System.out.print(arr[i][j]+"  ");
                }
                else if(i==3){
                    System.out.print(arr[i][j]+"  ");
                }
                else if(j==3){
                    System.out.print("        "+arr[i][j]+"  ");
                }
            }
            System.out.println();
        }
    }
    public static void cropCenterPart (int arr[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i!=0 && j!=3 && j!=0 && i!=3){
                    System.out.print(arr[i][j]+"  ");
                }
            }
            System.out.println();
        }
    }
    public static boolean NConRep (int arr[][]){
        boolean check = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(arr[i][i]==arr[i][j]){
                    check = true;
                }
                else{
                    check = false;
                    break;
                }
            }
            if(check==true) break;
        }
        return check;
    }

}