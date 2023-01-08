public class BranchInstruction extends Instruction {
    public BranchInstruction(final InstructionType instructionType, final String operands) {
        super(instructionType, operands);
    }

    @Override
    public String getHexCode() throws Exception {
        final String[] ops = operands.split(",");
        final Register reg1 = Register.valueOf(ops[0]);
        final Register reg2 = Register.valueOf(ops[1]);

        int addrInt = Integer.parseInt(ops[2]);
        String addr = Integer.toBinaryString(addrInt);

        if (addrInt < -128 || addrInt > 127) throw new Exception("Address offset is out of range.");

        if (addrInt < 0) {
            int length = addr.length();
            addr = addr.substring(length - 8, length);
        } else {
            addr = String.format("%8s", addr).replaceAll(" ", "0");
        }

        final String bin = String.format("%s%s%s%s",
                instructionType.getOpcode(),
                reg1.getAddress(),
                reg2.getAddress(),
                addr
        );

        return ConversionUtil.binaryToHexadecimal(bin);
    }
}
