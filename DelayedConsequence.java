
/**
 * Write a description of class DelayedConsequence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DelayedConsequence
{
    public static void main(String[] args)
    {
        System.out.println("DEBUG: main() - making a new controller.");
        Controller controller = new Controller();
        if(Setup.isRandomPres())
        {
            System.out.println("DEBUG: main() - show instruction sheet.");
            controller.showInstructionSheet();
        } else {
//             while(Setup.readProgramNotComplete())
//             {
//                 String line = Setup.readNextProgramLine();
//                 String[] lineArray = line.split(",");
//                 
//                 if(lineArray[0] == "BASELINE_DVRC") { controller.showBaseline(Model.DVRC_ENUM, Integer.parseInt(lineArray[1]), Intger.parseInt(lineArray[2]));
//                 if(lineArray[0] == "BASELINE_DVR") { controller.showBaseline(Model.DVR_ENUM, Integer.parseInt(lineArray[1]), Intger.parseInt(lineArray[2])); }
//                 if(lineArray[0] == "BASELINE_DC") { controller.showBaseline(Model.DC_ENUM, Integer.parseInt(lineArray[1]), Intger.parseInt(lineArray[2])); }
//                 if(lineArray[0] == "BASELINE_IC") { controller.showBaseline(Model.IC_ENUM, Integer.parseInt(lineArray[1]), Intger.parseInt(lineArray[2])); }}
//                 if(lineArray[0] == "DVRC_SEQUENCE") { controller.beginDvrcSequence(); }
//                 if(lineArray[0] == "DVR_SEQUENCE") { controller.beginDvrSequence(); }
//                 if(lineArray[0] == "DC_SEQUENCE") { controller.beginDcSequence(); }
//                 if(lineArray[0] == "IC_SEQUENCE") { controller.beginIcSequence(); }
//             }
//             
//             controller.gameOver();
        }
        
    }
}
