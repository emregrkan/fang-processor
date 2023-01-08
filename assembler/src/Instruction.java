public abstract class Instruction {

    protected final InstructionType instructionType;
    protected final String operands;
    
    public Instruction(final InstructionType instructionType, final String operands) {
        this.instructionType = instructionType;
        this.operands = operands;
    }

    public abstract String getHexCode() throws Exception;
}
