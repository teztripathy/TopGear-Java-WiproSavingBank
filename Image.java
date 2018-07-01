import java.io.*;
import java.util.*;
import java.time.*;

public class Image {
    public static void logo() {
        System.out.println(" `.`     `.`      ..  .`                                     \n oMy     hMN.    :Mm `Ny                                     \n `NM.   :MyMy    hM/          ...     ..  .`    ...          \n  oMs   dN`yM-  -Mm  `Mh  sMsmhydNy`  dmomd/ .yNhyhNd:       \n  `NN` /M+ .Nd  yM/  `Mh  sMy`   -Nm  dM+   `Nm.   `hM-      \n   +Mo`mm   oM/.Md   `Mh  sM-     yM- dN`   /Mo     :Ms      \n   `mNsM:   `mmsM/   `Mh  sM/     dM. dN    -My     +Mo      \n    +MMh     /MMd    `Mh  sMNo-.:hM+  dN     oMy:.-oNh`      \n     ++.      ++-     +:  sM`/sys+    :/      .+syyo-        \n                          sM.                                \n                          +y.                                \n");
    }
    public static void menu() {
        System.out.println("         WELCOME TO WIPRO SAVING BANK\n									By: Tejeswar Tripathy\n>> help 	- To see the command instuctions.");
    }
    public static void help() {
        String fileName = "help.txt";
        String line = null;
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "UNABLE TO FIND FILE '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "UNABLE TO OPEN THE FILE '" 
                + fileName + "'");                  
        }
    }
}