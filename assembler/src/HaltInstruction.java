public class HaltInstruction extends Instruction {

    public HaltInstruction(final InstructionType instructionType, final String operandsPart) {
        super(instructionType, operandsPart);
    }

    @Override
    public String getHexCode() throws Exception {
	if (operands != null) throw new Exception("HALT instruction takes no operands.");
        final String bin = String.format("%s0000000000000000", instructionType.getOpcode());
        return ConversionUtil.binaryToHexadecimal(bin);
    }
}
