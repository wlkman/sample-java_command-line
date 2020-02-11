//import org.apache.commons.cli.*;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;


public class CommandLineParameters {

    public static void main(String[] args) throws ParseException{
//        CommandLineParser parser = new DefaultParser();
//        Options options = new Options();
//
//        options.addOption("a", "abc", true, "First Parameter");
//        options.addOption("x", "xyz", true, "Second Parameter");
//        options.addOption("h", "help", false, "Shows this Help");
//
//        try {
//            CommandLine commandLine = parser.parse(options, args);
//
//            System.out.println(commandLine.getOptionValue("a"));
//            System.out.println(commandLine.getOptionValue("x"));
//
//            if (commandLine.hasOption("h")) {
//                HelpFormatter formatter = new HelpFormatter();
//                formatter.printHelp("CommandLineParameters", options);
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }






//        // create the command line parser
//        CommandLineParser parser = new DefaultParser();
//
//        // create the Options
//        Options options = new Options();
//        options.addOption( "a", "all", false, "do not hide entries starting with ." );
//        options.addOption( "A", "almost-all", false, "do not list implied . and .." );
//        options.addOption( "b", "escape", false, "print octal escapes for nongraphic "
//                + "characters" );
//        options.addOption(OptionBuilder.withLongOpt( "block-size" )
//                .withDescription( "use SIZE-byte blocks" )
//                .hasArg()
//                .withArgName("SIZE")
//                .create() );
//        options.addOption( "B", "ignore-backups", false, "do not list implied entried "
//                + "ending with ~");
//        options.addOption( "c", false, "with -lt: sort by, and show, ctime (time of last "
//                + "modification of file status information) with "
//                + "-l:show ctime and sort by name otherwise: sort "
//                + "by ctime" );
//        options.addOption( "C", false, "list entries by columns" );
//
//        String[] args1 = new String[]{ "--block-size=10" };
//
//        try {
//            // parse the command line arguments
//            CommandLine line = parser.parse( options, args1 );
//
//            // validate that block-size has been set
//            if( line.hasOption( "block-size" ) ) {
//                // print the value of block-size
//                System.out.println( line.getOptionValue( "block-size" ) );
//            }
//        }
//        catch( ParseException exp ) {
//            System.out.println( "Unexpected exception:" + exp.getMessage() );
//        }




        Options options = new Options();
        //短选项，长选项，选项后是否有参数，描述
        Option option = new Option("n", "name", true, "the name of this agent");
        option.setRequired(true);//必须设置
        options.addOption(option);

        option = new Option("f", "conf-file", true,
                "specify a config file (required if -z missing)");
        option.setRequired(false);
        options.addOption(option);

        option = new Option("h", "help", false, "display help text");
        options.addOption(option);

        //CommandLineParser parser = new PosixParser();//Posix风格
        CommandLineParser parser = new GnuParser();//gun风格
        CommandLine commandLine = parser.parse(options, args);

        //判断
        if (commandLine.hasOption('h')) {
            //格式化输出
            new HelpFormatter().printHelp("flume-ng agent", options, true);
            return;
        }
        if (commandLine.hasOption('f')) {
            //获取参数
            String file = commandLine.getOptionValue('f');
        }





    }
}