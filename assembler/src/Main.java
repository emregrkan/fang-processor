import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        int lineNo = 1;
	boolean isSuccess = true;

        try (
            final BufferedReader br = new BufferedReader(new FileReader(args[0]));
            final BufferedWriter bw = new BufferedWriter(new FileWriter("a.hex"))
        ) {
            bw.append("v2.0 raw\r\n");

            String line;
            while ((line = br.readLine()) != null) {

		if (line.trim().equals("")) {
		    continue;
		}

                final String[] split = line.split(" ");

                final InstructionType type = InstructionType.valueOf(split[0]);
                final String operands = split.length == 2 ? split[1] : null;

                final Instruction instruction = switch (type) {
		    case HALT -> new HaltInstruction(type, operands);
                    case ADD, SUB, AND, OR, XOR, ADDI, SUBI, ANDI, ORI, XORI -> new ALUInstruction(type, operands);
                    case LD, ST -> new MemoryInstruction(type, operands);
                    case JUMP -> new JumpInstruction(type, operands);
                    case PUSH, POP -> new StackInstruction(type, operands);
                    case BE, BNE -> new BranchInstruction(type, operands);
                };

                bw.append(instruction.getHexCode());
                bw.append("\r\n");
                lineNo++;
            }
        } catch (Exception e) {
	    isSuccess = false;
            System.out.println("Exception at " + args[0] + " line " + lineNo + ":");
            e.printStackTrace();
        } 

	if (isSuccess) {
	    System.out.println("Done.");
	}
    }
}
