public class JumpInstruction extends Instruction {
    public JumpInstruction(final InstructionType instructionType, final String operands) {
        super(instructionType, operands);
    }

    @Override
    public String getHexCode() throws Exception {
        int addrInt = Integer.parseInt(operands);
        String addr = Integer.toBinaryString(addrInt);

        if (addrInt < -32768 || addrInt > 32767) throw new Exception("Address offset is out of range.");

        if (addrInt < 0) {
            int length = addr.length();
            addr = addr.substring(length - 16, length);
        } else {
            addr = String.format("%16s", addr).replaceAll(" ", "0");
        }

        final String bin = String.format("%s%s", instructionType.getOpcode(), addr);

        return ConversionUtil.binaryToHexadecimal(bin);
    }
}
