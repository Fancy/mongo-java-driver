/**
 *  See the NOTICE.txt file distributed with this work for
 *  information regarding copyright ownership.
 *
 *  The authors license this file to you under the
 *  Apache License, Version 2.0 (the "License"); you may not use
 *  this file except in compliance with the License.  You may
 *  obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mongodb.mql;

/**
 * Token Manager.
 */
public class MQLTokenManager implements MQLConstants {

    /**
     * Debug output.
     */
    public java.io.PrintStream debugStream = System.out;

    /**
     * Set debug output.
     */
    public void setDebugStream(java.io.PrintStream ds) {
        debugStream = ds;
    }

    private int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    private int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
            case 9:
                jjmatchedKind = 4;
                return jjMoveNfa_0(9, 0);
            case 10:
                jjmatchedKind = 2;
                return jjMoveNfa_0(9, 0);
            case 13:
                jjmatchedKind = 3;
                return jjMoveNfa_0(9, 0);
            case 32:
                jjmatchedKind = 1;
                return jjMoveNfa_0(9, 0);
            case 40:
                jjmatchedKind = 87;
                return jjMoveNfa_0(9, 0);
            case 41:
                jjmatchedKind = 88;
                return jjMoveNfa_0(9, 0);
            case 42:
                jjmatchedKind = 15;
                return jjMoveNfa_0(9, 0);
            case 43:
                jjmatchedKind = 13;
                return jjMoveNfa_0(9, 0);
            case 44:
                jjmatchedKind = 5;
                return jjMoveNfa_0(9, 0);
            case 45:
                jjmatchedKind = 14;
                return jjMoveNfa_0(9, 0);
            case 46:
                jjmatchedKind = 6;
                return jjMoveNfa_0(9, 0);
            case 47:
                jjmatchedKind = 16;
                return jjMoveNfa_0(9, 0);
            case 58:
                jjmatchedKind = 89;
                return jjMoveNfa_0(9, 0);
            case 60:
                jjmatchedKind = 11;
                return jjMoveStringLiteralDfa1_0(0x1100L, 0x0L);
            case 61:
                jjmatchedKind = 7;
                return jjMoveNfa_0(9, 0);
            case 62:
                jjmatchedKind = 9;
                return jjMoveStringLiteralDfa1_0(0x400L, 0x0L);
            case 63:
                jjmatchedKind = 90;
                return jjMoveNfa_0(9, 0);
            case 65:
                return jjMoveStringLiteralDfa1_0(0x400410008c0000L, 0x20L);
            case 66:
                return jjMoveStringLiteralDfa1_0(0x8000404000000L, 0x0L);
            case 67:
                return jjMoveStringLiteralDfa1_0(0x1c00110000000000L, 0x0L);
            case 68:
                return jjMoveStringLiteralDfa1_0(0x4000000001000000L, 0x2L);
            case 69:
                return jjMoveStringLiteralDfa1_0(0x200500000L, 0x0L);
            case 70:
                return jjMoveStringLiteralDfa1_0(0x8000000000000000L, 0x400L);
            case 71:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x8L);
            case 72:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x10L);
            case 73:
                return jjMoveStringLiteralDfa1_0(0x20000000L, 0x900L);
            case 74:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x200L);
            case 76:
                return jjMoveStringLiteralDfa1_0(0x32800108000000L, 0x40L);
            case 77:
                return jjMoveStringLiteralDfa1_0(0x100006040000000L, 0x0L);
            case 78:
                return jjMoveStringLiteralDfa1_0(0x80800020000L, 0x0L);
            case 79:
                return jjMoveStringLiteralDfa1_0(0x20082000000L, 0x2080L);
            case 83:
                return jjMoveStringLiteralDfa1_0(0x2280208010200000L, 0x1000L);
            case 84:
                return jjMoveStringLiteralDfa1_0(0x4400000000000L, 0x0L);
            case 85:
                return jjMoveStringLiteralDfa1_0(0x1000000000000L, 0x1L);
            case 87:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x4L);
            case 97:
                return jjMoveStringLiteralDfa1_0(0x400410008c0000L, 0x20L);
            case 98:
                return jjMoveStringLiteralDfa1_0(0x8000404000000L, 0x0L);
            case 99:
                return jjMoveStringLiteralDfa1_0(0x1c00110000000000L, 0x0L);
            case 100:
                return jjMoveStringLiteralDfa1_0(0x4000000001000000L, 0x2L);
            case 101:
                return jjMoveStringLiteralDfa1_0(0x200500000L, 0x0L);
            case 102:
                return jjMoveStringLiteralDfa1_0(0x8000000000000000L, 0x400L);
            case 103:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x8L);
            case 104:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x10L);
            case 105:
                return jjMoveStringLiteralDfa1_0(0x20000000L, 0x900L);
            case 106:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x200L);
            case 108:
                return jjMoveStringLiteralDfa1_0(0x32800108000000L, 0x40L);
            case 109:
                return jjMoveStringLiteralDfa1_0(0x100006040000000L, 0x0L);
            case 110:
                return jjMoveStringLiteralDfa1_0(0x80800020000L, 0x0L);
            case 111:
                return jjMoveStringLiteralDfa1_0(0x20082000000L, 0x2080L);
            case 115:
                return jjMoveStringLiteralDfa1_0(0x2280208010200000L, 0x1000L);
            case 116:
                return jjMoveStringLiteralDfa1_0(0x4400000000000L, 0x0L);
            case 117:
                return jjMoveStringLiteralDfa1_0(0x1000000000000L, 0x1L);
            case 119:
                return jjMoveStringLiteralDfa1_0(0x0L, 0x4L);
            default:
                return jjMoveNfa_0(9, 0);
        }
    }

    private int jjMoveStringLiteralDfa1_0(long active0, long active1) {
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 0);
        }
        switch (curChar) {
            case 61:
                if ((active0 & 0x400L) != 0L) {
                    jjmatchedKind = 10;
                    jjmatchedPos = 1;
                } else if ((active0 & 0x1000L) != 0L) {
                    jjmatchedKind = 12;
                    jjmatchedPos = 1;
                }
                break;
            case 62:
                if ((active0 & 0x100L) != 0L) {
                    jjmatchedKind = 8;
                    jjmatchedPos = 1;
                }
                break;
            case 65:
                return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L, active1, 0x10L);
            case 66:
                return jjMoveStringLiteralDfa2_0(active0, 0x40000000000000L, active1, 0x2000L);
            case 69:
                return jjMoveStringLiteralDfa2_0(active0, 0x2012000441020000L, active1, 0x1442L);
            case 70:
                if ((active0 & 0x80000000L) != 0L) {
                    jjmatchedKind = 31;
                    jjmatchedPos = 1;
                }
                break;
            case 72:
                return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x4L);
            case 73:
                return jjMoveStringLiteralDfa2_0(active0, 0x4200002108000000L, active1, 0L);
            case 75:
                return jjMoveStringLiteralDfa2_0(active0, 0x10000000L, active1, 0L);
            case 76:
                return jjMoveStringLiteralDfa2_0(active0, 0x40000L, active1, 0L);
            case 77:
                return jjMoveStringLiteralDfa2_0(active0, 0x400000L, active1, 0L);
            case 78:
                if ((active1 & 0x800L) != 0L) {
                    jjmatchedKind = 75;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x40000080000L, active1, 0x100L);
            case 79:
                return jjMoveStringLiteralDfa2_0(active0, 0x128990000200000L, active1, 0x200L);
            case 80:
                return jjMoveStringLiteralDfa2_0(active0, 0x1000000000000L, active1, 0x1L);
            case 81:
                return jjMoveStringLiteralDfa2_0(active0, 0x80000000000000L, active1, 0L);
            case 82:
                if ((active0 & 0x20000000000L) != 0L) {
                    jjmatchedKind = 41;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x8004400002000000L, active1, 0x8L);
            case 83:
                if ((active0 & 0x20000000L) != 0L) {
                    jjmatchedKind = 29;
                    jjmatchedPos = 1;
                } else if ((active1 & 0x20L) != 0L) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x200800000L, active1, 0L);
            case 85:
                return jjMoveStringLiteralDfa2_0(active0, 0x1c00208800000000L, active1, 0x80L);
            case 86:
                return jjMoveStringLiteralDfa2_0(active0, 0x1000000000L, active1, 0L);
            case 88:
                return jjMoveStringLiteralDfa2_0(active0, 0x100000L, active1, 0L);
            case 89:
                if ((active0 & 0x4000000L) != 0L) {
                    jjmatchedKind = 26;
                    jjmatchedPos = 1;
                }
                break;
            case 97:
                return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L, active1, 0x10L);
            case 98:
                return jjMoveStringLiteralDfa2_0(active0, 0x40000000000000L, active1, 0x2000L);
            case 101:
                return jjMoveStringLiteralDfa2_0(active0, 0x2012000441020000L, active1, 0x1442L);
            case 102:
                if ((active0 & 0x80000000L) != 0L) {
                    jjmatchedKind = 31;
                    jjmatchedPos = 1;
                }
                break;
            case 104:
                return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x4L);
            case 105:
                return jjMoveStringLiteralDfa2_0(active0, 0x4200002108000000L, active1, 0L);
            case 107:
                return jjMoveStringLiteralDfa2_0(active0, 0x10000000L, active1, 0L);
            case 108:
                return jjMoveStringLiteralDfa2_0(active0, 0x40000L, active1, 0L);
            case 109:
                return jjMoveStringLiteralDfa2_0(active0, 0x400000L, active1, 0L);
            case 110:
                if ((active1 & 0x800L) != 0L) {
                    jjmatchedKind = 75;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x40000080000L, active1, 0x100L);
            case 111:
                return jjMoveStringLiteralDfa2_0(active0, 0x128990000200000L, active1, 0x200L);
            case 112:
                return jjMoveStringLiteralDfa2_0(active0, 0x1000000000000L, active1, 0x1L);
            case 113:
                return jjMoveStringLiteralDfa2_0(active0, 0x80000000000000L, active1, 0L);
            case 114:
                if ((active0 & 0x20000000000L) != 0L) {
                    jjmatchedKind = 41;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x8004400002000000L, active1, 0x8L);
            case 115:
                if ((active0 & 0x20000000L) != 0L) {
                    jjmatchedKind = 29;
                    jjmatchedPos = 1;
                } else if ((active1 & 0x20L) != 0L) {
                    jjmatchedKind = 69;
                    jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(active0, 0x200800000L, active1, 0L);
            case 117:
                return jjMoveStringLiteralDfa2_0(active0, 0x1c00208800000000L, active1, 0x80L);
            case 118:
                return jjMoveStringLiteralDfa2_0(active0, 0x1000000000L, active1, 0L);
            case 120:
                return jjMoveStringLiteralDfa2_0(active0, 0x100000L, active1, 0L);
            case 121:
                if ((active0 & 0x4000000L) != 0L) {
                    jjmatchedKind = 26;
                    jjmatchedPos = 1;
                }
                break;
            default:
                break;
        }
        return jjMoveNfa_0(9, 1);
    }

    private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjMoveNfa_0(9, 1);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 1);
        }
        switch (curChar) {
            case 65:
                return jjMoveStringLiteralDfa3_0(active0, 0x6000000000000L, active1, 0L);
            case 66:
                return jjMoveStringLiteralDfa3_0(active0, 0x200000000000L, active1, 0L);
            case 67:
                if ((active0 & 0x800000L) != 0L) {
                    jjmatchedKind = 23;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x20000200000000L, active1, 0L);
            case 68:
                if ((active0 & 0x40000000000L) != 0L) {
                    jjmatchedKind = 42;
                    jjmatchedPos = 2;
                } else if ((active0 & 0x100000000000000L) != 0L) {
                    jjmatchedKind = 56;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x2000000L, active1, 0x1L);
            case 69:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x4L);
            case 70:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x40L);
            case 71:
                if ((active0 & 0x1000000000L) != 0L) {
                    jjmatchedKind = 36;
                    jjmatchedPos = 2;
                }
                break;
            case 73:
                return jjMoveStringLiteralDfa3_0(active0, 0x400010100000L, active1, 0x200L);
            case 74:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x2000L);
            case 75:
                return jjMoveStringLiteralDfa3_0(active0, 0x100000000L, active1, 0L);
            case 76:
                if ((active0 & 0x40000L) != 0L) {
                    jjmatchedKind = 18;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x2000000800000000L, active1, 0x2L);
            case 77:
                if ((active0 & 0x8000000000L) != 0L) {
                    jjmatchedKind = 39;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x48200000L, active1, 0L);
            case 78:
                if ((active0 & 0x2000000000L) != 0L) {
                    jjmatchedKind = 37;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x10100000000000L, active1, 0x100L);
            case 79:
                return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000000L, active1, 0x8L);
            case 80:
                return jjMoveStringLiteralDfa3_0(active0, 0x1000000400000L, active1, 0L);
            case 82:
                return jjMoveStringLiteralDfa3_0(active0, 0x1c80000000000000L, active1, 0L);
            case 83:
                if ((active0 & 0x40000000000000L) != 0L) {
                    jjmatchedKind = 54;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x4000000001000000L, active1, 0L);
            case 84:
                if ((active0 & 0x80000000000L) != 0L) {
                    jjmatchedKind = 43;
                    jjmatchedPos = 2;
                } else if ((active1 & 0x1000L) != 0L) {
                    jjmatchedKind = 76;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x8000400000000L, active1, 0x480L);
            case 85:
                return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L, active1, 0L);
            case 86:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x10L);
            case 87:
                if ((active0 & 0x20000L) != 0L) {
                    jjmatchedKind = 17;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x800000000000L, active1, 0L);
            case 88:
                if ((active0 & 0x4000000000L) != 0L) {
                    jjmatchedKind = 38;
                    jjmatchedPos = 2;
                }
                break;
            case 89:
                if ((active0 & 0x80000L) != 0L) {
                    jjmatchedKind = 19;
                    jjmatchedPos = 2;
                }
                break;
            case 90:
                return jjMoveStringLiteralDfa3_0(active0, 0x200000000000000L, active1, 0L);
            case 97:
                return jjMoveStringLiteralDfa3_0(active0, 0x6000000000000L, active1, 0L);
            case 98:
                return jjMoveStringLiteralDfa3_0(active0, 0x200000000000L, active1, 0L);
            case 99:
                if ((active0 & 0x800000L) != 0L) {
                    jjmatchedKind = 23;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x20000200000000L, active1, 0L);
            case 100:
                if ((active0 & 0x40000000000L) != 0L) {
                    jjmatchedKind = 42;
                    jjmatchedPos = 2;
                } else if ((active0 & 0x100000000000000L) != 0L) {
                    jjmatchedKind = 56;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x2000000L, active1, 0x1L);
            case 101:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x4L);
            case 102:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x40L);
            case 103:
                if ((active0 & 0x1000000000L) != 0L) {
                    jjmatchedKind = 36;
                    jjmatchedPos = 2;
                }
                break;
            case 105:
                return jjMoveStringLiteralDfa3_0(active0, 0x400010100000L, active1, 0x200L);
            case 106:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x2000L);
            case 107:
                return jjMoveStringLiteralDfa3_0(active0, 0x100000000L, active1, 0L);
            case 108:
                if ((active0 & 0x40000L) != 0L) {
                    jjmatchedKind = 18;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x2000000800000000L, active1, 0x2L);
            case 109:
                if ((active0 & 0x8000000000L) != 0L) {
                    jjmatchedKind = 39;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x48200000L, active1, 0L);
            case 110:
                if ((active0 & 0x2000000000L) != 0L) {
                    jjmatchedKind = 37;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x10100000000000L, active1, 0x100L);
            case 111:
                return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000000L, active1, 0x8L);
            case 112:
                return jjMoveStringLiteralDfa3_0(active0, 0x1000000400000L, active1, 0L);
            case 114:
                return jjMoveStringLiteralDfa3_0(active0, 0x1c80000000000000L, active1, 0L);
            case 115:
                if ((active0 & 0x40000000000000L) != 0L) {
                    jjmatchedKind = 54;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x4000000001000000L, active1, 0L);
            case 116:
                if ((active0 & 0x80000000000L) != 0L) {
                    jjmatchedKind = 43;
                    jjmatchedPos = 2;
                } else if ((active1 & 0x1000L) != 0L) {
                    jjmatchedKind = 76;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x8000400000000L, active1, 0x480L);
            case 117:
                return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L, active1, 0L);
            case 118:
                return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x10L);
            case 119:
                if ((active0 & 0x20000L) != 0L) {
                    jjmatchedKind = 17;
                    jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(active0, 0x800000000000L, active1, 0L);
            case 120:
                if ((active0 & 0x4000000000L) != 0L) {
                    jjmatchedKind = 38;
                    jjmatchedPos = 2;
                }
                break;
            case 121:
                if ((active0 & 0x80000L) != 0L) {
                    jjmatchedKind = 19;
                    jjmatchedPos = 2;
                }
                break;
            case 122:
                return jjMoveStringLiteralDfa3_0(active0, 0x200000000000000L, active1, 0L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 2);
    }

    private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjMoveNfa_0(9, 2);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 2);
        }
        switch (curChar) {
            case 65:
                return jjMoveStringLiteralDfa4_0(active0, 0x20000200000000L, active1, 0x1L);
            case 66:
                return jjMoveStringLiteralDfa4_0(active0, 0x40000000L, active1, 0L);
            case 67:
                if ((active0 & 0x1000000L) != 0L) {
                    jjmatchedKind = 24;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x100000000000L, active1, 0x400L);
            case 68:
                return jjMoveStringLiteralDfa4_0(active0, 0x2000000000000L, active1, 0L);
            case 69:
                if ((active0 & 0x200000L) != 0L) {
                    jjmatchedKind = 21;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x100000000L) != 0L) {
                    jjmatchedKind = 32;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x200000000000000L) != 0L) {
                    jjmatchedKind = 57;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x2001800002000000L, active1, 0x2182L);
            case 71:
                return jjMoveStringLiteralDfa4_0(active0, 0x10000000000000L, active1, 0L);
            case 72:
                if ((active0 & 0x8000000000000L) != 0L) {
                    jjmatchedKind = 51;
                    jjmatchedPos = 3;
                }
                break;
            case 73:
                return jjMoveStringLiteralDfa4_0(active0, 0x4000008000000L, active1, 0x10L);
            case 76:
                if ((active0 & 0x800000000L) != 0L) {
                    jjmatchedKind = 35;
                    jjmatchedPos = 3;
                }
                break;
            case 77:
                if ((active0 & 0x400000000000L) != 0L) {
                    jjmatchedKind = 46;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x8000000000000000L) != 0L) {
                    jjmatchedKind = 63;
                    jjmatchedPos = 3;
                }
                break;
            case 78:
                if ((active1 & 0x200L) != 0L) {
                    jjmatchedKind = 73;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x10000000000L, active1, 0L);
            case 80:
                if ((active0 & 0x10000000L) != 0L) {
                    jjmatchedKind = 28;
                    jjmatchedPos = 3;
                }
                break;
            case 82:
                return jjMoveStringLiteralDfa4_0(active0, 0x1c00000000000000L, active1, 0x4L);
            case 83:
                return jjMoveStringLiteralDfa4_0(active0, 0x200000100000L, active1, 0L);
            case 84:
                if ((active0 & 0x80000000000000L) != 0L) {
                    jjmatchedKind = 55;
                    jjmatchedPos = 3;
                } else if ((active1 & 0x40L) != 0L) {
                    jjmatchedKind = 70;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x4000000000400000L, active1, 0L);
            case 85:
                return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x8L);
            case 87:
                return jjMoveStringLiteralDfa4_0(active0, 0x400000000L, active1, 0L);
            case 97:
                return jjMoveStringLiteralDfa4_0(active0, 0x20000200000000L, active1, 0x1L);
            case 98:
                return jjMoveStringLiteralDfa4_0(active0, 0x40000000L, active1, 0L);
            case 99:
                if ((active0 & 0x1000000L) != 0L) {
                    jjmatchedKind = 24;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x100000000000L, active1, 0x400L);
            case 100:
                return jjMoveStringLiteralDfa4_0(active0, 0x2000000000000L, active1, 0L);
            case 101:
                if ((active0 & 0x200000L) != 0L) {
                    jjmatchedKind = 21;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x100000000L) != 0L) {
                    jjmatchedKind = 32;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x200000000000000L) != 0L) {
                    jjmatchedKind = 57;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x2001800002000000L, active1, 0x2182L);
            case 103:
                return jjMoveStringLiteralDfa4_0(active0, 0x10000000000000L, active1, 0L);
            case 104:
                if ((active0 & 0x8000000000000L) != 0L) {
                    jjmatchedKind = 51;
                    jjmatchedPos = 3;
                }
                break;
            case 105:
                return jjMoveStringLiteralDfa4_0(active0, 0x4000008000000L, active1, 0x10L);
            case 108:
                if ((active0 & 0x800000000L) != 0L) {
                    jjmatchedKind = 35;
                    jjmatchedPos = 3;
                }
                break;
            case 109:
                if ((active0 & 0x400000000000L) != 0L) {
                    jjmatchedKind = 46;
                    jjmatchedPos = 3;
                } else if ((active0 & 0x8000000000000000L) != 0L) {
                    jjmatchedKind = 63;
                    jjmatchedPos = 3;
                }
                break;
            case 110:
                if ((active1 & 0x200L) != 0L) {
                    jjmatchedKind = 73;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x10000000000L, active1, 0L);
            case 112:
                if ((active0 & 0x10000000L) != 0L) {
                    jjmatchedKind = 28;
                    jjmatchedPos = 3;
                }
                break;
            case 114:
                return jjMoveStringLiteralDfa4_0(active0, 0x1c00000000000000L, active1, 0x4L);
            case 115:
                return jjMoveStringLiteralDfa4_0(active0, 0x200000100000L, active1, 0L);
            case 116:
                if ((active0 & 0x80000000000000L) != 0L) {
                    jjmatchedKind = 55;
                    jjmatchedPos = 3;
                } else if ((active1 & 0x40L) != 0L) {
                    jjmatchedKind = 70;
                    jjmatchedPos = 3;
                }
                return jjMoveStringLiteralDfa4_0(active0, 0x4000000000400000L, active1, 0L);
            case 117:
                return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x8L);
            case 119:
                return jjMoveStringLiteralDfa4_0(active0, 0x400000000L, active1, 0L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 3);
    }

    private int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjMoveNfa_0(9, 3);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 3);
        }
        switch (curChar) {
            case 65:
                return jjMoveStringLiteralDfa5_0(active0, 0x100000000000L, active1, 0L);
            case 67:
                return jjMoveStringLiteralDfa5_0(active0, 0x2000000000000000L, active1, 0x2000L);
            case 69:
                if ((active1 & 0x4L) != 0L) {
                    jjmatchedKind = 66;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x1c00000440000000L, active1, 0L);
            case 72:
                if ((active1 & 0x400L) != 0L) {
                    jjmatchedKind = 74;
                    jjmatchedPos = 4;
                }
                break;
            case 73:
                return jjMoveStringLiteralDfa5_0(active0, 0x4002000000000000L, active1, 0L);
            case 76:
                return jjMoveStringLiteralDfa5_0(active0, 0x4000000000000L, active1, 0L);
            case 78:
                return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x10L);
            case 80:
                if ((active1 & 0x8L) != 0L) {
                    jjmatchedKind = 67;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x200000000L, active1, 0L);
            case 82:
                if ((active0 & 0x2000000L) != 0L) {
                    jjmatchedKind = 25;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x800000000000L) != 0L) {
                    jjmatchedKind = 47;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x1000000000000L) != 0L) {
                    jjmatchedKind = 48;
                    jjmatchedPos = 4;
                } else if ((active1 & 0x80L) != 0L) {
                    jjmatchedKind = 71;
                    jjmatchedPos = 4;
                } else if ((active1 & 0x100L) != 0L) {
                    jjmatchedKind = 72;
                    jjmatchedPos = 4;
                }
                break;
            case 84:
                if ((active0 & 0x8000000L) != 0L) {
                    jjmatchedKind = 27;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x10000000000L) != 0L) {
                    jjmatchedKind = 40;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x30200000100000L, active1, 0x3L);
            case 89:
                if ((active0 & 0x400000L) != 0L) {
                    jjmatchedKind = 22;
                    jjmatchedPos = 4;
                }
                break;
            case 97:
                return jjMoveStringLiteralDfa5_0(active0, 0x100000000000L, active1, 0L);
            case 99:
                return jjMoveStringLiteralDfa5_0(active0, 0x2000000000000000L, active1, 0x2000L);
            case 101:
                if ((active1 & 0x4L) != 0L) {
                    jjmatchedKind = 66;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x1c00000440000000L, active1, 0L);
            case 104:
                if ((active1 & 0x400L) != 0L) {
                    jjmatchedKind = 74;
                    jjmatchedPos = 4;
                }
                break;
            case 105:
                return jjMoveStringLiteralDfa5_0(active0, 0x4002000000000000L, active1, 0L);
            case 108:
                return jjMoveStringLiteralDfa5_0(active0, 0x4000000000000L, active1, 0L);
            case 110:
                return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x10L);
            case 112:
                if ((active1 & 0x8L) != 0L) {
                    jjmatchedKind = 67;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x200000000L, active1, 0L);
            case 114:
                if ((active0 & 0x2000000L) != 0L) {
                    jjmatchedKind = 25;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x800000000000L) != 0L) {
                    jjmatchedKind = 47;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x1000000000000L) != 0L) {
                    jjmatchedKind = 48;
                    jjmatchedPos = 4;
                } else if ((active1 & 0x80L) != 0L) {
                    jjmatchedKind = 71;
                    jjmatchedPos = 4;
                } else if ((active1 & 0x100L) != 0L) {
                    jjmatchedKind = 72;
                    jjmatchedPos = 4;
                }
                break;
            case 116:
                if ((active0 & 0x8000000L) != 0L) {
                    jjmatchedKind = 27;
                    jjmatchedPos = 4;
                } else if ((active0 & 0x10000000000L) != 0L) {
                    jjmatchedKind = 40;
                    jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(active0, 0x30200000100000L, active1, 0x3L);
            case 121:
                if ((active0 & 0x400000L) != 0L) {
                    jjmatchedKind = 22;
                    jjmatchedPos = 4;
                }
                break;
            default:
                break;
        }
        return jjMoveNfa_0(9, 4);
    }

    private int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjMoveNfa_0(9, 4);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 4);
        }
        switch (curChar) {
            case 69:
                if ((active0 & 0x200000000L) != 0L) {
                    jjmatchedKind = 33;
                    jjmatchedPos = 5;
                } else if ((active0 & 0x20000000000000L) != 0L) {
                    jjmatchedKind = 53;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x1L) != 0L) {
                    jjmatchedKind = 64;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x2L) != 0L) {
                    jjmatchedKind = 65;
                    jjmatchedPos = 5;
                }
                return jjMoveStringLiteralDfa6_0(active0, 0x400000000L, active1, 0L);
            case 71:
                if ((active1 & 0x10L) != 0L) {
                    jjmatchedKind = 68;
                    jjmatchedPos = 5;
                }
                break;
            case 72:
                if ((active0 & 0x10000000000000L) != 0L) {
                    jjmatchedKind = 52;
                    jjmatchedPos = 5;
                }
                break;
            case 73:
                return jjMoveStringLiteralDfa6_0(active0, 0x4000000000000L, active1, 0L);
            case 78:
                return jjMoveStringLiteralDfa6_0(active0, 0x5c02000000000000L, active1, 0L);
            case 82:
                if ((active0 & 0x40000000L) != 0L) {
                    jjmatchedKind = 30;
                    jjmatchedPos = 5;
                }
                return jjMoveStringLiteralDfa6_0(active0, 0x200000000000L, active1, 0L);
            case 83:
                if ((active0 & 0x100000L) != 0L) {
                    jjmatchedKind = 20;
                    jjmatchedPos = 5;
                }
                break;
            case 84:
                if ((active0 & 0x100000000000L) != 0L) {
                    jjmatchedKind = 44;
                    jjmatchedPos = 5;
                } else if ((active0 & 0x2000000000000000L) != 0L) {
                    jjmatchedKind = 61;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x2000L) != 0L) {
                    jjmatchedKind = 77;
                    jjmatchedPos = 5;
                }
                break;
            case 101:
                if ((active0 & 0x200000000L) != 0L) {
                    jjmatchedKind = 33;
                    jjmatchedPos = 5;
                } else if ((active0 & 0x20000000000000L) != 0L) {
                    jjmatchedKind = 53;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x1L) != 0L) {
                    jjmatchedKind = 64;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x2L) != 0L) {
                    jjmatchedKind = 65;
                    jjmatchedPos = 5;
                }
                return jjMoveStringLiteralDfa6_0(active0, 0x400000000L, active1, 0L);
            case 103:
                if ((active1 & 0x10L) != 0L) {
                    jjmatchedKind = 68;
                    jjmatchedPos = 5;
                }
                break;
            case 104:
                if ((active0 & 0x10000000000000L) != 0L) {
                    jjmatchedKind = 52;
                    jjmatchedPos = 5;
                }
                break;
            case 105:
                return jjMoveStringLiteralDfa6_0(active0, 0x4000000000000L, active1, 0L);
            case 110:
                return jjMoveStringLiteralDfa6_0(active0, 0x5c02000000000000L, active1, 0L);
            case 114:
                if ((active0 & 0x40000000L) != 0L) {
                    jjmatchedKind = 30;
                    jjmatchedPos = 5;
                }
                return jjMoveStringLiteralDfa6_0(active0, 0x200000000000L, active1, 0L);
            case 115:
                if ((active0 & 0x100000L) != 0L) {
                    jjmatchedKind = 20;
                    jjmatchedPos = 5;
                }
                break;
            case 116:
                if ((active0 & 0x100000000000L) != 0L) {
                    jjmatchedKind = 44;
                    jjmatchedPos = 5;
                } else if ((active0 & 0x2000000000000000L) != 0L) {
                    jjmatchedKind = 61;
                    jjmatchedPos = 5;
                } else if ((active1 & 0x2000L) != 0L) {
                    jjmatchedKind = 77;
                    jjmatchedPos = 5;
                }
                break;
            default:
                break;
        }
        return jjMoveNfa_0(9, 5);
    }

    private int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1) {
        if (((active0 &= old0) | (active1 &= old1)) == 0L)
            return jjMoveNfa_0(9, 5);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 5);
        }
        switch (curChar) {
            case 67:
                return jjMoveStringLiteralDfa7_0(active0, 0x4000000000000000L);
            case 71:
                if ((active0 & 0x2000000000000L) != 0L) {
                    jjmatchedKind = 49;
                    jjmatchedPos = 6;
                }
                break;
            case 73:
                return jjMoveStringLiteralDfa7_0(active0, 0x200000000000L);
            case 78:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 34;
                    jjmatchedPos = 6;
                }
                return jjMoveStringLiteralDfa7_0(active0, 0x4000000000000L);
            case 84:
                return jjMoveStringLiteralDfa7_0(active0, 0x1c00000000000000L);
            case 99:
                return jjMoveStringLiteralDfa7_0(active0, 0x4000000000000000L);
            case 103:
                if ((active0 & 0x2000000000000L) != 0L) {
                    jjmatchedKind = 49;
                    jjmatchedPos = 6;
                }
                break;
            case 105:
                return jjMoveStringLiteralDfa7_0(active0, 0x200000000000L);
            case 110:
                if ((active0 & 0x400000000L) != 0L) {
                    jjmatchedKind = 34;
                    jjmatchedPos = 6;
                }
                return jjMoveStringLiteralDfa7_0(active0, 0x4000000000000L);
            case 116:
                return jjMoveStringLiteralDfa7_0(active0, 0x1c00000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 6);
    }

    private int jjMoveStringLiteralDfa7_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 6);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 6);
        }
        switch (curChar) {
            case 71:
                if ((active0 & 0x4000000000000L) != 0L) {
                    jjmatchedKind = 50;
                    jjmatchedPos = 7;
                }
                break;
            case 78:
                return jjMoveStringLiteralDfa8_0(active0, 0x200000000000L);
            case 84:
                if ((active0 & 0x4000000000000000L) != 0L) {
                    jjmatchedKind = 62;
                    jjmatchedPos = 7;
                }
                break;
            case 95:
                return jjMoveStringLiteralDfa8_0(active0, 0x1c00000000000000L);
            case 103:
                if ((active0 & 0x4000000000000L) != 0L) {
                    jjmatchedKind = 50;
                    jjmatchedPos = 7;
                }
                break;
            case 110:
                return jjMoveStringLiteralDfa8_0(active0, 0x200000000000L);
            case 116:
                if ((active0 & 0x4000000000000000L) != 0L) {
                    jjmatchedKind = 62;
                    jjmatchedPos = 7;
                }
                break;
            default:
                break;
        }
        return jjMoveNfa_0(9, 7);
    }

    private int jjMoveStringLiteralDfa8_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 7);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 7);
        }
        switch (curChar) {
            case 68:
                return jjMoveStringLiteralDfa9_0(active0, 0x400000000000000L);
            case 71:
                if ((active0 & 0x200000000000L) != 0L) {
                    jjmatchedKind = 45;
                    jjmatchedPos = 8;
                }
                break;
            case 84:
                return jjMoveStringLiteralDfa9_0(active0, 0x1800000000000000L);
            case 100:
                return jjMoveStringLiteralDfa9_0(active0, 0x400000000000000L);
            case 103:
                if ((active0 & 0x200000000000L) != 0L) {
                    jjmatchedKind = 45;
                    jjmatchedPos = 8;
                }
                break;
            case 116:
                return jjMoveStringLiteralDfa9_0(active0, 0x1800000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 8);
    }

    private int jjMoveStringLiteralDfa9_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 8);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 8);
        }
        switch (curChar) {
            case 65:
                return jjMoveStringLiteralDfa10_0(active0, 0x400000000000000L);
            case 73:
                return jjMoveStringLiteralDfa10_0(active0, 0x1800000000000000L);
            case 97:
                return jjMoveStringLiteralDfa10_0(active0, 0x400000000000000L);
            case 105:
                return jjMoveStringLiteralDfa10_0(active0, 0x1800000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 9);
    }

    private int jjMoveStringLiteralDfa10_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 9);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 9);
        }
        switch (curChar) {
            case 77:
                return jjMoveStringLiteralDfa11_0(active0, 0x1800000000000000L);
            case 84:
                return jjMoveStringLiteralDfa11_0(active0, 0x400000000000000L);
            case 109:
                return jjMoveStringLiteralDfa11_0(active0, 0x1800000000000000L);
            case 116:
                return jjMoveStringLiteralDfa11_0(active0, 0x400000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 10);
    }

    private int jjMoveStringLiteralDfa11_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 10);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 10);
        }
        switch (curChar) {
            case 69:
                if ((active0 & 0x400000000000000L) != 0L) {
                    jjmatchedKind = 58;
                    jjmatchedPos = 11;
                } else if ((active0 & 0x800000000000000L) != 0L) {
                    jjmatchedKind = 59;
                    jjmatchedPos = 11;
                }
                return jjMoveStringLiteralDfa12_0(active0, 0x1000000000000000L);
            case 101:
                if ((active0 & 0x400000000000000L) != 0L) {
                    jjmatchedKind = 58;
                    jjmatchedPos = 11;
                } else if ((active0 & 0x800000000000000L) != 0L) {
                    jjmatchedKind = 59;
                    jjmatchedPos = 11;
                }
                return jjMoveStringLiteralDfa12_0(active0, 0x1000000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 11);
    }

    private int jjMoveStringLiteralDfa12_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 11);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 11);
        }
        switch (curChar) {
            case 83:
                return jjMoveStringLiteralDfa13_0(active0, 0x1000000000000000L);
            case 115:
                return jjMoveStringLiteralDfa13_0(active0, 0x1000000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 12);
    }

    private int jjMoveStringLiteralDfa13_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 12);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 12);
        }
        switch (curChar) {
            case 84:
                return jjMoveStringLiteralDfa14_0(active0, 0x1000000000000000L);
            case 116:
                return jjMoveStringLiteralDfa14_0(active0, 0x1000000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 13);
    }

    private int jjMoveStringLiteralDfa14_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 13);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 13);
        }
        switch (curChar) {
            case 65:
                return jjMoveStringLiteralDfa15_0(active0, 0x1000000000000000L);
            case 97:
                return jjMoveStringLiteralDfa15_0(active0, 0x1000000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 14);
    }

    private int jjMoveStringLiteralDfa15_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 14);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 14);
        }
        switch (curChar) {
            case 77:
                return jjMoveStringLiteralDfa16_0(active0, 0x1000000000000000L);
            case 109:
                return jjMoveStringLiteralDfa16_0(active0, 0x1000000000000000L);
            default:
                break;
        }
        return jjMoveNfa_0(9, 15);
    }

    private int jjMoveStringLiteralDfa16_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjMoveNfa_0(9, 15);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return jjMoveNfa_0(9, 15);
        }
        switch (curChar) {
            case 80:
                if ((active0 & 0x1000000000000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 16;
                }
                break;
            case 112:
                if ((active0 & 0x1000000000000000L) != 0L) {
                    jjmatchedKind = 60;
                    jjmatchedPos = 16;
                }
                break;
            default:
                break;
        }
        return jjMoveNfa_0(9, 16);
    }

    static final long[] jjbitVec0 = {
            0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
    };
    static final long[] jjbitVec2 = {
            0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
    };
    static final long[] jjbitVec3 = {
            0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
    };
    static final long[] jjbitVec4 = {
            0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
    };
    static final long[] jjbitVec5 = {
            0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
    };
    static final long[] jjbitVec6 = {
            0x3fffffffffffL, 0x0L, 0x0L, 0x0L
    };
    static final long[] jjbitVec7 = {
            0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
    };
    static final long[] jjbitVec8 = {
            0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
    };

    private int jjMoveNfa_0(int startState, int curPos) {
        int strKind = jjmatchedKind;
        int strPos = jjmatchedPos;
        int seenUpto;
        input_stream.backup(seenUpto = curPos + 1);
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            throw new Error("Internal Error");
        }
        curPos = 0;
        int startsAt = 0;
        jjnewStateCnt = 46;
        int i = 1;
        jjstateSet[0] = startState;
        int kind = 0x7fffffff;
        for (; ;) {
            if (++jjround == 0x7fffffff)
                ReInitRounds();
            if (curChar < 64) {
                long l = 1L << curChar;
                do {
                    switch (jjstateSet[--i]) {
                        case 9:
                            if ((0x3ff000000000000L & l) != 0L) {
                                if (kind > 78)
                                    kind = 78;
                                jjCheckNAddStates(0, 10);
                            } else if (curChar == 39)
                                jjCheckNAddStates(11, 15);
                            else if (curChar == 36) {
                                if (kind > 84)
                                    kind = 84;
                                jjCheckNAdd(15);
                            } else if (curChar == 46)
                                jjCheckNAdd(1);
                            break;
                        case 0:
                            if (curChar == 46)
                                jjCheckNAdd(1);
                            break;
                        case 1:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddStates(16, 18);
                            break;
                        case 3:
                            if ((0x280000000000L & l) != 0L)
                                jjCheckNAdd(4);
                            break;
                        case 4:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddTwoStates(4, 5);
                            break;
                        case 14:
                            if (curChar != 36)
                                break;
                            if (kind > 84)
                                kind = 84;
                            jjCheckNAdd(15);
                            break;
                        case 15:
                            if ((0x3ff001000000000L & l) == 0L)
                                break;
                            if (kind > 84)
                                kind = 84;
                            jjCheckNAdd(15);
                            break;
                        case 16:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 78)
                                kind = 78;
                            jjCheckNAddStates(0, 10);
                            break;
                        case 17:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 78)
                                kind = 78;
                            jjCheckNAddTwoStates(17, 18);
                            break;
                        case 19:
                            if ((0x3ff000000000000L & l) != 0L)
                                jjCheckNAddTwoStates(19, 0);
                            break;
                        case 20:
                            if ((0x3ff000000000000L & l) != 0L)
                                jjCheckNAddTwoStates(20, 21);
                            break;
                        case 21:
                            if (curChar != 46)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddTwoStates(22, 5);
                            break;
                        case 23:
                            if ((0x280000000000L & l) != 0L)
                                jjCheckNAdd(24);
                            break;
                        case 24:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddTwoStates(24, 5);
                            break;
                        case 25:
                            if ((0x3ff000000000000L & l) != 0L)
                                jjCheckNAddTwoStates(25, 26);
                            break;
                        case 27:
                            if ((0x280000000000L & l) != 0L)
                                jjCheckNAdd(28);
                            break;
                        case 28:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddTwoStates(28, 5);
                            break;
                        case 29:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddStates(19, 21);
                            break;
                        case 31:
                            if ((0x280000000000L & l) != 0L)
                                jjCheckNAdd(32);
                            break;
                        case 32:
                            if ((0x3ff000000000000L & l) == 0L)
                                break;
                            if (kind > 79)
                                kind = 79;
                            jjCheckNAddTwoStates(32, 5);
                            break;
                        case 33:
                            if (curChar == 39)
                                jjCheckNAddStates(11, 15);
                            break;
                        case 34:
                            if (curChar == 39)
                                jjCheckNAddStates(22, 24);
                            break;
                        case 35:
                            if (curChar == 39)
                                jjstateSet[jjnewStateCnt++] = 34;
                            break;
                        case 36:
                            if ((0xffffff7fffffffffL & l) != 0L)
                                jjCheckNAddStates(22, 24);
                            break;
                        case 37:
                            if (curChar == 39 && kind > 81)
                                kind = 81;
                            break;
                        case 38:
                            if ((0xffffff7fffffdbffL & l) != 0L)
                                jjCheckNAdd(39);
                            break;
                        case 39:
                            if (curChar == 39 && kind > 82)
                                kind = 82;
                            break;
                        case 41:
                            if (curChar == 39)
                                jjCheckNAdd(39);
                            break;
                        case 42:
                            if ((0xff000000000000L & l) != 0L)
                                jjCheckNAddTwoStates(43, 39);
                            break;
                        case 43:
                            if ((0xff000000000000L & l) != 0L)
                                jjCheckNAdd(39);
                            break;
                        case 44:
                            if ((0xf000000000000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 45;
                            break;
                        case 45:
                            if ((0xff000000000000L & l) != 0L)
                                jjCheckNAdd(43);
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 9:
                            if ((0x7fffffe87fffffeL & l) != 0L) {
                                if (kind > 84)
                                    kind = 84;
                                jjCheckNAdd(15);
                            }
                            if ((0x4000000040L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 12;
                            else if ((0x10000000100000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 8;
                            break;
                        case 2:
                            if ((0x2000000020L & l) != 0L)
                                jjAddStates(25, 26);
                            break;
                        case 5:
                            if ((0x5000000050L & l) != 0L && kind > 79)
                                kind = 79;
                            break;
                        case 6:
                            if ((0x2000000020L & l) != 0L && kind > 83)
                                kind = 83;
                            break;
                        case 7:
                            if ((0x20000000200000L & l) != 0L)
                                jjCheckNAdd(6);
                            break;
                        case 8:
                            if ((0x4000000040000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 7;
                            break;
                        case 10:
                            if ((0x8000000080000L & l) != 0L)
                                jjCheckNAdd(6);
                            break;
                        case 11:
                            if ((0x100000001000L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 10;
                            break;
                        case 12:
                            if ((0x200000002L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 11;
                            break;
                        case 13:
                            if ((0x4000000040L & l) != 0L)
                                jjstateSet[jjnewStateCnt++] = 12;
                            break;
                        case 14:
                        case 15:
                            if ((0x7fffffe87fffffeL & l) == 0L)
                                break;
                            if (kind > 84)
                                kind = 84;
                            jjCheckNAdd(15);
                            break;
                        case 18:
                            if ((0x100000001000L & l) != 0L && kind > 78)
                                kind = 78;
                            break;
                        case 22:
                            if ((0x2000000020L & l) != 0L)
                                jjAddStates(27, 28);
                            break;
                        case 26:
                            if ((0x2000000020L & l) != 0L)
                                jjAddStates(29, 30);
                            break;
                        case 30:
                            if ((0x2000000020L & l) != 0L)
                                jjAddStates(31, 32);
                            break;
                        case 36:
                            jjAddStates(22, 24);
                            break;
                        case 38:
                            if ((0xffffffffefffffffL & l) != 0L)
                                jjCheckNAdd(39);
                            break;
                        case 40:
                            if (curChar == 92)
                                jjAddStates(33, 35);
                            break;
                        case 41:
                            if ((0x14404410000000L & l) != 0L)
                                jjCheckNAdd(39);
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            } else {
                int hiByte = (int) (curChar >> 8);
                int i1 = hiByte >> 6;
                long l1 = 1L << (hiByte & 077);
                int i2 = (curChar & 0xff) >> 6;
                long l2 = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                        case 9:
                        case 15:
                            if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                                break;
                            if (kind > 84)
                                kind = 84;
                            jjCheckNAdd(15);
                            break;
                        case 36:
                            if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                                jjAddStates(22, 24);
                            break;
                        case 38:
                            if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                                jjstateSet[jjnewStateCnt++] = 39;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            }
            if (kind != 0x7fffffff) {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 0x7fffffff;
            }
            ++curPos;
            if ((i = jjnewStateCnt) == (startsAt = 46 - (jjnewStateCnt = startsAt)))
                break;
            try {
                curChar = input_stream.readChar();
            }
            catch (java.io.IOException e) {
                break;
            }
        }
        if (jjmatchedPos > strPos)
            return curPos;

        int toRet = Math.max(curPos, seenUpto);

        if (curPos < toRet)
            for (i = toRet - Math.min(curPos, seenUpto); i-- > 0;)
                try {
                    curChar = input_stream.readChar();
                }
                catch (java.io.IOException e) {
                    throw new Error("Internal Error : Please send a bug report.");
                }

        if (jjmatchedPos < strPos) {
            jjmatchedKind = strKind;
            jjmatchedPos = strPos;
        } else if (jjmatchedPos == strPos && jjmatchedKind > strKind)
            jjmatchedKind = strKind;

        return toRet;
    }

    static final int[] jjnextStates = {
            17, 18, 19, 0, 20, 21, 25, 26, 29, 30, 5, 35, 36, 37, 38, 40,
            1, 2, 5, 29, 30, 5, 35, 36, 37, 3, 4, 23, 24, 27, 28, 31,
            32, 41, 42, 44,
    };

    private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return ((jjbitVec2[i2] & l2) != 0L);
            case 48:
                return ((jjbitVec3[i2] & l2) != 0L);
            case 49:
                return ((jjbitVec4[i2] & l2) != 0L);
            case 51:
                return ((jjbitVec5[i2] & l2) != 0L);
            case 61:
                return ((jjbitVec6[i2] & l2) != 0L);
            default:
                if ((jjbitVec0[i1] & l1) != 0L)
                    return true;
                return false;
        }
    }

    private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return ((jjbitVec8[i2] & l2) != 0L);
            default:
                if ((jjbitVec7[i1] & l1) != 0L)
                    return true;
                return false;
        }
    }

    /**
     * Token literal values.
     */
    public static final String[] jjstrLiteralImages = {
            "", null, null, null, null, "\54", "\56", "\75", "\74\76", "\76", "\76\75",
            "\74", "\74\75", "\53", "\55", "\52", "\57", null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "\50", "\51", "\72", "\77",};

    /**
     * Lexer state names.
     */
    public static final String[] lexStateNames = {
            "DEFAULT",
    };
    static final long[] jjtoToken = {
            0xffffffffffffffe1L, 0x79effffL,
    };
    static final long[] jjtoSkip = {
            0x1eL, 0x0L,
    };
    protected JavaCharStream input_stream;
    private final int[] jjrounds = new int[46];
    private final int[] jjstateSet = new int[92];
    protected char curChar;

    /**
     * Constructor.
     */
    public MQLTokenManager(JavaCharStream stream) {
        if (JavaCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
        input_stream = stream;
    }

    /**
     * Constructor.
     */
    public MQLTokenManager(JavaCharStream stream, int lexState) {
        this(stream);
        SwitchTo(lexState);
    }

    /**
     * Reinitialise parser.
     */
    public void ReInit(JavaCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    private void ReInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 46; i-- > 0;)
            jjrounds[i] = 0x80000000;
    }

    /**
     * Reinitialise parser.
     */
    public void ReInit(JavaCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    /**
     * Switch to specified lex state.
     */
    public void SwitchTo(int lexState) {
        if (lexState >= 1 || lexState < 0)
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
        else
            curLexState = lexState;
    }

    protected Token jjFillToken() {
        final Token t;
        final String curTokenImage;
        final int beginLine;
        final int endLine;
        final int beginColumn;
        final int endColumn;
        String im = jjstrLiteralImages[jjmatchedKind];
        curTokenImage = (im == null) ? input_stream.GetImage() : im;
        beginLine = input_stream.getBeginLine();
        beginColumn = input_stream.getBeginColumn();
        endLine = input_stream.getEndLine();
        endColumn = input_stream.getEndColumn();
        t = Token.newToken(jjmatchedKind, curTokenImage);

        t.beginLine = beginLine;
        t.endLine = endLine;
        t.beginColumn = beginColumn;
        t.endColumn = endColumn;

        return t;
    }

    int curLexState = 0;
    int defaultLexState = 0;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    /**
     * Get the next Token.
     */
    public Token getNextToken() {
        Token matchedToken;
        int curPos = 0;

        EOFLoop:
        for (; ;) {
            try {
                curChar = input_stream.BeginToken();
            }
            catch (java.io.IOException e) {
                jjmatchedKind = 0;
                matchedToken = jjFillToken();
                return matchedToken;
            }

            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_0();
            if (jjmatchedKind != 0x7fffffff) {
                if (jjmatchedPos + 1 < curPos)
                    input_stream.backup(curPos - jjmatchedPos - 1);
                if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                    matchedToken = jjFillToken();
                    return matchedToken;
                } else {
                    continue EOFLoop;
                }
            }
            int error_line = input_stream.getEndLine();
            int error_column = input_stream.getEndColumn();
            String error_after = null;
            boolean EOFSeen = false;
            try {
                input_stream.readChar();
                input_stream.backup(1);
            }
            catch (java.io.IOException e1) {
                EOFSeen = true;
                error_after = curPos <= 1 ? "" : input_stream.GetImage();
                if (curChar == '\n' || curChar == '\r') {
                    error_line++;
                    error_column = 0;
                } else
                    error_column++;
            }
            if (!EOFSeen) {
                input_stream.backup(1);
                error_after = curPos <= 1 ? "" : input_stream.GetImage();
            }
            throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
        }
    }

    private void jjCheckNAdd(int state) {
        if (jjrounds[state] != jjround) {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    private void jjAddStates(int start, int end) {
        do {
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        } while (start++ != end);
    }

    private void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    private void jjCheckNAddStates(int start, int end) {
        do {
            jjCheckNAdd(jjnextStates[start]);
        } while (start++ != end);
    }

}
