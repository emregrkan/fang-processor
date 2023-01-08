public enum InstructionType {
    HALT("0000"),
    ADD("0001"),
    SUB("0010"),
    AND("0011"),
    OR("0100"),
    XOR("0101"),
    ADDI("0001", true),
    SUBI("0010", true),
    ANDI("0011", true),
    ORI("0100", true),
    XORI("0101", true),
    LD("0110"),
    ST("0111"),
    JUMP("1000"),
    PUSH("1001"),
    POP("1010"),
    BE("1011"),
    BNE("1100");

    private final String opcode;
    private final Boolean isImmediate;

    InstructionType(final String opcode) {
        this.opcode = opcode;
        this.isImmediate = false;
    }

    InstructionType(final String opcode, final Boolean isImmediate) {
        this.opcode = opcode;
        this.isImmediate = isImmediate;
    }

    public String getOpcode() {
        return opcode;
    }

    public Boolean isImmediate() {
        return isImmediate;
    }
}
