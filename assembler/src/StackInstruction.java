public class StackInstruction extends Instruction {
    public StackInstruction(final InstructionType instructionType, final String operands) {
        super(instructionType, operands);
	System.out.println("Warning: Stack instructions are not supported.");
    }

    @Override
    public String getHexCode() throws Exception {
        final Register src = Register.valueOf(operands);
        final String bin = String.format("%s000000000000%s", instructionType.getOpcode(), src.getAddress());
        return ConversionUtil.binaryToHexadecimal(bin);
    }
}
