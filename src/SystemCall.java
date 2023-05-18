import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemCall {
    static Parser parser=Parser.getInstance();
    static Memory memory=Memory.getInstance();

    public SystemCall() {}
    public void print(PCB pcb,String needed){
        System.out.println(parser.memoryInstance.read(pcb,needed));
    }
    public static void assign(String x, String y, PCB pcb) {
        String result=x+" = "+y;

        if (parser.memory[0].equals(pcb.getpId()+"")) {
            assignHelper(result,10,13);
//            for (int i=10;i<13;i++) {
//                if (parser.memory[i]==null||parser.memory[i].equals("")) {
//                    parser.memory[i]=result;
//                    System.out.println(result);
//                    break;
//                }
//            }
        }
        else if (parser.memory[5].equals(pcb.getpId()+"")) {
            assignHelper(result,25,28);
//            for (int i=25;i<28;i++) {
//                if (parser.memory[i]==null||parser.memory[i].equals("")) {
//                    parser.memory[i]=result;
//                    break;
//                }
//            }
        }
    }
    private static void assignHelper(String result, int start, int end){
        for (int i=start;i<end;i++) {
            if (parser.memory[i]==null||parser.memory[i].equals("")) {
                parser.memory[i]=result;
                return;
//                break;
            }
        }
    }
    public static void writeFile(String fileName, String data) throws IOException {
        File file=new File(fileName);
        if(file.createNewFile()){
        	System.out.println("File created: " + file.getName());
         }
        else {
             System.out.println("File already exists.");
        }
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(data);
        fileWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
    public static void readFile(String fileName) throws FileNotFoundException {
        File needed = new File("src/"+fileName);
        Scanner myReader = new Scanner(needed);
        parser.readFile=myReader.next();
        myReader.close();

    }
    public static void printFromTo(String a, String b, PCB pcb) {
        int start,end;
        start = Integer.parseInt(memory.read(pcb, a));
        end = Integer.parseInt(memory.read(pcb, b));
        for (int i = ++start; i < end; i++) {
            System.out.println(i);
        }
    }
}
