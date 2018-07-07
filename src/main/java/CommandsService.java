import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsService {

    public static void input(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        FileIO fileIO = new FileIO();;
        while(!line.equals("exit")){
            try {
                System.out.println("Personal expenses management console application");
                line = reader.readLine();
                switch (line.substring(0, line.indexOf(' '))){
                    case "exit":
                        break;

                    case "add":

                        break;

                    case "list":

                        break;

                    case "clear":
                        break;

                        case "total":
                            break;

                            default:
                                System.out.println("No such command, try again");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        input();
    }
}
