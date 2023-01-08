public class ALUInstruction extends Instruction {

    public ALUInstruction(final InstructionType instructionType, final String operandsPart) {
        super(instructionType, operandsPart);
    }

    @Override
    public String getHexCode() throws Exception {
        final String[] ops = operands.split(",");
        final String dest = Register.valueOf(ops[0]).getAddress();
        final String src1 = Register.valueOf(ops[1]).getAddress();
        String src2;
        String format;

        if (instructionType.isImmediate()) {
            format = "%s%s%s1%s";

            int imm = Integer.parseInt(ops[2]);
            if (imm < -64 || imm > 63) throw new Exception("Immediate is out of range.");

            src2 = Integer.toBinaryString(imm);
            if (imm < 0) {
                int length = src2.length();
                src2 = src2.substring(length - 7, length);
            } else {
                src2 = String.format("%7s", src2).replaceAll(" ", "0");
            }
        } else {
            format = "%s%s%s0000%s";
            src2 = Register.valueOf(ops[2]).getAddress();
        }

        final String bin = String.format(format, instructionType.getOpcode(), dest, src1, src2);
        return ConversionUtil.binaryToHexadecimal(bin);
    }
}
