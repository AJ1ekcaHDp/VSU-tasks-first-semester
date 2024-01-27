package task10;

import task10.util.ArrayUtils;
import task10.util.JTableUtils;
import task10.util.SwingUtils;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;


public class Program {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--help":
                    params.help = true;
                    return params;
                case "--window":
                    params.window = true;
                    return params;
                case "-i":
                case "--input-file=":
                    if (i + 1 < args.length) {
                        params.inputFile = args[i + 1];
                        i++;
                    } else {
                        params.help = true;
                        params.error = true;
                        return params;
                    }
                    break;
                case "-o":
                case "–-output-file=":
                    if (i + 1 < args.length) {
                        params.outputFile = args[i + 1];
                        i++;
                    } else {
                        params.help = true;
                        params.error = true;
                        return params;
                    }
                    break;
                default:
                    params.error = true;
                    params.help = true;
                    return params;
            }
        }
        if (params.inputFile == null) {
            params.help = true;
            params.error = true;
        }

        return params;
    }

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args (--input-file | -i) <input-file> (--output-file | -o) <output-file>");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            winMain();
        } else {
            int[][] arr2 = ArrayUtils.readIntArray2FromFile(params.inputFile);
            if (arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            } else {
                List<Segment> inputSegments = MyUtilit.convertIntArrayToSegmentList(arr2);
                Task.solution(inputSegments);
                arr2 = MyUtilit.convertSegmentListToIntArray(inputSegments);
            }
            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.println(arr2);
            out.close();
        }
    }
}
