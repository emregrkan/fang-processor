public class MemoryInstruction extends Instruction {

    public MemoryInstruction(final InstructionType instructionType, final String operandsPart) {
        super(instructionType, operandsPart);
    }

    @Override
    public String getHexCode() throws Exception {
        final String[] ops = operands.split(",");
        final Register reg = Register.valueOf(ops[0]);

        int addrInt = Integer.parseInt(ops[1]);
        String addr = Integer.toBinaryString(addrInt);

        if (addrInt < -2048 || addrInt > 2047) throw new Exception("Address offset is out of range.");

        if (addrInt < 0) {
            int length = addr.length();
            addr = addr.substring(length - 12, length);
        } else {
            addr = String.format("%12s", addr).replaceAll(" ", "0");
        }

        final String bin = String.format("%s%s%s",
                instructionType.getOpcode(),
                reg.getAddress(),
                addr
        );

	return ConversionUtil.binaryToHexadecimal(bin);
    }
}
