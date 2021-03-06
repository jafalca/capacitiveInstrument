import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;


/**
 * @author: Javier Falca, Shanelle Ileto
 * The following code is to interface the Arduino output with Java
 * The class is sample code retrieved from
 * @link http://playground.arduino.cc/interfacing/java
 * solely to interface the Metro M0 output with Java
 * @note no credit is taken for this code portion
 */
public class SerialTest implements SerialPortEventListener {
    SerialPort serialPort;
    /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
            "/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyACM0", // Raspberry Pi
            "/dev/ttyUSB0", // Linux
            "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    public void initialize() {
        // the next line is for Raspberry Pi and
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        //System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */

    static boolean auto = false;
    static autoSong as = new autoSong();
    static String[] autoNotes = as.megalovania();
    static int noteCount = 0;

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                //This code here was implemented by us for Project 3 to handle the logic for autoplay
                if ((auto == true) && (inputLine != "")) {
                    sound.playSound(autoNotes[noteCount]);

                    if (noteCount != 12) {
                        noteCount++;
                    }

                    if (noteCount == 12) {
                        noteCount = 0;
                        auto = false;
                    }

                }

                if (auto == false ) { playSound(inputLine); }
                //System.out.println(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public static void main(String[] args) throws Exception {
        SerialTest main = new SerialTest();
        main.initialize();
        Thread t=new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Started");
    }


    /**Starting here is code entirely implemented by us, the Synth object is instance of another class we wrote
     * Using switch cases we play different notes depending what the output of the metro is
     */

    static Synth sound = new Synth();
    static int counter = 0;
    static String[] notes = sound.getPianoNotes();

    public static void playSound(String pin){


        switch (pin){
            case "0 touched":
                sound.playSound(notes[0]);
                System.out.println("0");
                break;
            case "1 touched":
                sound.playSound(notes[1]);
                System.out.println("1");
                break;
            case "2 touched":
                sound.playSound(notes[2]);
                System.out.println("2");
                break;
            case "3 touched":
                sound.playSound(notes[3]);
                System.out.println("3");
                break;
            case "4 touched":
                sound.playSound(notes[4]);
                System.out.println("4");
                break;
            case "5 touched":
                sound.playSound(notes[5]);
                System.out.println("5");
                break;
            case "6 touched":
                sound.playSound(notes[6]);
                System.out.println("6");
                break;
            case "7 touched":
                sound.playSound(notes[7]);
                System.out.println("7");
                break;
            case "8 touched":
                sound.playSound(notes[8]);
                System.out.println("8");
                break;
            case "9 touched":
                sound.playSound(notes[9]);
                System.out.println("9");
                break;
            case "10 touched":
                auto = true;
                System.out.println("10");
                break;
            case "11 touched":
                counter += 1;
                if (counter == 1) {
                    notes = sound.getPianoNotes();
                    System.out.println("11");
                }

                if (counter == 2) {
                    notes = sound.getDrumNotes();
                    System.out.println("11");
                }

                if (counter == 3) {
                    notes = sound.getSeven();
                    System.out.println("11");
                }

                if (counter == 4) {
                    notes = sound.daftPunk1();
                    System.out.println("11");
                }

                if (counter == 5) {
                    notes = sound.daftPunk2();
                    System.out.println("11");
                    counter = 0;
                }
                break;
        }

    }

}
