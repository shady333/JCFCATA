import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Oleg_Dudar on 17-Jun-17.
 */
public class Creator {

    static String androidVersionDef = "6.0.1";
    static String androidVersion = androidVersionDef;
    static int hubPort = 6720;
    static String hubIp = "localhost";
    static String hostIp = "localhost";
    static int hostPort = 4444;

    public static void main(String[] args) throws IOException {

        int numberOfAndroidDevices = 2;
        String deviceUdid;
        List<JsonObject> jsonsToCreate = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Use dafault config? [Y] / [N]");
        if(scan.nextLine().equalsIgnoreCase("y")){
            System.out.println("Going to generate default config files");
            scan.close();
        }
        else {
            System.out.println("Number of Android devices?");
            numberOfAndroidDevices = Integer.parseInt(scan.nextLine());

            for(int i = 1; i <= numberOfAndroidDevices; i++) {
                androidVersion = androidVersionDef;

                System.out.println("DEVICE " + i + " Parameters!");

                System.out.println("Android version? (" + androidVersion + ")");
                String a = scan.nextLine();
                if(!a.isEmpty())
                    androidVersion=a;

                System.out.println("Android device udid?");
                deviceUdid = scan.nextLine();

                System.out.println("Hub address? (" + hubIp + ")");
                a = scan.nextLine();
                if(!a.isEmpty())
                    hubIp=a;

                System.out.println("Hub port? (" + ++hubPort + ")");
                a = scan.nextLine();
                if(!a.isEmpty())
                    hubPort=Integer.parseInt(a);

                System.out.println("Host address? (" + hostIp + ")");
                a = scan.nextLine();
                if(!a.isEmpty())
                    hostIp=a;

                System.out.println("Host port? (" + hostPort + ")");
                a = scan.nextLine();
                if(!a.isEmpty())
                    hostPort=Integer.parseInt(a);

                jsonsToCreate.add(createJson(androidVersion, deviceUdid, hostIp, hostPort, hubIp, hubPort));
            }
        }

        // config Map is created for pretty printing.
        Map<String, Boolean> config = new HashMap<>();
        // Pretty printing feature is added.
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        int i = 0;
        for(JsonObject obj : jsonsToCreate) {

            // PrintWriter and JsonWriter is being created
            // in try-with-resources
            try (PrintWriter pw = new PrintWriter("device" + ++i + ".json")
                 ; JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(pw)) {
                // Json object is being sent into file system
                jsonWriter.writeObject(obj);
            }
        }
    }

//    public static JsonObject createJson(){
//        return createJson(androidVersion, "UNIQUE_DEVICE_UDID");
//    }

    public static JsonObject createJson(String version, String udid, String hostIp, int hostPort, String hubIp, int hubPort){
        String browserName = "Android";
        String seleniumProtocol = "WebDriver";
        String platform = "ANDROID";
        int maxInstances = 1;

        JsonArray capabilities = Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("browserName", browserName)
                        .add("varsion", version)
                        .add("seleniumProtocol", seleniumProtocol)
                        .add("platform", platform)
                        .add("maxInstances", maxInstances)
                        .add("udid", udid))
                .build();

        int cleanUpCycle = 2000;
        int timeout = 180000;
        String proxy = "org.openqa.grid.selenium.proxy.DefaultRemoteProxy";
        String url = "http://" + hostIp + ":" + hostPort + "/wd/hub";
//        String host = "10.25.14.116";
//        int port = 6723;
        int maxSession = 1;
        boolean register = true;
        int registerCycle = 5000;
//        int hubPort = 4444;
//        String hubHost = "10.25.14.116";

        JsonObject configuration = Json.createObjectBuilder()
                .add("cleanUpCycle", cleanUpCycle)
                .add("timeout", timeout)
                .add("proxy", proxy)
                .add("url", url)
                .add("host", hostIp)
                .add("port", hostPort)
                .add("maxSession", maxSession)
                .add("register", register)
                .add("registerCycle", registerCycle)
                .add("hubPort", hubPort)
                .add("hubHost", hubIp)
                .build();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("capabilities", capabilities)
                .add("configuration", configuration)
                .build();

        return jsonObject;
    }
}
